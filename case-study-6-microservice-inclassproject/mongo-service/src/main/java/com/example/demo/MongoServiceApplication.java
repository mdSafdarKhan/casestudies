package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.user.User;
import com.example.demo.user.UserRepository;

@SpringBootApplication
public class MongoServiceApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(MongoServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("------------Mongo Operation Starts--------------");
		System.out.println("------------Adding Users--------------");
		userRepository.save(new User(1001L, "Safdar", "safdar", true));
		userRepository.save(new User(1002L, "Hasmi", "hashmi", true));
		userRepository.save(new User(1003L, "Khan", "khan", true));
		
		System.out.println("------------Getting Users--------------");
		for(User user : userRepository.findAll()) {
			System.out.println(user);
		}
		
		System.out.println("------------Getting User By Name--------------");
		System.out.println(userRepository.findByUserName("Khan"));
	}

}
