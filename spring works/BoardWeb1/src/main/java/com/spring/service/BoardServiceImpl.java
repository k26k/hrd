package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.board.BoardDAO;
import com.spring.board.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO; 
	
	@Override
	public List<BoardVO> getAllList() {
		return boardDAO.getAllList();
	}

	@Override
	public void insert(BoardVO boardVO) {
		boardDAO.insert(boardVO);
	}
	
}
