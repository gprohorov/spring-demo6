package edu.pro.springdemo6.controller.item.api;
/*
  @author   george
  @project   spring-demo6
  @class  ItemRestController
  @version  1.0.0 
  @since 17.02.22 - 18.16  https://www.bootdey.com/snippets/view/bs4-contact-cards
*/

import edu.pro.springdemo6.model.Item;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/items")
public class ItemRestController {

    private LocalDateTime now = LocalDateTime.now();
    private List<Item> items = new ArrayList<>(
            Arrays.asList(
                    new Item("0", "item1", "descr0", now, null),
                    new Item("1", "item1", "descr1", now, null),
                    new Item("2", "item2", "descr2", now, null)
            )
    );

    //  CreateReadUpdateDelete



    @GetMapping("/")
    public List<Item> getAll(){
        return items;
    }

    @GetMapping("/{id}")
    public Item get(@PathVariable(value = "id") String id){
        return items.stream().filter(item -> item.getId().equals(id))
                .findFirst().get();
    }

    @PostMapping("/{id}")
    public Item create(@PathVariable(value = "id") String id){
        return items.stream().filter(item -> item.getId().equals(id))
                .findFirst().get();
    }




    @GetMapping("/delete/{id}")
    public Item delete(@PathVariable(value = "id") String id){

        Item itemToDelete = items.stream().filter(item -> item.getId().equals(id))
                .findFirst().get();
        boolean succes = items.remove(itemToDelete);

        return  (succes) ? itemToDelete : null;
    }



}
