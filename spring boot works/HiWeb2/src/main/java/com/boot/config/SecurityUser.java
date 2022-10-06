package com.boot.config;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import com.boot.domain.Member;

public class SecurityUser extends User{
	
	private Member member;
	
	private static final long serialVersionUID = 1L;
	
	public SecurityUser(Member member) {
		super(	member.getUserId(), 
				member.getPassword(), 
				AuthorityUtils.createAuthorityList(member.getRole().toString()));
		
		this.member = member;
		
		System.out.println(member.toString());
	}
	
	public Member getMember() {
		return member;
	}
	
}
