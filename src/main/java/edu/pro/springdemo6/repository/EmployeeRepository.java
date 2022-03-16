package edu.pro.springdemo6.repository;
/*
  @author   george
  @project   spring-demo6
  @class  EmployeeRepository
  @version  1.0.0 
  @since 15.03.22 - 12.39
*/

import edu.pro.springdemo6.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, Integer> {
}
