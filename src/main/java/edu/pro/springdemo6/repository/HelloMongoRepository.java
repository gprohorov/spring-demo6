package edu.pro.springdemo6.repository;
/*
  @author   george
  @project   spring-demo6
  @class  HelloMongoRepository
  @version  1.0.0 
  @since 02.03.22 - 21.44
*/

import edu.pro.springdemo6.model.Hello;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HelloMongoRepository extends MongoRepository<Hello, String> {
    List<Hello> findAllByFromContaining(String str);
}
