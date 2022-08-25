package com.cloud.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.repository.BoardDAO;
import com.cloud.repository.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO; 
	
	@Override
	public BoardVO getBoard(int bno) {
		return boardDAO.getBoard(bno);
	}

	@Override
	public ArrayList<BoardVO> getAllList() {
		return boardDAO.getAllList();
	}

	@Override
	public int addBoard(BoardVO boardVO) {
		return boardDAO.addBoard(boardVO);
	}

	@Override
	public int updateBoard(BoardVO boardVO) {
		return boardDAO.updateBoard(boardVO);
	}

	@Override
	public int deleteBoard(int bno) {
		return boardDAO.deleteBoard(bno);
	}

}
