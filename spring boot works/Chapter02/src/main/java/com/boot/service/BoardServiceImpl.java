package com.boot.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.boot.domain.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Override
	public String hello(String name) {
		return "Hello "+name+"!";
	}

	@Override
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

	@Override
	public List<BoardVO> getBoardList() {
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
