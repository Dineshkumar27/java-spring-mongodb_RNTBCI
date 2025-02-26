package com.codefrombasics.java_spring_mongo.service;

import com.codefrombasics.java_spring_mongo.model.Employee;
import com.codefrombasics.java_spring_mongo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements  EmployeeService{


    EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public EmployeeServiceImpl() {
    }
    @Override
    public String save(Employee employee) {
        return employeeRepository.save(employee).getId();
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }
}
