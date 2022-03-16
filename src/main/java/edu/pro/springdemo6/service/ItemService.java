package edu.pro.springdemo6.service;
/*
  @author   george
  @project   spring-demo6
  @class  ItemService
  @version  1.0.0 
  @since 16.03.22 - 21.20
*/

import edu.pro.springdemo6.model.Item;
import edu.pro.springdemo6.repository.ItemMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ItemService {


    private LocalDateTime now = LocalDateTime.now();
    private List<Item> items = new ArrayList<>(
            Arrays.asList(
                    new Item("0", "item1", "descr0", now, null),
                    new Item("1", "item1", "descr1", now, null),
                    new Item( "item2", "descr2")
            )
    );

    @Autowired
    ItemMongoRepository repository;

 //   @PostConstruct
    void init(){
        repository.saveAll(items);
    }

    public List<Item> getAllItems(){
        return repository.findAll();
    }

    public Item getOneById(String id){
        return repository.findById(id).orElse(null);
    }
    public Item create(Item item){
        item.setCreatedAt(LocalDateTime.now());
        Item itemFromDB = repository.save(item);
        System.out.println(item.getId());
        return itemFromDB;
       // return repository.save(item);
    }

}
