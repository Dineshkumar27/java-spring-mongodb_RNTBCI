package com.codefrombasics.java_spring_mongo.service;

import com.codefrombasics.java_spring_mongo.model.Employee;
import io.swagger.v3.oas.models.security.SecurityScheme;

import java.util.List;

public interface EmployeeService {
    String save(Employee employee);
    List<Employee> getEmployees();

    List<Employee> getEmployeeFirstNameStartsWith(String name);

    List<Employee> getEmployeeByAgeBetween(Integer min, Integer max);
}

