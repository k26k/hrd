package com.boot.repository;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.boot.domain.Role;
import com.boot.entity.Member;

@SpringBootTest
public class MemberRepositoryTest {

	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
//	@Test
//	public void insertMember() {
//		IntStream.rangeClosed(1, 30).forEach( i -> {
//			Member member = Member.builder()
//					.userId("id"+i)
//					.password(passwordEncoder.encode("qwe"+i))
//					.name("유저"+i)
//					.role(Role.ROLE_MEMBER)
//					.build();
//			memberRepository.save(member);
//		});
//	}

}
