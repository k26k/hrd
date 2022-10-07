package com.boot.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.boot.dto.GuestBookDto;
import com.boot.dto.PageRequestDto;
import com.boot.dto.PageResultDto;
import com.boot.entity.GuestBook;

@SpringBootTest
public class GuestBookServiceTest {

	@Autowired
	private GuestBoardSurvice guestBoardSurvice;
	
//	@Test
	public void insertGuestBook() {
		GuestBookDto guestBookDto = GuestBookDto.builder()
												.title("테스트 제목")
												.content("테스트 내용")
												.writer("테스터")
												.build();
		System.out.println(guestBoardSurvice.register(guestBookDto)+"번 게시글 등록 완료");
	}
	
	@Test
	public void updateGuestBook() {
		System.out.println("updateGuestBook === start ===");
		PageRequestDto pageRequestDto = new PageRequestDto();
		System.out.println(pageRequestDto.toString());
		PageResultDto<GuestBookDto, GuestBook> pageResultDto = guestBoardSurvice.getList(pageRequestDto);
		
		System.out.println(pageResultDto.getTotalPage());
		System.out.println("updateGuestBook === end ===");
	}
	
}
