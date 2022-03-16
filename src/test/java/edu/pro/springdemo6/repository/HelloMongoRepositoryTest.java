package edu.pro.springdemo6.repository;

import edu.pro.springdemo6.model.Hello;
import edu.pro.springdemo6.service.HelloService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
  @author   george
  @project   spring-demo6
  @class  HelloMongoRepositoryTest
  @version  1.0.0 
  @since 13.03.22 - 15.27
*/

public class HelloMongoRepositoryTest {

    @InjectMocks
    @Autowired
    HelloService service;

    @Autowired
    HelloMongoRepository repository;


    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        List<Hello> list = new ArrayList<>(
                Arrays.asList(
                        new Hello("1", "John", "Paul","Hi, Paul!"),
                        new Hello("2", "Ringo", "George","Hi, George!"),
                        new Hello("3", "John", "Ringo","Hi, Ringo!"),
                        new Hello("4", "Freddy", "Ringo","Hi, Ringo!")
                )
        );
        repository.saveAll(list);
    }

    @After
    public  void tearDown() {
        //repository.deleteAll();
    }

    @Test
    public  void findAll() {
        Assert.assertEquals(service.getAll().size(), 4);
    }

    @Test
    public  void findAllByFromContaining() {

    }
}
