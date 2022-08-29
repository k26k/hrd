package com.cloud.mapper;

import java.util.ArrayList;

import com.cloud.domain.BoardVO;

public interface BoardMapper {

	public ArrayList<BoardVO> getAllList();
	
	public BoardVO getBoard(int bno);
	
	public void addBoard(BoardVO boardVO);
	
	public void updateBoard(BoardVO boardVO);
	
	public void deleteBoard(int bno);

	public void cntUp(int bno);
}