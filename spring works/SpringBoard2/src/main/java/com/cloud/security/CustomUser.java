package com.cloud.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.cloud.domain.MemberVO;

import lombok.Getter;

@Getter
public class CustomUser extends User {
	private static final long serialVersionUID = 1L;
	
	private MemberVO memberVO;
	
	public CustomUser(
			String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}
	
	public CustomUser(MemberVO memberVO) {
		super(	memberVO.getUserid(), 
				memberVO.getUserpw(), 
				memberVO.getMemberAuthVoList().stream().map(a-> new SimpleGrantedAuthority(a.getAuth())).collect(Collectors.toList()));
		
		this.memberVO = memberVO;
	}

}
