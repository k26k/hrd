package com.boot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.boot.domain.Board;
import com.boot.domain.Member;
import com.boot.domain.QBoard;
import com.boot.domain.Search;
import com.boot.repository.BoardRepository;
import com.boot.repository.MemberRepository;
import com.querydsl.core.BooleanBuilder;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardRepository boardRepository;
	
	@Autowired
	private MemberRepository memberRepository;

	@Override
	public List<Board> getBoardList(String keyWord) {
		return null;
	}

	@Override
	public Page<Board> getBoardPage(String keyWord, Pageable pageable) {
		Page<Board> BoardPage = boardRepository.findByTitleContainingOrContentContaining(keyWord, keyWord, pageable);
		return BoardPage;
	}
	
	@Override
	public Page<Board> getBoardSearch(Search search, Pageable pageable) {
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		QBoard qBoard = QBoard.board;
		if(search.getSearchCondition().equals("title")) {
			booleanBuilder.and(qBoard.title.like("%"+search.getSearchKeyword()+"%"));
		}else if(search.getSearchCondition().equals("content")) {
			booleanBuilder.and(qBoard.content.like("%"+search.getSearchKeyword()+"%"));
		}else if(search.getSearchCondition().equals("memberName")) {
			booleanBuilder.and(qBoard.member.name.like("%"+search.getSearchKeyword()+"%"));
		}else {
			return null;
		}
		return boardRepository.findAll(booleanBuilder, pageable);
	}

	@Override
	public Board getBoardBySeq(Long seq) {
		Optional<Board> optional = boardRepository.findById(seq);
		if(optional.isPresent()) {
			return optional.get();
		}
		return new Board();
	}

	@Override
	public List<Board> getBoardListByMember(String id){
		Optional<Member> optional = memberRepository.findById(id);
		if(optional.isPresent()) {
			List<Board> boardList = optional.get().getBoardList(); 
			return boardList;
		}
		return new ArrayList<Board>();
	}
	
	@Override
	public void addBoard(Board board) {
		boardRepository.save(board);
	}

	@Override
	public void updateBoard(Board board) {
		boardRepository.save(board);
	}

	@Override
	public void deleteBoard(Long seq) {
		boardRepository.deleteById(seq);
	}

	@Override
	public void cntUp(Long seq) {
		boardRepository.cntUp(seq);
	}
	
}
