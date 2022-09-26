package com.boot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.boot.domain.Board;
import com.boot.service.BoardService;

@SpringBootTest
public class BoardTest {
	
	@Autowired
	private BoardService boardService;
	
//	@Test
//	public void addBoard() {
//		for(int i=1; i<=200; i++) {
//			Board board = new Board();
//			board.setTitle("제목 "+i);
//			board.setWriter("테스트 계정");
//			board.setContent("내용 "+i);
//			
//			boardService.insertBoard(board);
//		}
//	}
	
	@Test
	public void pageBoard() {
		Pageable paging = PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "seq"));
		Page<Board> boards = boardService.getBoardListByKeywordAndPage("", paging);
		for(Board board:boards) {
			System.out.println(board.toString());
		}
	}
	
	
	
}