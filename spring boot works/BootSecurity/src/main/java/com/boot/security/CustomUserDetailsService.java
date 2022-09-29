package com.boot.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.boot.domain.Member;
import com.boot.persistence.MemberRepository;

@Service
public class CustomUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

	@Autowired
	private MemberRepository memberRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<Member> optional = memberRepository.findById(username);
		if(!optional.isPresent()) {
			throw new UsernameNotFoundException("!! 사용자 없음 id: "+username);
		}else {
			Member member = optional.get();
			return new SecurityUser(member);
		}
	}

}
