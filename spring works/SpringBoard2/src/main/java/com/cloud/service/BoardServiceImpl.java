package com.cloud.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.domain.BoardVO;
import com.cloud.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	public BoardMapper boardMapper;
	
	@Override
	public ArrayList<BoardVO> getAllList() {
		return boardMapper.getAllList();
	}

	@Override
	public BoardVO getBoard(int bno) {
		return boardMapper.getBoard(bno);
	}

	@Override
	public void addBoard(BoardVO boardVO) {
		boardMapper.addBoard(boardVO);
	}

	@Override
	public void updateBoard(BoardVO boardVO) {
		boardMapper.updateBoard(boardVO);
	}

	@Override
	public void deleteBoard(int bno) {
		boardMapper.deleteBoard(bno);
	}

	@Override
	public void cntUp(int bno) {
		boardMapper.cntUp(bno);
	}
	
}
