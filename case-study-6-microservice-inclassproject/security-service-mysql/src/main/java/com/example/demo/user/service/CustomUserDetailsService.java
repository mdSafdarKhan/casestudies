package com.example.demo.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.user.model.CustomUserDetails;
import com.example.demo.user.model.User;
import com.example.demo.user.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("username : " + username);
		
		User user = userRepository
						.findByEmail(username)
						.orElseThrow(() -> new UsernameNotFoundException("Email " + username + " not found"));
		
		System.out.println("user : " + user);
		
		CustomUserDetails customUserDetails = new CustomUserDetails(user);
		System.out.println("customUserDetails : " + customUserDetails);
		
		return customUserDetails;
		
		
	}
}
