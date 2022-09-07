package com.cloud.service;

import java.util.ArrayList;

import com.cloud.vo.BoardCategoryVO;

public interface BoardCategoryService {
	
	public ArrayList<BoardCategoryVO> getAllBoardList();
	
	public BoardCategoryVO getBoard(int category_num);
	
	public void addBoard(BoardCategoryVO boardCategoryVO);
	
	public void updateBoard(BoardCategoryVO boardCategoryVO);
	
	public void deleteBoard(int category_num);
	
}
