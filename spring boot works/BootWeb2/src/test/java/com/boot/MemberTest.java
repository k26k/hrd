package com.boot;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.boot.domain.Member;
import com.boot.service.MemberService;

@SpringBootTest
public class MemberTest {

	@Autowired
	private MemberService memberService;
	
	@Test
	public void addMember() {
		Member member = new Member();
		member.setId("test");
		member.setPassword("test");
		member.setName("테스트 계정");
		member.setRole("ROLE_ADMIN");
		
		memberService.insertMember(member);
	}
	
}
