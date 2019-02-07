package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KafkaServiceApplication implements CommandLineRunner{

	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(KafkaServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		sendMessage("Message through kafka");
	}
	
	public void sendMessage(String message) {
		kafkaTemplate.send("tutorialspoint", message);
	}
	
	@KafkaListener(topics = "tutorialspoint", groupId = "group-id")
	public void listener(String message) {
		System.out.println("Received message in group - group-id: " + message);
	}

}

