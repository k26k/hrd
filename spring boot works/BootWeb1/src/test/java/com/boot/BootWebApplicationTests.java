package com.boot;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.boot.domain.Board;
import com.boot.repository.BoardRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class BootWebApplicationTests {

	@Autowired
	private BoardRepository boardRepository;
	
	@Test
	void contextLoads() {
		Board board = new Board();
		board.setTitle("CrudRepository insert 테스트 제목");
		board.setWriter("admin");
		board.setContent("CrudRepository insert 테스트 내용");
		board.setCreateDate(new Date());
		board.setCnt(0L);
		
		boardRepository.save(board);
		log.info(boardRepository.findById(1L).toString());
	}

}
