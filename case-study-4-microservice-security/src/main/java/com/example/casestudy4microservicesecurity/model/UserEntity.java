package com.example.casestudy4microservicesecurity.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Collection;

@Data
@Entity
public class UserEntity {

    @Id
    private Long id;
    private String username;
    private String password;

    @ElementCollection
    private Collection<GrantedAuthority> grantedAuthoritiesList = new ArrayList<>();

}
