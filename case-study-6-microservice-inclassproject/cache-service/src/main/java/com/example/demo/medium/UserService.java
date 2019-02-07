package com.example.demo.medium;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Cacheable("users")
	public List<User> getAllUser() {
		return userRepository.findAll();
	}
	
	public void setUser(User user) {
		userRepository.save(user);
	}
	
	@CachePut("users")
	public void updateUser(User user) {
		userRepository.save(user);
	}

}
