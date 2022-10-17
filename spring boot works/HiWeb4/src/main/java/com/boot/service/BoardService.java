package com.boot.service;

import com.boot.dto.BoardDto;
import com.boot.dto.PageRequestDto;
import com.boot.dto.PageResultDto;
import com.boot.entity.Board;
import com.boot.entity.Member;

public interface BoardService {
	
	public BoardDto getBoard(Long bno);
	
	public PageResultDto<BoardDto, Object[]> getBoardPage(PageRequestDto pageRequestDto);
	
	public PageResultDto<BoardDto, Object[]> searchBoardPage(PageRequestDto pageRequestDto);
	
	public BoardDto insertBoard(BoardDto boardDto);
	
	public boolean updateBoard(BoardDto boardDto);
	
	public boolean deleteBoard(BoardDto boardDto);
	
	public void cntUp(Long bno);
	
	public boolean replyCountUp(Long bno);
	
	public boolean replyCountDown(Long bno);
	
	public default BoardDto objectsToDto(Object[] objects) {
		Board board = (Board) objects[0];
		Member member = (Member) objects[1];
		
		BoardDto boardDto = BoardDto.builder()
				.bno(board.getBno())
				.title(board.getTitle())
				.content(board.getContent())
				.writerId(member.getUserId())
				.writerName(member.getName())
				.cnt(board.getCnt())
				.replyCount(board.getReplyCount())
				.regDate(board.getRegDate())
				.modDate(board.getModDate())
				.build();
		
		return boardDto;
	}
	
	public default BoardDto entityToDto(Board board) {
		Member member = board.getWriter();
		
		BoardDto boardDto = BoardDto.builder()
				.bno(board.getBno())
				.title(board.getTitle())
				.content(board.getContent())
				.writerId(member.getUserId())
				.writerName(member.getName())
				.writerRole(member.getRole())
				.writerEnabled(member.isEnabled())
				.cnt(board.getCnt())
				.replyCount(board.getReplyCount())
				.regDate(board.getRegDate())
				.modDate(board.getModDate())
				.build();
		
		return boardDto;
	}
	
	public default Board dtoToEntity(BoardDto boardDto) {
		Member member = Member.builder()
				.userId(boardDto.getWriterId()).build();
		
		Board board = Board.builder()
				.bno(boardDto.getBno())
				.title(boardDto.getTitle())
				.content(boardDto.getContent())
				.cnt(boardDto.getCnt())
				.replyCount(boardDto.getReplyCount())
				.writer(member)
				.build();
		
		return board;
	}
	
}
