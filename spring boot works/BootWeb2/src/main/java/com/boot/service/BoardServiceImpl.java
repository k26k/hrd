package com.boot.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.domain.Board;
import com.boot.repository.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardRepository boardRepository;
	
	@Override
	public List<Board> getAllBoardList() {
		return boardRepository.findAll();
	}

	@Override
	public Board getBoard(Long seq) {
		return boardRepository.findById(seq).get();
	}
	
	@Override
	public void insertBoard(Board board) {
		boardRepository.save(board);
	}

	@Override
	public void deleteBoard(Long seq) {
		boardRepository.deleteById(seq);
	}

	@Override
	public void updateBoard(Board board) {
//		Board boardOrigin = boardRepository.findById(board.getSeq()).get();
//		boardOrigin.setTitle(board.getTitle());
//		boardOrigin.setContent(board.getContent());
		boardRepository.save(board);
	}

	@Transactional // 트랜잭션 처리 
	@Override
	public void boardCntUp(Long seq) {
//		Board boardOrigin = boardRepository.findById(seq).get();
//		boardOrigin.setCnt(boardOrigin.getCnt()+1);
//		boardRepository.save(boardOrigin);
		boardRepository.boardCntUp(seq);
	}


}
