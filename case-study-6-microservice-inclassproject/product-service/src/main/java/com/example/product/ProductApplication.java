package com.example.product;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ProductApplication {

	@Value("${key}")
	static String key;
	
    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
        System.out.println("Devtools testing..." + key);
    }

}

