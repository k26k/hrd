package com.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.boot.domain.Board;
import com.boot.domain.Member;
import com.boot.domain.QBoard;
import com.boot.domain.Role;
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
	public Board getBoard(Long seq) {
		return boardRepository.findById(seq).get();
	}
	
	@Override
	public Page<Board> getBoardPage(Pageable pageable) {
		return boardRepository.findAll(pageable);
	}

	@Override
	public Page<Board> searchBoardPage(Search search, Pageable pageable) {
		System.out.println(search.toString());
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		QBoard qBoard = QBoard.board;
		switch (search.getCondition()) {
			case "title":
				booleanBuilder.and(qBoard.title.like("%"+search.getWord()+"%"));
				break;
				
			case "content":
				booleanBuilder.and(qBoard.content.like("%"+search.getWord()+"%"));
				break;
				
			case "writer":
				booleanBuilder.and(qBoard.member.name.like("%"+search.getWord()+"%"));
				break;
	
			default:
				return null;
		}
		
//		if(search.getSearchCondition().equals("title")) {
//			booleanBuilder.and(qBoard.title.like("%"+search.getSearchKeyword()+"%"));
//		}else if(search.getSearchCondition().equals("content")) {
//			booleanBuilder.and(qBoard.content.like("%"+search.getSearchKeyword()+"%"));
//		}else if(search.getSearchCondition().equals("memberName")) {
//			booleanBuilder.and(qBoard.member.name.like("%"+search.getSearchKeyword()+"%"));
//		}else {
//			return null;
//		}
		
		return boardRepository.findAll(booleanBuilder, pageable);
	}
	
	@Override
	public String getSearchLink(Search search) {
		return "/board/searchBoardList?condition="+search.getCondition()+"&word="+search.getWord();
	}

	@Override
	public boolean insertBoard(String userId, Board board) {
		Member member = memberRepository.findById(userId).get();
		board.setMember(member);
		boardRepository.save(board);
		return true;
	}

	@Override
	public boolean updateBoard(String userId, Board board) {
		Member member = memberRepository.findById(userId).get();
		Board originBoard = boardRepository.findById(board.getSeq()).get();
		if(	member.getRole().equals(Role.ROLE_ADMIN)
			|| originBoard.getMember().getUserId().equals(member.getUserId())) {
			
			originBoard.setTitle(board.getTitle());
			originBoard.setTitle(board.getTitle());
			boardRepository.save(originBoard);
			
			return true;
		}
		
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
