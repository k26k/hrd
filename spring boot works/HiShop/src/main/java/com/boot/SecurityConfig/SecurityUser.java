package com.boot.SecurityConfig;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import com.boot.entity.Member;

public class SecurityUser{}
//extends User{
//	
//	private Member member;
//	
//	private static final long serialVersionUID = 1L;
//	
//	public SecurityUser(Member member) {
//		super(	member.getEmail(), 
//				member.getPassword(), 
//				AuthorityUtils.createAuthorityList("RULE_"+member.getRole().toString()));
//		
//		this.member = member;
//		
//		System.out.println("SecurityUser member: "+member.toString());
//	}
//	
//	public Member getMember() {
//		return member;
//	}
//	
//}
