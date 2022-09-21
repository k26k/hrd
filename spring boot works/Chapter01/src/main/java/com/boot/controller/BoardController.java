package com.boot.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.domain.BoardVO;

@RestController
public class BoardController {

	public BoardController() {
		System.out.println("===> BoardController CREATE");
	}
	
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}

	@RequestMapping("/name")
	public String name(String name) {
		return "name: "+name;
	}
	
	@GetMapping("/getBoard")
	public BoardVO getBoard() {
		BoardVO boardVO = new BoardVO();
		boardVO.setSeq(1);
		boardVO.setTitle("테스트 제목");
		boardVO.setWriter("테스트 작성자");
		boardVO.setContent("테스트 내용");
		boardVO.setCreateDate(new Date());
		boardVO.setCnt(0);
		
		return boardVO;
	}
	
	@GetMapping("/getBoardList")
	public List<BoardVO> getBoardList(){
		List<BoardVO> boardVOList = new ArrayList<BoardVO>();
		
		for(int i=1; i<=10; i++) {
			BoardVO boardVO = new BoardVO();
			boardVO.setSeq(i);
			boardVO.setTitle("테스트 제목");
			boardVO.setWriter("테스트 작성자");
			boardVO.setContent("테스트 내용");
			boardVO.setCreateDate(new Date());
			boardVO.setCnt(0);
			
			boardVOList.add(boardVO);
		}
		
		return boardVOList; 
	}
	
	
}
