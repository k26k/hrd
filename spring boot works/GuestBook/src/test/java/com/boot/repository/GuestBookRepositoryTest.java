package com.boot.repository;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.boot.entity.GuestBook;

@SpringBootTest
public class GuestBookRepositoryTest {

	@Autowired
	private GuestBookRepository guestBookRepository;
	
	@Test
	public void insertGuestBook() {
		IntStream.rangeClosed(1, 55).forEach(i->{
			GuestBook guestBook = GuestBook.builder()
											.title("테스트 제목 "+i+"번")
											.content("테스트 내용 "+i+"번")
											.writer("테스터")
											.build();
			guestBookRepository.save(guestBook);
		}); 
	}
	
//	@Test
	public void updateGuestBook() {
		List<GuestBook> guestBooks = guestBookRepository.findAll();
		guestBooks.forEach( guestBook -> {
			guestBook.changeTitle(guestBook.getTitle()+" 수정됨");
			guestBook.changeContent(guestBook.getContent()+" 수정됨");
			guestBookRepository.save(guestBook);
		});
	}
	
}
