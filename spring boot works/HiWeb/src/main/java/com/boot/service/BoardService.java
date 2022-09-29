package com.boot.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.boot.domain.Board;
import com.boot.domain.Member;

public interface BoardService {

	public List<Board> getBoardList(String keyWord);

	public Page<Board> getBoardPage(String keyWord, Pageable pageable);
	
	public Board getBoardBySeq(long seq);
	
	public List<Board> getBoardListByMember(String id);
	
	public void addBoard(Board board);
	
	public void updateBoard(Board board);

	public void deleteBoard(long seq);
	
	public void cntUp(long seq);
	
}
