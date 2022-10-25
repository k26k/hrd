package com.boot.SecurityConfig;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.boot.entity.Member;
import com.boot.repository.MemberRepository;

@Service
public class SecurityUserDetailsService{}
//implements UserDetailsService {
//
//	@Autowired
//	private MemberRepository memberRepository;
//	
//	@Override
//	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//		System.out.println("로그인 시도 email: "+email);
//		Optional<Member> optional = memberRepository.findByEmail(email);
//		if(optional.isEmpty()) {
//			throw new UsernameNotFoundException("!! 사용자 없음 email: "+email);
//		}
//		Member member = optional.get();
//		return new SecurityUser(member);
//	}
//
//}
