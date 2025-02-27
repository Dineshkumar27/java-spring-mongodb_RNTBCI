package com.codefrombasics.java_spring_mongo.repository;

import com.codefrombasics.java_spring_mongo.model.Employee;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmployeeRepository
        extends MongoRepository<Employee,String> {

  List<Employee> findByFirstNameStartsWith(String name);

   @Query(value = "{ 'age' : { $gt : ?0, $lt : ?1 } }",
   fields = "{'address':0}")
   List<Employee> findEmployeeByAgeBetween(Integer min,Integer max);
}
