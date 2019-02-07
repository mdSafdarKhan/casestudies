package com.example.demo;

import java.util.List;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SpringBootApplication
public class SolrServiceApplication implements CommandLineRunner{

	@Autowired
	EmployeeRepository employeeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SolrServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("------------------Deleting All Documents");
		employeeRepository.deleteAll();
		
		System.out.println("------------------Adding Documents-----------------");
		employeeRepository.save(new Employee(1001L, "Alice", "alice@gmail.com", "Delhi"));
		employeeRepository.save(new Employee(1002L, "Bob", "bob@gmail.com", "Bangluru"));
		employeeRepository.save(new Employee(1003L, "Peter", "peter@gmail.com", "Mumbai"));
		
		employeeRepository.save(new Employee(1004L, "Peter", "peter@gmail.com", "Kolkata"));
		employeeRepository.save(new Employee(1005L, "John", "john@gmail.com", "Kolkata"));
		
		System.out.println("------------------Getting All Documents-----------------");
		for(Employee employee : employeeRepository.findAll()) {
			System.out.println(employee);
		}
		
		System.out.println("------------------Finding By Name-------------------");
		System.out.println(employeeRepository.findByName("Peter"));
		
		System.out.println("------------------Finding By Email-------------------");
		System.out.println(employeeRepository.findByEmail("peter@gmail.com"));
		
		System.out.println("------------------Finding By Address------------------");
		System.out.println(employeeRepository.findByAddress("Kolkata"));
	}

}

@Data
@NoArgsConstructor
@SolrDocument(solrCoreName = "employee")
class Employee{
	
	public Employee(Long id, String name, String email, String address) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
	}

	@Id
	@Indexed(name="id", type="string")
	private Long id;
	
	@Indexed(name="name", type="string")
	private String name;
	
	@Indexed(name="email", type="string")
	private String email;
	
	@Indexed(name="address", type="string")
	private String address;
}

@Repository
interface EmployeeRepository extends SolrCrudRepository<Employee, Long>{
	List<Employee> findByName(String name);
	List<Employee> findByEmail(String email);
	List<Employee> findByAddress(String address);
}

@Configuration
class SolrConfig{
	
	@Bean
	public SolrClient solrClient() {
		return new HttpSolrClient("http://localhost:8983/solr");
	}
	
	@Bean
	public SolrTemplate solrTemplate() {
		return new SolrTemplate(solrClient());
	}
	
}

