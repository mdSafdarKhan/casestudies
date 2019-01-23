package com.example.casestudy4microservicesecurity.service;

import com.example.casestudy4microservicesecurity.model.UserEntity;
import com.example.casestudy4microservicesecurity.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserEntityService implements UserDetailsService {

    @Autowired
    UserEntityRepository userEntityRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Collection<GrantedAuthority> grantedAuthoritiesList = new ArrayList<>();
        UserEntity userEntity = userEntityRepository.findByUsername(username).get();

        if (userEntity != null) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_SYSTEMADMIN");
            grantedAuthoritiesList.add(grantedAuthority);
            userEntity.setGrantedAuthoritiesList(grantedAuthoritiesList);

            User user = new User(userEntity.getUsername(), userEntity.getPassword(), userEntity.getGrantedAuthoritiesList());
            return user;
        }
        return null;
    }
}
