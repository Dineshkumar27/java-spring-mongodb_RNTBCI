package com.codefrombasics.java_spring_mongo.controller;

import com.codefrombasics.java_spring_mongo.model.Employee;
import com.codefrombasics.java_spring_mongo.repository.EmployeeRepository;
import com.codefrombasics.java_spring_mongo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {


    private EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public EmployeeController() {
    }

    @PostMapping
    public String save(@RequestBody Employee employee) {

        return employeeService.save(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getEmployees();
    }
    @GetMapping("/emp")
    public List<Employee> getEmployeeByName(@RequestParam("name") String name){
        return employeeService.getEmployeeFirstNameStartsWith(name);

    }
    @GetMapping("/age")
    public List<Employee> getEmployeeByAgeBetween(@RequestParam("min") Integer min,
                                                  @RequestParam("max") Integer max){
        return employeeService.getEmployeeByAgeBetween(min,max);

    }


}
