package edu.pro.springdemo6.controller.item.api;
/*
  @author   george
  @project   spring-demo6
  @class  ItemRestController
  @version  1.0.0 
  @since 17.02.22 - 18.16  https://www.bootdey.com/snippets/view/bs4-contact-cards
*/

import edu.pro.springdemo6.model.Item;
import edu.pro.springdemo6.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/items")
public class ItemRestController {

    @Autowired
    ItemService service;


    @GetMapping("/")
    public List<Item> getAll(){
        return service.getAllItems();
    }


    @GetMapping("/{id}")
    public Item get(@PathVariable(value = "id") String id){
        return service.getOneById(id);
    }

    @PostMapping("/")
    public Item create(@RequestBody Item item){
       return service.create(item);
    }

/*


    @GetMapping("/delete/{id}")
    public Item delete(@PathVariable(value = "id") String id){

        Item itemToDelete = items.stream().filter(item -> item.getId().equals(id))
                .findFirst().get();
        boolean succes = items.remove(itemToDelete);

        return  (succes) ? itemToDelete : null;
    }
*/




}
