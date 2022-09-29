package com.boot.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Member {

//	기본키 설정
	@Id
	@Column(name = "member_id")
	private String id;
	
	private String password;
	
	private String name;
	
//	문자열
	@Enumerated(EnumType.STRING)	
//	권한 설정
	private Role role;
	
	private boolean enabled;
	
}
