package com.example.demo;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Address;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@SpringBootApplication
public class MappingServiceApplication implements CommandLineRunner{
	
	@Autowired
	UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(MappingServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		/*
		 * Address address = new Address(); address.setCity("mumbai");
		 * address.setState("maharashtra");
		 * 
		 * User user = new User(); user.setUserName("Sachin"); user.setAddress(address);
		 * 
		 * userRepository.save(user);
		 */
		
		System.out.println("========DONE=========");
	}

}

