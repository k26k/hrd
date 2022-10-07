package com.boot.service;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.boot.dto.GuestBookDto;
import com.boot.dto.PageRequestDto;
import com.boot.dto.PageResultDto;
import com.boot.entity.GuestBook;
import com.boot.repository.GuestBookRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequiredArgsConstructor // autowired 대신 사용 가능 주입받는 객체는 final 사용
@Log4j2
@Service
public class GuestBoardSurviceImpl implements GuestBoardSurvice {

	private final GuestBookRepository guestBookRepository;
	
	@Override
	public Long register(GuestBookDto guestBookDto) {
		log.info("GuestBoardSurviceImpl register ====================");
		log.info("guestBookDto: "+guestBookDto);
		
		GuestBook guestBook = this.dtoToEntity(guestBookDto);
		log.info("guestBook: "+guestBook);
		
		guestBookRepository.save(guestBook);
		return guestBook.getGno();
	}

	@Override
	public PageResultDto<GuestBookDto, GuestBook> getList(PageRequestDto pageRequestDto) {
		Pageable pageable = pageRequestDto.getPageable(Sort.by(Sort.Direction.DESC, "gno"));
		System.out.println(pageable.toString());
		Page<GuestBook> result = guestBookRepository.findAll(pageable);
		System.out.println(result.getNumberOfElements());
		Function<GuestBook, GuestBookDto> function = ( entity -> this.entityToDto(entity) );
		
		return new PageResultDto<GuestBookDto, GuestBook>(result, function);
	}
	
}
