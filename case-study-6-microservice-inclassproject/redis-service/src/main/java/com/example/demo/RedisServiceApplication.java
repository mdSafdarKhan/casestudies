package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*import com.example.demo.model.User;
*/
@EnableCaching
@SpringBootApplication
public class RedisServiceApplication {

	/*
	 * @Bean JedisConnectionFactory jedisConnectionFactory() { return new
	 * JedisConnectionFactory(); }
	 * 
	 * @Bean RedisTemplate<String, User> redisTemplate(){ RedisTemplate<String,
	 * User> redisTemplate = new RedisTemplate<>();
	 * redisTemplate.setConnectionFactory(jedisConnectionFactory()); return
	 * redisTemplate; }
	 */

	public static void main(String[] args) {
		SpringApplication.run(RedisServiceApplication.class, args);
	}

}

/*
 * @RestController
 * 
 * @RequestMapping("/api/ints") class HomeController {
 * 
 * public static String name = "SAFDAR";
 * 
 * @Cacheable(value="demoNameCache", key="#myKey")
 * 
 * @GetMapping public String getData() { return name; }
 * 
 * 
 * @CachePut(value="demoNameCache", key="#ints")
 * 
 * @PostMapping public void setData(@RequestBody String newName) { name =
 * newName; }
 * 
 * }
 */