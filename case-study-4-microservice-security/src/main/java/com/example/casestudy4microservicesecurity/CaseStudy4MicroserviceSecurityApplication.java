package com.example.casestudy4microservicesecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ConditionalOnEnabledResourceChain;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableAuthorizationServer
@EnableResourceServer
public class CaseStudy4MicroserviceSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaseStudy4MicroserviceSecurityApplication.class, args);
	}

}

