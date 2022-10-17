package com.boot.service;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.boot.dto.BoardFileDto;
import com.boot.entity.Board;
import com.boot.entity.BoardFile;

public interface BoardFileService {

	public int saveFiles(Long bno, MultipartFile[] multipartFiles) throws IllegalStateException, IOException;

	public List<BoardFileDto> getBoardFileDtoList(Long bno);
	
	public default BoardFile multipartFileToEntity(Board board, MultipartFile multipartFile) {
		BoardFile boardFile = BoardFile.builder()
				.fileUuId(UUID.randomUUID().toString())
				.fileName(multipartFile.getOriginalFilename())
				.contentType(multipartFile.getContentType())
				.board(board)
				.build();
		return boardFile;
	}
	
	public default BoardFileDto entityToDto(BoardFile boardFile) {
		BoardFileDto boardFileDto = BoardFileDto.builder()
				.fileUuId(boardFile.getFileUuId())
				.fileName(boardFile.getFileName())
				.contentType(boardFile.getContentType())
				.bno(boardFile.getBoard().getBno())
				.fileLink("/upload/"+boardFile.getFileUuId()+"_"+boardFile.getFileName())
				.regDate(boardFile.getRegDate())
				.modDate(boardFile.getModDate())
				.build();
		return boardFileDto;
	}
	
}
