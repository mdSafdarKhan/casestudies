package com.example.casestudy5microservicetesting.service;

import com.example.casestudy5microservicetesting.model.Employee;
import com.example.casestudy5microservicetesting.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee getEmployee(String name){ // 1 -> user with id 1
        return employeeRepository.findByName(name);
    }
}
