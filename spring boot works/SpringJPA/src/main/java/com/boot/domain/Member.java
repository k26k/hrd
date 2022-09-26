package com.boot.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Member {

	@Id
	@Column(name="MEMBER_ID")
	private String id;
	
	private String password;
	private String name;
	private String role;
	
}
