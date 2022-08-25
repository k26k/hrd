package com.spring.service;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.board.BoardDAO;
import com.spring.board.BoardVO;

public class BoardServiceClient {

	public static void main(String[] args) {
		
//		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
//		BoardDAO boardDAO = (BoardDAO) container.getBean("boardDAO");
//		
//		BoardVO boardVO = new BoardVO();
//		boardVO.setTitle("안녕하세요");
//		boardVO.setWriter("하이미디어");;
//		boardVO.setContent("지인 추천으로 가입했습니다.");
//		
//		boardDAO.insert(boardVO);
//		
//		for(BoardVO b:boardDAO.getAllList()) {
//			System.out.println(b.toString());
//		}
		
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		BoardService boardService = (BoardService) container.getBean("boardService");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("안녕하세요");
		boardVO.setWriter("장그래");
		boardVO.setContent("지인 추천으로 가입했습니다.");
		
		boardService.insert(boardVO);
		
		for(BoardVO b:boardService.getAllList()) {
			System.out.println(b.toString());
		}
		
		container.close();
	}
	
}
