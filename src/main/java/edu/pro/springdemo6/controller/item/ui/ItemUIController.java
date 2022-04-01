package edu.pro.springdemo6.controller.item.ui;
/*
  @author   george
  @project   spring-demo6
  @class  ItemUIController
  @version  1.0.0 
  @since 01.04.22 - 20.08
*/

import edu.pro.springdemo6.model.Item;
import edu.pro.springdemo6.service.ItemService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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




}
