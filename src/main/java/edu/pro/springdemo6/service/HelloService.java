package edu.pro.springdemo6.service;
/*
  @author   george
  @project   spring-demo6
  @class  HelloService
  @version  1.0.0 
  @since 02.03.22 - 21.42
*/

import edu.pro.springdemo6.model.Hello;
import edu.pro.springdemo6.repository.HelloMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class HelloService {

    private List<Hello> list = new ArrayList<>(
            Arrays.asList(
                    new Hello("1", "John", "Paul","Hi, Paul!"),
                    new Hello("2", "Ringo", "George","Hi, George!"),
                    new Hello("3", "John", "Ringo","Hi, Ringo!"),
                    new Hello("4", "Freddy", "Ringo","Hi, Ringo!")
            )
    );

    @Autowired
    HelloMongoRepository repository;

   // @PostConstruct
    void init(){
        repository.saveAll(list);
    }

    public List<Hello> getAll(){
        return repository.findAll();
    }

    public Hello get(String id){
        return repository.findById(id).orElse(null);
    }

    public Hello create(Hello hello){



      return repository.save(hello);
    }

    public List<Hello> getAllFrom(String str){
        return repository.findAllByFromContaining(str);
    }



}
