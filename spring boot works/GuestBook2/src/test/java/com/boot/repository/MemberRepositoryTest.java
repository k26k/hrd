package com.boot.repository;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.boot.entitiy.Board;
import com.boot.entitiy.Member;

@SpringBootTest
public class MemberRepositoryTest {

	@Autowired
	private MemberRepository memberRepository;
	
//	@Test
	public void insertMember() {
		IntStream.rangeClosed(1, 100).forEach( i -> {
			Member member = Member.builder()
					.email("id"+i+"@qwe.com")
					.password("qwe"+i)
					.name("user"+i)
					.build();
			memberRepository.save(member);
		});
	}

}
