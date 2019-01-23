package com.example.user.dto;

import java.util.Set;

import com.example.user.dto.UserAccountDTO.UserAccountDTOBuilder;
import com.example.user.model.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class RoleDTO {
	
	public String role;

}
