package com.boot.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;

import org.modelmapper.ModelMapper;

import com.boot.entity.Board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class BoardDto {

	private Long id;
	
	@NotEmpty(message = "제목을 입력해주세요")
	private String title;
	
	@NotEmpty(message = "내용을 입력해주세요")
	private String content;
	
	private String createdBy;
	
	private LocalDateTime regTime;
	
	@Builder.Default
	private Long cnt = 0L;
	
	private static ModelMapper modelMapper = new ModelMapper();
	
	public Board createBoard() {
		return modelMapper.map(this, Board.class);
	}
	
	public static BoardDto of(Board board) {
		return modelMapper.map(board, BoardDto.class);
	}
	
}
