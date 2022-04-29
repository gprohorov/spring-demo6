package edu.pro.springdemo6.controller.item.ui;
/*
  @author   george
  @project   spring-demo6
  @class  ItemUIController
  @version  1.0.0 
  @since 01.04.22 - 20.08
*/

import edu.pro.springdemo6.form.ItemForm;
import edu.pro.springdemo6.model.DaysOfWeek;
import edu.pro.springdemo6.model.Item;
import edu.pro.springdemo6.service.ItemService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/ui/v1/items")
public class ItemUIController {

    @Autowired
    ItemService service;

    @GetMapping("/")
    public String getAll(Model model){

        List<Item> list = service.getAllItems();

        model.addAttribute("items", list);


        return "items";
    }

    @GetMapping("/delete/{id}")
    public String getAll(Model model, @PathVariable  String id){
        service.delete(id);
        return "redirect:/ui/v1/items/";
    }




    @RequestMapping(value = "", method = RequestMethod.GET)
    public String addItem(Model model){
        ItemForm itemForm = new ItemForm();
        List<DaysOfWeek> days = Arrays.asList(DaysOfWeek.values());

        model.addAttribute("form", itemForm);
        model.addAttribute("days", days);
        return "add-item";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String addItem( @ModelAttribute("form") ItemForm form ){
        Item item = new Item();
        item.setName(form.getName());
        item.setDescription(form.getDescription());
        item.setDay(form.getDay());
        LocalDateTime ldt = LocalDateTime.now();
        item.setCreatedAt(ldt);
        item.setUpdatedAt(ldt);
        service.create(item);

        return "redirect:/ui/v1/items/";
    }


    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editItem(Model model, @PathVariable("id") String id){
         Item item = service.getOneById(id);
         ItemForm itemForm = new ItemForm();
         itemForm.setId(item.getId());
         itemForm.setName(item.getName());
         itemForm.setDescription(item.getDescription());
         itemForm.setCreatedAt(item.getCreatedAt().toString());

         model.addAttribute("form",itemForm);

        return "edit-item";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String editItem(@PathVariable("id") String id,
                           @ModelAttribute("form") ItemForm form ){
        Item item = service.getOneById(form.getId());
        item.setName(form.getName());
        item.setDescription(form.getDescription());
        LocalDate date = LocalDate.parse(form.getCreatedAt());
        LocalDateTime ldt = date.atStartOfDay();
        item.setCreatedAt(LocalDate.parse(form.getCreatedAt()).atTime(0,0,0));
        service.update(item);

        return "redirect:/ui/v1/items/";
    }







}
