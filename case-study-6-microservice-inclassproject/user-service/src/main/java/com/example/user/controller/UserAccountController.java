package com.example.user.controller;

import com.example.user.dto.UserAccountDTO;
import com.example.user.exception.UserAccountNotCreatedException;
import com.example.user.exception.UserAccountNotFoundException;
import com.example.user.service.UserAccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/user")
public class UserAccountController {

    @Autowired
    UserAccountService userAccountService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createUserAccount(@RequestBody @Valid UserAccountDTO userAccountDTO) throws UserAccountNotCreatedException{
    	userAccountService.createUserAccount(userAccountDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<UserAccountDTO> getUserAccountById(@PathVariable("id") Long id) throws UserAccountNotFoundException{
        UserAccountDTO userAccountDTO = userAccountService.getUserAccountById(id);
        if(userAccountDTO != null){
            return new ResponseEntity<UserAccountDTO>(userAccountDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
