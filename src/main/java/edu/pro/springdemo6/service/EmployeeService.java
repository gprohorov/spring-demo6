package edu.pro.springdemo6.service;
/*
  @author   george
  @project   spring-demo6
  @class  EmployeeService
  @version  1.0.0 
  @since 15.03.22 - 12.40
*/

import edu.pro.springdemo6.model.Employee;
import edu.pro.springdemo6.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {
    private List<Employee> list = new ArrayList<>(
            Arrays.asList(
                    new Employee(1, "John","john-lennon","Java Dev", "050-5374412","url","001"),
                    new Employee(2, "Paul","paul","UI-dev", "050-5374412","url","002"),
                    new Employee(3, "Richard","ringo","tester", "050-5374412","url","003")
            )
    );
    
    @Autowired
    EmployeeRepository repository;

    @PostConstruct
    void  init(){
        repository.saveAll(list);
    }
}
