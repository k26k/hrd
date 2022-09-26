package com.boot.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.boot.domain.Board;

public interface BoardService {

	public List<Board> getAllBoardList(); 
	
	public Page<Board> getBoardListByKeywordAndPage(String keyword, Pageable paging ); 
	
	public Board getBoard(Long seq); 
	
	public void insertBoard(Board board);
	
	public void deleteBoard(Long seq);
	
	public void updateBoard(Board board);
	
	public void boardCntUp(Long seq);
	
}