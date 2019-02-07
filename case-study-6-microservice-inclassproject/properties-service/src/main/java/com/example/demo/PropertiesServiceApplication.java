package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@SpringBootApplication
public class PropertiesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PropertiesServiceApplication.class, args);
	}

}

