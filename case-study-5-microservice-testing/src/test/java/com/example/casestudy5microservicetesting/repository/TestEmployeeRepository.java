package com.example.casestudy5microservicetesting.repository;

import com.example.casestudy5microservicetesting.model.Employee;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestEmployeeRepository {

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    public void whenFindById_thenReturnEmployee(){

        //Given
        Employee employee = Employee.builder()
                .id(1L)
                .name("Alice")
                .designation("Engineer")
                .salary(10000L)
                .build();

        //When
        Optional<Employee> optionalEmployee = employeeRepository.findById(1L);

        //Then
        Assertions.assertThat(optionalEmployee.get().getId()).isEqualTo(employee.getId());
    }
}
