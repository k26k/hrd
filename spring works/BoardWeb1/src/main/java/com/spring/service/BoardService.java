package com.spring.service;

import java.util.List;

import com.spring.board.BoardVO;

public interface BoardService {

	List<BoardVO> getAllList();

	void insert(BoardVO boardVO);
	
}
