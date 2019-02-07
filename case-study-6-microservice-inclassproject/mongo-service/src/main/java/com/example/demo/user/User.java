package com.example.demo.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Document
public class User {
	
	@Id
	private Long userId;
	private String userName;
	private String password;
	private Boolean active;
	
	

}
