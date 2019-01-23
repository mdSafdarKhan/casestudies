package com.example.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class AppSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		
		//.authorizeRequests().anyRequest().fullyAuthenticated().and().httpBasic();
		
		//.authorizeRequests().antMatchers("/api/admin/**").fullyAuthenticated().and().httpBasic();
		
		.authorizeRequests().antMatchers("/api/admin/**").hasRole("ADMIN").anyRequest().fullyAuthenticated().and().httpBasic();
	}
	
	// Rather it is deprecated, can use BCryptPassword class
	
	  @Bean public static NoOpPasswordEncoder noOpPasswordEncoder() { return
	  (NoOpPasswordEncoder)NoOpPasswordEncoder.getInstance(); }
	 

}
