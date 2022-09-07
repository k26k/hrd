package com.cloud.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.mapper.BoardCategoryMapper;
import com.cloud.vo.BoardCategoryVO;

@Service
public class BoardCategoryServiceImpl implements BoardCategoryService {

	@Autowired
	private BoardCategoryMapper boardCategoryMapper;
	
	@Override
	public ArrayList<BoardCategoryVO> getAllBoardList() {
		return boardCategoryMapper.getAllBoardList();
	}

	@Override
	public BoardCategoryVO getBoard(int category_num) {
		return boardCategoryMapper.getBoard(category_num);
	}

	@Override
	public void addBoard(BoardCategoryVO boardCategoryVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBoard(BoardCategoryVO boardCategoryVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBoard(int category_num) {
		// TODO Auto-generated method stub
		
	}

}
