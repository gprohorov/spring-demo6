package edu.pro.springdemo6.controller;
/*
  @author   george
  @project   spring-demo6
  @class  HelloController
  @version  1.0.0 
  @since 11.02.22 - 20.25
*/

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class HelloController {

    @GetMapping("/hello")
    String sayHello(){

        String out = "<h2> Hello, Spring Controller </h2>";
        int year = LocalDate.now().getYear();
        out += year;
        return out;
    }



}
