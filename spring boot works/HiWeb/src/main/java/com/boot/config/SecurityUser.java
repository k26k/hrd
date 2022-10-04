package com.boot.config;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import com.boot.domain.Member;

public class SecurityUser extends User {
	
	private static final long serialVersionUID = 1L;

	private Member member;
	
	public SecurityUser(Member member) {
		super(	member.getId(), member.getPassword(), 
				AuthorityUtils.createAuthorityList(member.getRole().toString()));
		this.member = member;
	}
	
//	패스워드 인코딩 전 member.password에 noop적용
//	public SecurityUser(Member member) {
//		super(	member.getId(), "{noop}"+member.getPassword(), 
//				AuthorityUtils.createAuthorityList(member.getRole().toString()));
//		this.member = member;
//	}
	
	public Member getMember() {
		return member;
	}
	
}
