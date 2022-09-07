package com.cloud.mapper;

import java.util.ArrayList;

import com.cloud.vo.BoardCategoryVO;

public interface BoardCategoryMapper {

	public ArrayList<BoardCategoryVO> getAllBoardList();
	
	public BoardCategoryVO getBoard(int category_num);
	
	public void addBoard(BoardCategoryVO boardVO);
	
	public void updateBoard(BoardCategoryVO boardVO);
	
	public void deleteBoard(int category_num);
	
}
