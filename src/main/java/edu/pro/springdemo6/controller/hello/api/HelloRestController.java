package edu.pro.springdemo6.controller.hello.api;
/*
  @author   george
  @project   spring-demo6
  @class  HelloRestController
  @version  1.0.0 
  @since 02.03.22 - 21.56
*/

import edu.pro.springdemo6.model.Hello;
import edu.pro.springdemo6.service.HelloService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hello")
@Api(value = "Hello controller")
public class HelloRestController {

    @Autowired
    HelloService service;

    @ApiOperation("GET ALL")
    @ApiResponse(code=200, message = "Successful get all")
    @RequestMapping("/all")
    List<Hello> getAll(){
        return service.getAll();
    }

    @RequestMapping("/{id}")
    Hello getOne(@PathVariable("id") String id){
        return service.get(id);
    }

    @PostMapping("/")
    Hello create(@RequestBody Hello hello){
        return service.create(hello);
    }

}
