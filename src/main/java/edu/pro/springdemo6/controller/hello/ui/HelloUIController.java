package edu.pro.springdemo6.controller.hello.ui;
/*
  @author   george
  @project   spring-demo6
  @class  HelloUIController
  @version  1.0.0 
  @since 02.03.22 - 22.58
*/

import edu.pro.springdemo6.model.Hello;
import edu.pro.springdemo6.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/ui/v1/hello")
public class HelloUIController {

    @Autowired
    HelloService service;

    @RequestMapping("/all")
    String getAll(Model model){
        List<Hello> items = service.getAll();
        model.addAttribute("items", items);
        return "helloes";
    }

}
