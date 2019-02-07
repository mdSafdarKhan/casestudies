package com.example.demo.user;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Long>{
	
	User findByUserName(String name);

}