package com.boot.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.boot.domain.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemberDto {

	private String userId;
	
	private String password;
	
	private String name;
	
	private Role role;
	
	private boolean enabled; 
	
	private LocalDateTime regDate;
	
	private LocalDateTime modDate;
	
}
