package com.boot.security;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import com.boot.domain.Member;

public class SecurityUser extends User{

	private static final long serialVersionUID = 1L;

	public SecurityUser(Member member) {
//		super(	member.getId(), 
//				"{noop}"+member.getPassword(), 
//				AuthorityUtils.createAuthorityList(member.getRole().toString()));
		
//		password를 암호화하여 저장한 경우엔 {noop} 생략
		super(	member.getId(), 
				member.getPassword(), 
				AuthorityUtils.createAuthorityList(member.getRole().toString()));
		
//		System.out.println(member.toString());
	}

}
