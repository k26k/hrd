package com.boot.service;

import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.boot.domain.Role;
import com.boot.dto.BoardDto;
import com.boot.dto.PageRequestDto;
import com.boot.dto.PageResultDto;
import com.boot.entity.Board;
import com.boot.entity.Member;
import com.boot.repository.BoardRepository;
import com.boot.repository.MemberRepository;
import com.boot.repository.SearchRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

	private final BoardRepository boardRepository;
	private final SearchRepository searchRepository;
	private final MemberRepository memberRepository;
	
	@Override
	public BoardDto getBoard(Long bno) {
		Board board = boardRepository.findById(bno).get();
		BoardDto boardDto = this.entityToDto(board);
		return boardDto;
	}

	@Override
	public PageResultDto<BoardDto, Object[]> getBoardPage(PageRequestDto pageRequestDto) {
		Pageable pageable = pageRequestDto.getPageable(Sort.by(Order.desc("bno")));
		
		Function<Object[], BoardDto> func = (obj -> this.objectsToDto(obj));
		Page<Object[]> page = boardRepository.getBoardPage(pageable);
		
		PageResultDto<BoardDto, Object[]> pageResultDto = new PageResultDto<BoardDto, Object[]>(page, func);
		return pageResultDto;
	}

	@Override
	public PageResultDto<BoardDto, Object[]> searchBoardPage(PageRequestDto pageRequestDto) {
		String type = pageRequestDto.getType();
		String keyword = pageRequestDto.getKeyword();
		Pageable pageable = pageRequestDto.getPageable(Sort.by(Order.desc("bno")));
		
		Function<Object[], BoardDto> func = (obj -> this.objectsToDto(obj));
		Page<Object[]> page = searchRepository.searchBoardPage(type, keyword, pageable);
		
		PageResultDto<BoardDto, Object[]> pageResultDto = new PageResultDto<BoardDto, Object[]>(page, func);
		return pageResultDto;
	}

	@Override
	public BoardDto insertBoard(BoardDto boardDto) {
		Board board = this.dtoToEntity(boardDto);
		board = boardRepository.save(board);
		if(board.getBno()>0L) {
			return this.entityToDto(board);
		}
		return new BoardDto();
	}

	@Override
	public boolean updateBoard(BoardDto boardDto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteBoard(BoardDto boardDto) {
		Optional<Board> boardOtional = boardRepository.findById(boardDto.getBno());
		if(boardOtional.isEmpty()) {
			return false;
		}
		
		Optional<Member> memberOtional = memberRepository.findById(boardDto.getWriterId());
		if(memberOtional.isEmpty()) {
			return false;
		}	
		
		Member member = memberOtional.get();
		
		if(member.getRole() == Role.ROLE_ADMIN) {
			boardRepository.deleteById(boardDto.getBno());
			return true;
		}
		
		if(member.getUserId().equals(boardOtional.get().getWriter().getUserId())) {
			boardRepository.deleteById(boardDto.getBno());
			return true;
		}
		
		return false;
	}

	@Override
	public void cntUp(Long bno) {
		boardRepository.cntUp(bno);
	}

	@Override
	public boolean replyCountUp(Long bno) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean replyCountDown(Long bno) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
	
//	@Override
//	public Board getBoard(Long seq) {
//		return boardRepository.findById(seq).get();
//	}
//	
//	@Override
//	public Page<Board> getBoardPage(Pageable pageable) {
//		return boardRepository.findAll(pageable);
//	}
//
//	@Override
//	public Page<Board> searchBoardPage(SearchDto search, Pageable pageable) {
//		System.out.println(search.toString());
//		BooleanBuilder booleanBuilder = new BooleanBuilder();
//		QBoard qBoard = QBoard.board;
//		switch (search.getType()) {
//			case "title":
//				booleanBuilder.and(qBoard.title.like("%"+search.getKeyword()+"%"));
//				break;
//				
//			case "content":
//				booleanBuilder.and(qBoard.content.like("%"+search.getKeyword()+"%"));
//				break;
//				
//			case "writer":
//				booleanBuilder.and(qBoard.member.name.like("%"+search.getKeyword()+"%"));
//				break;
//	
//			default:
//				return null;
//		}
//		
////		if(search.getSearchCondition().equals("title")) {
////			booleanBuilder.and(qBoard.title.like("%"+search.getSearchKeyword()+"%"));
////		}else if(search.getSearchCondition().equals("content")) {
////			booleanBuilder.and(qBoard.content.like("%"+search.getSearchKeyword()+"%"));
////		}else if(search.getSearchCondition().equals("memberName")) {
////			booleanBuilder.and(qBoard.member.name.like("%"+search.getSearchKeyword()+"%"));
////		}else {
////			return null;
////		}
//		
//		return boardRepository.findAll(booleanBuilder, pageable);
//	}
//	
//	@Override
//	public String getSearchLink(SearchDto search) {
//		return "/board/searchBoardList?condition="+search.getType()+"&word="+search.getWord();
//	}
//
//	@Override
//	public boolean insertBoard(String userId, Board board) {
//		Member member = memberRepository.findById(userId).get();
//		board.setMember(member);
//		boardRepository.save(board);
//		return true;
//	}
//
//	@Override
//	public boolean updateBoard(String userId, Board board) {
//		Member member = memberRepository.findById(userId).get();
//		Board originBoard = boardRepository.findById(board.getSeq()).get();
//		if(	member.getRole().equals(Role.ROLE_ADMIN)
//			|| originBoard.getMember().getUserId().equals(member.getUserId())) {
//			
//			originBoard.setTitle(board.getTitle());
//			originBoard.setTitle(board.getTitle());
//			boardRepository.save(originBoard);
//			
//			return true;
//		}
//		
//		return false;
//	}
//
//	@Override
//	public boolean deleteBoard(Long seq) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public void cntUp(Long seq) {
//		boardRepository.cntUp(seq);
//	}

}
