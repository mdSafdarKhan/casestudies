package com.example.user.service;

import com.example.user.dto.RoleDTO;
import com.example.user.dto.UserAccountDTO;
import com.example.user.exception.UserAccountNotCreatedException;
import com.example.user.exception.UserAccountNotFoundException;
import com.example.user.model.Role;
import com.example.user.model.UserAccount;
import com.example.user.repository.UserAccountRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserAccountService {

    @Autowired
    UserAccountRepository userAccountRepository;

    @Autowired
    ModelMapper modelMapper;

    public void createUserAccount(UserAccountDTO userAccountDTO) throws UserAccountNotCreatedException{
        
    	Set<RoleDTO> roleDTOs = userAccountDTO.getRoles();
    	Set<Role> roles = new HashSet<>();
    	for(RoleDTO roleDTO : roleDTOs) {
    		roles.add(Role.builder().role(roleDTO.getRole()).build());
    	}
    	
    	UserAccount userAccount = UserAccount.builder()
        		.firstName(userAccountDTO.getFirstName())
        		.lastName(userAccountDTO.getLastName())
        		.active(true)
        		.roles(roles)
        		.createDate(new Date())
        		.modifiedDate(new Date())
        		.build();
        userAccountRepository.save(userAccount);
    }
    
    public UserAccountDTO getUserAccountById(Long id) throws UserAccountNotFoundException{
        Optional<UserAccount> optionalUser = userAccountRepository.findById(id);
        if(!optionalUser.isPresent()) {
        	throw new UserAccountNotFoundException();
        }
        UserAccount userAccount = optionalUser.get();
        return modelMapper.map(userAccount, UserAccountDTO.class);
    }
}
