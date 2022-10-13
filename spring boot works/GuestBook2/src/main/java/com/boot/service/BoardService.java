package com.boot.service;

import com.boot.dto.BoardDto;
import com.boot.dto.PageRequestDto;
import com.boot.dto.PageResultDto;
import com.boot.entitiy.Board;
import com.boot.entitiy.Member;

public interface BoardService {

	public Long register (BoardDto boardDto);
	
	public PageResultDto<BoardDto, Object[]> getBoardPage(PageRequestDto pageRequestDto);
	
	public BoardDto getBoard(Long bno);
	
	public default BoardDto objectsToDto(Object[] objects) {
		Board board = (Board) objects[0];
		Member member = (Member) objects[1];
		Long count = 0L;
		if(objects.length > 2) {
			count = (Long) objects[2];
		}
		
		BoardDto boardDto = BoardDto.builder()
				.bno(board.getBno())
				.title(board.getTitle())
				.content(board.getContent())
				.writerEmail(member.getEmail())
				.writerName(member.getName())
				.replyCount(count)
				.regDate(board.getRegDate())
				.modDate(board.getModDate())
				.build();
		return boardDto;
	}
	
	public default BoardDto entityToDto(Board board) {
		BoardDto boardDto = BoardDto.builder()
				.bno(board.getBno())
				.title(board.getTitle())
				.content(board.getContent())
				.writerEmail(board.getWriter().getEmail())
				.writerName(board.getWriter().getName())
				.regDate(board.getRegDate())
				.modDate(board.getModDate())
				.build();
		return boardDto;
	}
	
	public default Board dtoToEntitiy(BoardDto boardDto) {
		Member member = Member.builder()
				.email(boardDto.getWriterEmail())
				.build();
		
		Board board = Board.builder()
				.title(boardDto.getTitle())
				.content(boardDto.getContent())
				.writer(member)
				.build();
		
		return board;
	}
	
}
