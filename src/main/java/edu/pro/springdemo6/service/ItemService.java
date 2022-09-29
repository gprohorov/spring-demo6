package edu.pro.springdemo6.service;
/*
  @author   george
  @project   spring-demo6
  @class  ItemService
  @version  1.0.0 
  @since 16.03.22 - 21.20
*/

import edu.pro.springdemo6.annotation.CustomAnnotation;
import edu.pro.springdemo6.model.Item;
import edu.pro.springdemo6.repository.ItemMongoRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {

    Logger logger = LogManager.getLogger(ItemService.class);

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

    @CustomAnnotation
    public List<Item> getAllItems(){
        logger.info("Entered in getAllItems() method");
        return repository.findAll();
    }

    public Item getOneById(String id){
        logger.info("Entered in getAllItems() method");
        return repository.findById(id).orElse(null);
    }

    public Item create(Item item){
        item.setCreatedAt(LocalDateTime.now());
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
        return this.getAllItems().stream()
                .filter(item -> item.getName().equals(name))
                .collect(Collectors.toList());
    }



}
