package edu.pro.springdemo6.repository;

import edu.pro.springdemo6.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/*
  @author   george
  @project   spring-demo6
  @class  ItemMongoRepository
  @version  1.0.0 
  @since 16.03.22 - 21.34
*/
@Repository
public interface ItemMongoRepository extends MongoRepository<Item, String> {
    List<Item> findAllByNameAndCreatedAtBetween(String name, LocalDateTime from, LocalDateTime to);

}
