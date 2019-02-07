package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.user.model.User;
import com.example.demo.user.repository.UserRepository;

@SpringBootApplication
public class SecurityServiceMysqlApplication implements CommandLineRunner{

	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Autowired
	UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SecurityServiceMysqlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Create ADMIN + USER
				
		Optional<User> user = userRepository.findByEmail("admin@gmail.com");
		if(!user.isPresent()) {
			System.out.println("ADMIN NOT EXISTS WITH EMAIl 'admin@gmail.com', going to create");
			userRepository.save(new User(1, "admin@gmail.com", encoder.encode("password"), "ADMIN"));
			System.out.println("-------------DEFAULT ADMIN CREATED-------------");
		}
		else {
			System.out.println("-------------DEFAULT ADMIN ALREADY CREATED-------------");
		}
		
		Optional<User> user2 = userRepository.findByEmail("johnny@gmail.com");
		if(!user2.isPresent()) {
			System.out.println("USER NOT EXISTS WITH EMAIL 'johnny@gmail.com', going to create");
			userRepository.save(new User(2, "johnny@gmail.com", encoder.encode("password"), "USER"));
			System.out.println("-------------DEFAULT USER CREATED-------------");
		}
		else {
			System.out.println("-------------DEFAULT USER ALREADY CREATED-------------");
		}
		
	}

}
