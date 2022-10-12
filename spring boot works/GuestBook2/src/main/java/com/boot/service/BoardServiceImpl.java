package com.boot.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.boot.dto.BoardDto;
import com.boot.dto.PageRequestDto;
import com.boot.dto.PageResultDto;
import com.boot.entitiy.Board;
import com.boot.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

	private final BoardRepository boardRepository;
	
	@Override
	public Long register(BoardDto boardDto) {
		Board board = this.dtoToEntitiy(boardDto);
		boardRepository.save(board);
		return board.getBno();
	}

	@Override
	public PageResultDto<BoardDto, Object[]> getBoardPage(PageRequestDto pageRequestDto) {
		Pageable pageable = pageRequestDto.getPageable(Sort.by(Sort.Direction.DESC, "bno"));
		
		Page<Object[]> page = boardRepository.getBoardWithReplyCount(pageable);
		
		PageResultDto<BoardDto, Object[]> pageResultDto = new PageResultDto<>(page, null);
		return pageResultDto;
	}

}
