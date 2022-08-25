package com.cloud.service;

import java.util.ArrayList;

import com.cloud.repository.BoardVO;

public interface BoardService {
	
	public BoardVO getBoard(int bno);
	
	public ArrayList<BoardVO> getAllList();
	
	public int addBoard(BoardVO boardVO);
	
	public int updateBoard(BoardVO boardVO);
	
	public int deleteBoard(int bno);
	
}
