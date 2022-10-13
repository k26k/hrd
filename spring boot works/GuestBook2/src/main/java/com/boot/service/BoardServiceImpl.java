package com.boot.service;

import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.boot.dto.BoardDto;
import com.boot.dto.PageRequestDto;
import com.boot.dto.PageResultDto;
import com.boot.entitiy.Board;
import com.boot.entitiy.QBoard;
import com.boot.repository.BoardRepository;
import com.boot.repository.SearchBoardRepository;
import com.querydsl.core.BooleanBuilder;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

	private final BoardRepository boardRepository;
	private final SearchBoardRepository searchBoardRepository;
	
	@Override
	public Long register(BoardDto boardDto) {
		Board board = this.dtoToEntitiy(boardDto);
		boardRepository.save(board);
		return board.getBno();
	}

	@Override
	public PageResultDto<BoardDto, Object[]> getBoardPage(PageRequestDto pageRequestDto) {
		Pageable pageable = pageRequestDto.getPageable(Sort.by(Sort.Direction.DESC, "bno"));
		
		Page<Object[]> page=null;
		if(pageRequestDto.getKeyword().equals("")) {
			page = boardRepository.getBoardWithReplyCount(pageable);
		}else {
			page = searchBoardRepository.searchPage(pageRequestDto.getType(), pageRequestDto.getKeyword(), pageable);
		}
		
		Function<Object[], BoardDto> func = ( object -> this.objectsToDto(object));
		
		PageResultDto<BoardDto, Object[]> pageResultDto = new PageResultDto<>(page, func);
		return pageResultDto;
	}

	@Override
	public BoardDto getBoard(Long bno) {
		Object object = boardRepository.getBoardWithWriter(bno);
		BoardDto boardDto = this.objectsToDto((Object[])object);
		return boardDto;
	}

}
