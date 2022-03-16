package edu.pro.springdemo6.controller.employee.api;
/*
  @author   george
  @project   spring-demo6
  @class  ItemRestController
  @version  1.0.0 
  @since 17.02.22 - 18.16
*/

import edu.pro.springdemo6.model.Employee;
import edu.pro.springdemo6.model.Item;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeRestController {
    private LocalDateTime now = LocalDateTime.now();
    private List<Employee> employees = new ArrayList<>(
            Arrays.asList(
                    new Employee(1,
                            "John",
                            "john-lennon@gmail.com",
                            " Designer", "433334344332",
                            "https://bootdey.com/img/Content/avatar/avatar6.png",
                            "6777"),
                    new Employee(2,
                            "emp2",
                            "descr2",
                            " now", "null",
                            "https://bootdey.com/img/Content/avatar/avatar7.png",
                            "6777")

            )
    );

    //  CreateReadUpdateDelete



    @GetMapping("/")
    public List<Employee> getAll(){
        return employees;
    }


//    @GetMapping("/{id}")
//    public Item get(@PathVariable(value = "id") String id){
//        return items.stream().filter(item -> item.getId().equals(id))
//                .findFirst().get();
//    }
//
//    @PostMapping("/{id}")
//    public Item create(@PathVariable(value = "id") String id){
//        return items.stream().filter(item -> item.getId().equals(id))
//                .findFirst().get();
//    }
//
//
//
//
//    @GetMapping("/delete/{id}")
//    public Item delete(@PathVariable(value = "id") String id){
//
//        Item itemToDelete = items.stream().filter(item -> item.getId().equals(id))
//                .findFirst().get();
//        boolean succes = items.remove(itemToDelete);
//
//        return  (succes) ? itemToDelete : null;
//    }



}
