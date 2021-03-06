package com.example.user.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.dto.UserAccountDTO;
import com.example.user.model.UserAccount;

@RestController
@RequestMapping("api/admin")
public class AdminAccountController {
	
	@Autowired 
	ModelMapper modelMapper;
	
	@GetMapping
	public UserAccountDTO getAdmin(){
		UserAccount userAccount = UserAccount.builder()
				.firstName("My First Name Is Admin")
				.lastName("My Last Name Is Admin")
				.active(true)
				.build();
		return modelMapper.map(userAccount, UserAccountDTO.class);
	}

}
