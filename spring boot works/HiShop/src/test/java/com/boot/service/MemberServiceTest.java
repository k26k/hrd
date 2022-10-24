package com.boot.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.boot.dto.MemberFormDto;

@SpringBootTest
public class MemberServiceTest {

	@Autowired
	private MemberService memberService;
	
	public MemberFormDto createMemberFormDto() {
		MemberFormDto memberFormDto = MemberFormDto.builder()
				.name("김아무개")
				.email("test@test.com")
				.password("1234")
				.address("모루겠다")
				.build();
		
		return memberFormDto;
	}
	
//	@Test
//	public void addMember() {
//		MemberFormDto memberFormDto = this.createMemberFormDto();
//		
//		memberService.addMember(memberFormDto);
//	}
	
//	@Test
//	public void addMember() {
//		MemberFormDto memberFormDto1 = this.createMemberFormDto();
//		MemberFormDto memberFormDto2 = this.createMemberFormDto();
////		memberService.addMember(memberFormDto1);
//		
//		Throwable e = assertThrows(IllegalStateException.class, ()->{
//			memberService.addMember(memberFormDto2);
//		});
//		
//		System.out.println(e.getMessage());
//		assertEquals("이미 가입된 회원입니다.", e.getMessage());
//	}
	
}
