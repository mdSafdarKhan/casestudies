package com.javatechie.spring.security.api.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="users", catalog="learning")
public class User {
	@Id
	private int id;
	private String username;
	private String password;
	private String email;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", 
				joinColumns = {@JoinColumn(name = "user_id", referencedColumnName="ID")}, 
				inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName="ID")})
	private Set<Role> roles;

}
