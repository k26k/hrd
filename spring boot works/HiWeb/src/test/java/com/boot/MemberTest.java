package com.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.boot.domain.Member;
import com.boot.domain.Role;
import com.boot.repository.MemberRepository;

@SpringBootTest
public class MemberTest {

	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
//	@Test
	public void createMember() {
		Member member1 = new Member();
		member1.setId("member");
		member1.setPassword("member");
		member1.setName("회원");
		member1.setRole(Role.ROLE_MEMBER);
		
		memberRepository.save(member1);
		
		
		Member member2 = new Member();
		member2.setId("admin");
		member2.setPassword("admin");
		member2.setName("관리자");
		member2.setRole(Role.ROLE_ADMIN);
		
		memberRepository.save(member2);
		
	}
	
//	@Test
	public void createMemberEncode() {
		Member member1 = new Member();
		member1.setId("member");
		member1.setPassword(passwordEncoder.encode("member"));
		member1.setName("회원");
		member1.setRole(Role.ROLE_MEMBER);
		
		memberRepository.save(member1);
		
		
		Member member2 = new Member();
		member2.setId("admin");
		member2.setPassword(passwordEncoder.encode("admin"));
		member2.setName("관리자");
		member2.setRole(Role.ROLE_ADMIN);
		
		memberRepository.save(member2);
		
	}
	
}
