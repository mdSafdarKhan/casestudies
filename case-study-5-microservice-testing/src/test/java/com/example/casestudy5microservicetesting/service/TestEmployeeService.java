package com.example.casestudy5microservicetesting.service;

import com.example.casestudy5microservicetesting.model.Employee;
import com.example.casestudy5microservicetesting.repository.EmployeeRepository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class TestEmployeeService {

    @InjectMocks
    EmployeeService employeeService;

    @Mock
    EmployeeRepository employeeRepository;

    /*@TestConfiguration
    static class EmployeeServiceContextConfiguration{

        @Bean
        public EmployeeService employeeService(){
            System.out.println("employeeService");
            return new EmployeeService();
        }
    }*/

   /* @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }*/

    /*@Before
    public void setup(){
        System.out.println("setup");
        Employee employee = Employee.builder()
                .id(1L)
                .name("Alex")
                .designation("Engineer")
                .salary(10000L)
                .build();
        System.out.println("employee created");

        savedEmployee = employeeRepository.save(employee);
        System.out.println("savedEmployee");
    }*/

    @Test
    public void whenValidIdPassed_thenEmployeeShouldBeReturned(){

        //Given
        Employee employee = Employee.builder()
                .id(1L)
                .name("Bob")
                .designation("Engineer")
                .salary(10000L)
                .build();

        Mockito.when(employeeRepository.findByName("Bob")).thenReturn(employee);

        Employee employee1 = employeeService.getEmployee("Bob");

        Assertions.assertThat(employee1.getName()).isEqualTo(employee.getName());
    }
}
