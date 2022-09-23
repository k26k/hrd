package com.boot;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.boot.domain.Board;
import com.boot.persistence.BoardRepository2;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class QueryAnnotationTest {

	@Autowired
	private BoardRepository2 boardRepository2;
	
	@Test
	public void testQueryAnnotation1() {
		List<Board> boardList = boardRepository2.queryAnnotationTest1("10");
		log.info("쿼리 결과 갯수: "+boardList.size());
		
		for(Board board:boardList) {
			log.info("쿼리 결과: "+board.toString());
		}
	}
	
	@Test
	public void testQueryAnnotation2() {
		List<Board> boardList = boardRepository2.queryAnnotationTest2("10");
		log.info("쿼리 결과 갯수: "+boardList.size());
		
		for(Board board:boardList) {
			log.info("쿼리 결과: "+board.toString());
		}
	}
	
}
