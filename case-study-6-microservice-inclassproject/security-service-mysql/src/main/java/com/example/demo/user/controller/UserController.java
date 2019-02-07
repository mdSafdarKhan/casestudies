
package com.example.demo.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.user.model.User;
import com.example.demo.user.repository.UserRepository;

@RestController
public class UserController {

	@GetMapping("/public")
	public String publicResource() {
		return "Public resource";
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("/secured")
	public String securedResource() {
		return "Secured resource";
	}
}
