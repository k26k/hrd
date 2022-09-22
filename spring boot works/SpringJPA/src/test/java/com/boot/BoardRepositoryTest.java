package com.boot;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.boot.domain.Board;
import com.boot.persistence.BoardRepository;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class BoardRepositoryTest {

	@Autowired
	private BoardRepository boardRepository;
	
//	삽입
//	@Test
//	public void testInsertBoard() {
//		Board board = new Board();
//		board.setTitle("CrudRepository insert 테스트 제목");
//		board.setWriter("admin");
//		board.setContent("CrudRepository insert 테스트 내용");
//		board.setCreateDate(new Date());
//		board.setCnt(0L);
//		
//		boardRepository.save(board);
//	}

	
//	조회
//	@Test
//	public void testGetBoard() {
//		log.info(boardRepository.findById(1L).toString());
//	}

	
//	전체 조회
//	@Test
//	public void testGetBoardList() {
//		Iterable<Board> boardList = boardRepository.findAll();
//		
//		for(Board board:boardList) {
//			log.info(board.toString());
//		}
//	}
	
	
//	수정
//	@Test
//	public void testUpdateBoard() {
//		Board board = boardRepository.findById(1L).get();
//		log.info(board.toString());
//		board.setTitle("CrudRepository update 테스트 제목 수정됨");
//		board.setContent("CrudRepository update 테스트 내용 수정됨");
//		log.info(board.toString());
//		boardRepository.save(board);		
//	}
	
	
//	삭제
//	@Test
//	public void testUpdateBoard() {
//		boardRepository.deleteById(2L);
//	}
	
}
