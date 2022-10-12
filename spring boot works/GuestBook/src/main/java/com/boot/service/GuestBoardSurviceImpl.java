package com.boot.service;

import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.boot.dto.GuestBookDto;
import com.boot.dto.PageRequestDto;
import com.boot.dto.PageResultDto;
import com.boot.entity.GuestBook;
import com.boot.entity.QGuestBook;
import com.boot.repository.GuestBookRepository;
import com.querydsl.core.BooleanBuilder;

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
		
		BooleanBuilder booleanBuilder = this.getBooleanBuilder(pageRequestDto);
		Page<GuestBook> result = guestBookRepository.findAll(booleanBuilder, pageable);
		
		Function<GuestBook, GuestBookDto> function = ( entity -> this.entityToDto(entity) );
		
		return new PageResultDto<GuestBookDto, GuestBook>(result, function);
	}

	@Override
	public GuestBookDto getGuestBookDto(Long gno) {
		return this.entityToDto(guestBookRepository.findById(gno).get());
	}

	@Override
	public BooleanBuilder getBooleanBuilder(PageRequestDto pageRequestDto) {
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		QGuestBook qGuestBook = QGuestBook.guestBook;
		String searchText= "%"+pageRequestDto.getKeyword()+"%";
		
		if(pageRequestDto.getType() == null) {
			booleanBuilder.and(qGuestBook.title.like("%%"));
		}else if(pageRequestDto.getKeyword() == null){
			booleanBuilder.and(qGuestBook.title.like("%%"));
		}else {
			switch(pageRequestDto.getType()) {
				case "t":
					booleanBuilder.and(qGuestBook.title.like(searchText));
					break;
				case "w":
					booleanBuilder.and(qGuestBook.writer.like(searchText));
					break;
				case "c":
					booleanBuilder.and(qGuestBook.content.like(searchText));
					break;
				default:
					booleanBuilder.and(qGuestBook.title.like("%%"));
					break;
			}
		}
		
		return booleanBuilder;
	}
	
}
