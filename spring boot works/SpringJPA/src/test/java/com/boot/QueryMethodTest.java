package com.boot;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.boot.domain.Board;
import com.boot.persistence.BoardRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class QueryMethodTest {

	@Autowired
	private BoardRepository boardRepository;
	
//	데이터 삽입
//	@Test
//	public void dataPrepare() {
//		for(int i=1; i<=200; i++) {
//			Board board = new Board();
//			board.setTitle("테스트 제목 "+i);
//			board.setWriter("테스터 "+i);
//			board.setContent("테스트 내용 "+i);
//			board.setCreateDate(new Date());
//			board.setCnt(0L);
//			
//			boardRepository.save(board);
//		}
//	}
	
	
//	쿼리메소드 이용
//	@Test
//	public void testFindBoardByTitle() {
//		List<Board> boards = boardRepository.findBoardByTitle("테스트 제목 1");
//		log.info("쿼리 결과 갯수: "+boards.size());
//		
//		for(Board board:boards) {
//			log.info("쿼리 결과: "+board.toString());
//		}
//	}


//	쿼리메소드 Containing 이용
//	@Test
//	public void testFindBoardByContentContaining() {
//		List<Board> boards = boardRepository.findBoardByContentContaining("10");
//		log.info("쿼리 결과 갯수: "+boards.size());
//		
//		for(Board board:boards) {
//			log.info("쿼리 결과: "+board.toString());
//		}
//	}
	
	
//	쿼리메소드 or 이용
//	@Test
//	public void testFindBoardByTitleContainingOrContentContaining() {
//		List<Board> boards = boardRepository.findBoardByTitleContainingOrContentContaining("10", "50");
//		log.info("쿼리 결과 갯수: "+boards.size());
//		
//		for(Board board:boards) {
//			log.info("쿼리 결과: "+board.toString());
//		}
//	}
	
	
//	쿼리메소드 or 이용
	@Test
	public void testFindBoardByTitleContainingOrderBySeqDesc() {
		List<Board> boards = boardRepository.findBoardByTitleContainingOrderBySeqDesc("10");
		log.info("쿼리 결과 갯수: "+boards.size());
		
		for(Board board:boards) {
			log.info("쿼리 결과: "+board.toString());
		}
	}
	
}
