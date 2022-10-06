package com.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.boot.domain.Board;
import com.boot.domain.QBoard;
import com.boot.domain.Search;
import com.boot.repository.BoardRepository;
import com.querydsl.core.BooleanBuilder;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardRepository boardRepository;
	
	@Override
	public Board getBoard(Long seq) {
		return boardRepository.findById(seq).get();
	}
	
	@Override
	public Page<Board> getBoardPage(Pageable pageable) {
		return boardRepository.findAll(pageable);
	}

	@Override
	public Page<Board> searchBoardPage(Search search, Pageable pageable) {
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		QBoard qBoard = QBoard.board;
//		switch (search.getSearchCondition()) {
//			case "title":
//				booleanBuilder.and(qBoard.title.like("%"+search.getSearchKeyword()+"%"));
//				break;
//				
//			case "content":
//				booleanBuilder.and(qBoard.content.like("%"+search.getSearchKeyword()+"%"));
//				break;
//				
//			case "writer":
//				booleanBuilder.and(qBoard.member.name.like("%"+search.getSearchKeyword()+"%"));
//				break;
//	
//			default:
//				return null;
//				break;
//		}
		
		if(search.getSearchCondition().equals("title")) {
			booleanBuilder.and(qBoard.title.like("%"+search.getSearchKeyword()+"%"));
		}else if(search.getSearchCondition().equals("content")) {
			booleanBuilder.and(qBoard.content.like("%"+search.getSearchKeyword()+"%"));
		}else if(search.getSearchCondition().equals("memberName")) {
			booleanBuilder.and(qBoard.member.name.like("%"+search.getSearchKeyword()+"%"));
		}else {
			return null;
		}
		System.out.println();
		
		return boardRepository.findAll(pageable);
	}
	
	@Override
	public String getSearchLink(Search search) {
		return "/board/searchBoardList?&contain="+search.getSearchCondition()+"search="+search.getSearchKeyword();
	}

	@Override
	public boolean insertBoard(Board board) {
		boardRepository.save(board);
		return true;
	}

	@Override
	public boolean updateBoard(Board board) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteBoard(Long seq) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void cntUp(Long seq) {
		boardRepository.cntUp(seq);
	}

}
