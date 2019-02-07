package com.example.demo.medium;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping
	public List<User> getAllUser(){
		return userService.getAllUser();
	}
	
	@PostMapping
	public void setUser(@RequestBody User user) {
		userService.setUser(user);
	}
	
	@PutMapping
	public void updateUser(@RequestBody User user) {
		userService.updateUser(user);
	}

}
