package com.example.demo;

import org.omg.PortableServer.ThreadPolicyOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/publish")
public class MessageController {

	public static final String TOPIC = "registration-process";
	
	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	
	@GetMapping("/{message}")
	public void publish(@PathVariable(name = "message") String message) {
		kafkaTemplate.send(TOPIC, message);
	}
}
