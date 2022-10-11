package com.boot.service;

import com.boot.dto.GuestBookDto;
import com.boot.dto.PageRequestDto;
import com.boot.dto.PageResultDto;
import com.boot.entity.GuestBook;

public interface GuestBoardSurvice {

	public Long register(GuestBookDto guestBookDto);
	
	public PageResultDto<GuestBookDto, GuestBook> getList(PageRequestDto pageRequestDto);
	
	public GuestBookDto getGuestBookDto(Long gno);
	
	//자바 8 부터 메서드 앞에 default 추가로 구체 메서드 사용 가능 
	
	default public GuestBook dtoToEntity(GuestBookDto guestBookDto) {
		return GuestBook.builder()
						.gno(guestBookDto.getGno())
						.title(guestBookDto.getTitle())
						.content(guestBookDto.getContent())
						.writer(guestBookDto.getWriter())
						.build();
	}
	
	default public GuestBookDto entityToDto(GuestBook guestBook) {
		return GuestBookDto	.builder()
							.gno(guestBook.getGno())
							.title(guestBook.getTitle())
							.content(guestBook.getContent())
							.writer(guestBook.getWriter())
							.regDate(guestBook.getRegDate())
							.modDate(guestBook.getModDate())
							.build();
	}
}
