package com.boot.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import com.boot.dto.PageRequestDto;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
public class SearchRepositoryTest {
	
	@Autowired
	private SearchRepository searchBoardRepository;
	
////	@Test
//	public void test() {
//	
//		PageRequestDto pageRequestDto = PageRequestDto.builder()
//				.page(1)
//				.size(10)
//				.type("c")
//				.keyword("d")
//				.build();
//		
////		searchBoardRepository.searchList();
//		Page<Object[]> page = null;
//		log.info(
//			page = searchBoardRepository.searchBoardPage(
//					pageRequestDto.getType(), 
//					pageRequestDto.getKeyword(), 
//					pageRequestDto.getPageable(Sort.by(Sort.Direction.DESC, "bno")))
//		);
//		System.out.println("page: "+page.toString());
//		page.getContent().forEach(objects -> {
//			for(Object o:objects) {
//				System.out.println("o: "+o.toString());
//			}
//		});
//	}
	
	
}
