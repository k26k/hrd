package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.board.BoardDAO;
import com.spring.board.BoardVO;
import com.spring.common.Log4jAdvice;
import com.spring.common.LogAdvice;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO; 
	
	//private LogAdvice log;
	//private Log4jAdvice log;
	
	public BoardServiceImpl() {
		//log = new LogAdvice();
		//log = new Log4jAdvice();
	}
	
	@Override
	public List<BoardVO> getAllList() {
		//log.printLog();
		//log.printLogging();
		return boardDAO.getAllList();
	}

	@Override
	public void insert(BoardVO boardVO) {
		//log.printLog();
		//log.printLogging();
		boardDAO.insert(boardVO);
	}
	
}
