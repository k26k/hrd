package com.boot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.boot.domain.Role;
import com.boot.dto.MemberDto;
import com.boot.repository.MemberRepository;
import com.boot.service.MemberService;

@SpringBootTest
public class MemberTest {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
//	@Test
//	public void setMember() {
//		MemberDto memberDto = MemberDto.builder()
//				.userId("member")
//				.password(passwordEncoder.encode("member"))
//				.name("회원")
//				.role(Role.ROLE_MEMBER)
//				.build();
//		
//		boolean saveMember = memberService.insertMember(memberDto);
//		
//		MemberDto memberDto2 = MemberDto.builder()
//				.userId("admin")
//				.password(passwordEncoder.encode("admin"))
//				.name("관리자")
//				.role(Role.ROLE_ADMIN)
//				.build();
//		
//		boolean saveAdmin = memberService.insertMember(memberDto2);
//		
//		System.out.println("saveMember: "+saveMember+", saveAdmin: "+saveAdmin);
//	}
	
}
