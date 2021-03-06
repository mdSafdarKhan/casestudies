package com.example.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler {

	@ExceptionHandler(UserAccountNotCreatedException.class)
	public ResponseEntity<Object> userAccountNotCreatedException(UserAccountNotCreatedException userNotCreatedException){
		return new ResponseEntity<Object>("User account not created", HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(UserAccountNotFoundException.class)
	public ResponseEntity<Object> userAccountNotCreatedException(UserAccountNotFoundException userAccountNotFoundException){
		return new ResponseEntity<Object>("User account not found", HttpStatus.NOT_FOUND);
	}
}
