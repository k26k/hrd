package com.boot.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.boot.dto.BoardDto;

@SpringBootTest
public class BoardServiceTest {

	@Autowired
	private BoardService boardService; 
	
//	@Test
	public void useRegister() {
		BoardDto boardDto = BoardDto.builder()
				.title("테스트 게시글 제목")
				.content("테스트 게시글 내용")
				.writerEmail("id1@qwe.com")
				.build();
		
		boardService.register(boardDto);
	}
	
}
