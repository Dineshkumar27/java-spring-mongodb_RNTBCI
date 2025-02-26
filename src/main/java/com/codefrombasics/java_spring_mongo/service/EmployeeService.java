package com.codefrombasics.java_spring_mongo.service;

import com.codefrombasics.java_spring_mongo.model.Employee;

import java.util.List;

public interface EmployeeService {
    String save(Employee employee);
    List<Employee> getEmployees();
}

