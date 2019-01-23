package com.example.user.dto;

import java.util.Set;

import com.example.user.model.Role;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserAccountDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private Boolean active;
    private Set<RoleDTO> roles;

}
