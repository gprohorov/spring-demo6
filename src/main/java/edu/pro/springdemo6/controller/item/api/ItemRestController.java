package edu.pro.springdemo6.controller.item.api;
/*
  @author   george
  @project   spring-demo6
  @class  ItemRestController
  @version  1.0.0 
  @since 17.02.22 - 18.16  https://www.bootdey.com/snippets/view/bs4-contact-cards
*/

import edu.pro.springdemo6.model.DaysOfWeek;
import edu.pro.springdemo6.model.Item;
import edu.pro.springdemo6.service.ItemService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api/v1/items")
public class ItemRestController {

    @Autowired
    ItemService service;

    @ApiOperation(value = "  Get them all", notes= " ababab galamaga")
    @ApiResponse(code = 200, message = "Successzzzzzzzzzz")
    @GetMapping("/")
    public List<Item> getAll(){
        return service.getAllItems();
    }

    @ApiOperation(value = "  Get one  by Id", notes= " 245254353534")
    @ApiResponse(code = 200, message = "Success")
    @GetMapping("/{id}")
    public Item get(@PathVariable(value = "id") String id){
        return service.getOneById(id);
    }


    @PostMapping("/")
    public Item create(@RequestBody Item item){
       return service.create(item);
    }

    @PostMapping("/all")
    public void createBunch(@RequestBody List<Item> items){
        List<DaysOfWeek> days = Arrays.asList(DaysOfWeek.values());
        Random random = new Random();


        items.stream().forEach(item -> {
            int index = random.nextInt(6);
            System.out.println(index);
            DaysOfWeek day = days.get(index);
            item.setDay(day);
            service.create(item);});
    }

    @PutMapping("/")
    public Item update(@RequestBody Item item){
       return service.update(item);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") String id){
         service.delete(id);
    }

    @GetMapping("/search/name/{str}")
    public List<Item> getAllByName(@PathVariable String str){
        return service.getAllByString(str);
    }

    @GetMapping("/order/name")
    public List<Item> getAllSortedByName(){
        return service.getAllOrderedByName();
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
