package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@Data
@RestController
public class CricketTeamController {

	private List<String> members; 			//props
	private String players;					//props
	@Value("${server.port}")
	private int port;						//args
	private String profile; 				//Env
	private String coach;
	
	@Value("${cricket-team.members}")
	public void setMembers(String members) {
		this.members = Arrays.asList(members.split(","));
	}
	
	@Value("${spring.profiles.active}")
	public void setActiveProfile(String profile) {
		this.profile = profile;
	}
	
	@Autowired
	public void setProjectProperties(CricketTeamProperties cricketTeamProperties) {
		this.players = cricketTeamProperties.getPlayers();
	}
	
	@Autowired
	public void setCoach(Environment environment) {
		this.coach = environment.getProperty("cricket-team.coach");
	}
	
	@GetMapping("props")
	public CricketTeamController get() {
		return this;
	}
	
	
}
