package com.cloud.domain;

import lombok.Data;

@Data
public class UserVO {
	
	private String id;
	private String passwd;
	private String name;
	private String role;

}
