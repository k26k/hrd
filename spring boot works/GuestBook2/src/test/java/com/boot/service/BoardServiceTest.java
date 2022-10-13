package com.boot.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.boot.dto.BoardDto;
import com.boot.dto.PageRequestDto;
import com.boot.dto.PageResultDto;

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
	
//	@Test
	public void useGetBoardPage() {
		PageRequestDto pageRequestDto =  PageRequestDto.builder()
				.page(100)
				.size(10)
				.build();
		
		PageResultDto<BoardDto, Object[]> pageResultDto = boardService.getBoardPage(pageRequestDto);
		
		for(BoardDto boardDto : pageResultDto.getDtoList()) {
			System.out.println(boardDto.toString());
		}
	}
	
//	@Test
	public void useGetBoard() {
		BoardDto boardDto = boardService.getBoard(1L);
		System.out.println(boardDto.toString());
	}
	
}
