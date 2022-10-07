package com.boot.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.boot.domain.Board;
import com.boot.domain.Search;

public interface BoardService {
	
	public Board getBoard(Long seq);
	
	public Page<Board> getBoardPage(Pageable pageable);
	
	public Page<Board> searchBoardPage(Search search, Pageable pageable);
	
	public String getSearchLink(Search search);
	
	public boolean insertBoard(String userId, Board board);
	
	public boolean updateBoard(String userId, Board board);
	
	public boolean deleteBoard(Long seq);
	
	public void cntUp(Long seq);
	
}
