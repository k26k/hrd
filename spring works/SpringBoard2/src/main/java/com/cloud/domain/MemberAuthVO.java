package com.cloud.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class MemberAuthVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String userid;
	private String auth;
	
}
