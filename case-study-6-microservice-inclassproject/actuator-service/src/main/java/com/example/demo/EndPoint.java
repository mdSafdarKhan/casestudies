package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("myendpoint")
public class EndPoint {
	
	@GetMapping
	public String m1() {
		return "Hello world";
	}

}
