package com.example.demo;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Cleanup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
public class LombokServiceApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(LombokServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setEmail("email@email.com");
		int user1hash = user.hashCode();
		
		System.out.println(user);
		System.out.println(user.getEmail());
		System.out.println(user1hash);
		
		User user2 = new User();
		user2.setEmail("email2@email.com");
		int user2hash = user2.hashCode();
		
		System.out.println(user2);
		System.out.println(user2.getEmail());
		System.out.println(user2hash);
		
		List<User> users = new ArrayList<>();
		users.add(user);
		users.add(user2);
		
		System.out.println(users);
		
		Student student = Student.builder()
				.id(1)
				.name("XYZ")
				.build();
		
		System.out.println(student);
		System.out.println(student.getName());
		System.out.println(student.hashCode());
		
		Student student2 = Student.builder()
				.id(2)
				.name("ABC")
				.build();
		
		System.out.println(student2);
		System.out.println(student2.getName());
		System.out.println(student2.hashCode());
		
		List<Student> students = new ArrayList<>();
		students.add(student);
		students.add(student2);
		
		System.out.println(students);
		
		//new Read().read();
		
		new MyLog().print();
	}

}

@Setter
@Getter
@EqualsAndHashCode
@ToString
class User{
	
	private String email;
	
}

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
class Student{
	
	private int id;
	private String name;
	
}

class Read{

	@SneakyThrows
	public void read() {
		FileInputStream fis = new FileInputStream(new File("akkjkfkf"));
	}
}

@Slf4j
class MyLog{
	
	public void print() {
		log.info("logging through lombok annotations");
	}
}

