package com.boot.service;

import java.util.List;

import com.boot.domain.BoardVO;

public interface BoardService {

	public String hello(String name);
	
	public BoardVO getBoard();
	
	public List<BoardVO> getBoardList();
	
}
