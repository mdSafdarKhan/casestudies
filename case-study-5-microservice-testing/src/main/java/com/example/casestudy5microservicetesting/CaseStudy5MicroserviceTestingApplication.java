package com.example.casestudy5microservicetesting;

import com.example.casestudy5microservicetesting.model.Employee;
import com.example.casestudy5microservicetesting.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CaseStudy5MicroserviceTestingApplication implements CommandLineRunner {

	@Autowired
	EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(CaseStudy5MicroserviceTestingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Employee employee = Employee.builder()
				.id(1L)
				.name("Safdar Khan")
				.designation("Senior Software Engineer")
				.salary(1000L)
				.build();
		employeeRepository.save(employee);
	}
}

