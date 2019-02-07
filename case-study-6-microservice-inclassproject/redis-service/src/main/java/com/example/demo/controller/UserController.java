package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping
	public List<User> getAllUser(){
		return userRepository.findAll();
	}
	
	@PostMapping
	public void setUser(@RequestBody User user) {
		User u = new User();
		u.setEmail(user.getEmail());
		u.setName(user.getName());
		userRepository.save(u);
	}
	
	@PutMapping
	public void updateUser(@RequestBody User user) {
		userRepository.save(user);
	}

}
