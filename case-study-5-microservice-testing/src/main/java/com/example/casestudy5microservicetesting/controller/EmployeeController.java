package com.example.casestudy5microservicetesting.controller;

import com.example.casestudy5microservicetesting.model.Employee;
import com.example.casestudy5microservicetesting.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public Employee getEmployee(String name){
        return employeeService.getEmployee(name);
    }
}
