package edu.pro.springdemo6.service;
/*
  @author   george
  @project   spring-demo6
  @class  ItemService
  @version  1.0.0 
  @since 16.03.22 - 21.20
*/

import edu.pro.springdemo6.exception.ApiRequestException;
import edu.pro.springdemo6.model.DaysOfWeek;
import edu.pro.springdemo6.model.Item;
import edu.pro.springdemo6.repository.ItemMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ItemService {


    private LocalDateTime now = LocalDateTime.now();
    private List<Item> items = new ArrayList<>(
            Arrays.asList(
                    new Item("0", "item1", "descr0", DaysOfWeek.FRIDAY,now, now),
                    new Item("1", "item1", "descr1", DaysOfWeek.FRIDAY, now, now),
                    new Item( "2","item2", "descr2",  DaysOfWeek.FRIDAY,now, now)
            )
    );

    @Autowired
    ItemMongoRepository repository;

 // @PostConstruct
    void init(){
        repository.saveAll(items);
    }

    public List<Item> getAllItems(){
        return repository.findAll();
    }

    public Item getOneById(String id){
        return repository.findById(id).orElseThrow( () -> new ApiRequestException("Not Found!"));
    }

    public Item create(Item item){
        item.setCreatedAt(LocalDateTime.now());
       // item.setUpdatedAt(LocalDateTime.now());
        Item itemFromDB = repository.save(item);
        return itemFromDB;
    }

    public Item update(Item item){
        item.setUpdatedAt(LocalDateTime.now());
        return repository.save(item);
    }

    public void delete(String  id){
        repository.deleteById(id);
    }

    public List<Item> getAllByName(String name){

         Map<DaysOfWeek, List<Item>> collect = this.getAllItems().stream().collect(Collectors.groupingBy(Item::getDay));

        return this.getAllItems().stream()
                .filter(item -> item.getName().equals(name))
                .collect(Collectors.toList());
    }

    public List<Item> getAllByString(String str){
//
//      return this.getAllItems().stream()
//                .filter(item -> item.getName().contains(str))
//                .collect(Collectors.toList());
//

        return repository.findAllByNameContaining(str);
    }

    public List<Item> getAllOrderedByName(){

     return this.getAllItems().stream()
              .sorted(Comparator.comparing(Item::getName))
               .collect(Collectors.toList());


 /*       return repository.findAllOrderByNameAsc();  */
    }




}
