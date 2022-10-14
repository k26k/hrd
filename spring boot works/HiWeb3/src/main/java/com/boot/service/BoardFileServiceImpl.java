package com.boot.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.boot.dto.BoardFileDto;
import com.boot.entity.Board;
import com.boot.entity.BoardFile;
import com.boot.repository.BoardFileRepository;

@Service
public class BoardFileServiceImpl implements BoardFileService {

	@Autowired
	private BoardFileRepository boardFileRepository;
	
	@Override
	public int saveFiles(Long bno, MultipartFile[] multipartFiles) throws IllegalStateException, IOException {
		int count = 0;
		Board board = Board.builder().bno(bno).build();
		
		for(MultipartFile multipartFile : multipartFiles) {
			if(!multipartFile.isEmpty()) {
				BoardFile boardFile = this.multipartFileToEntity(board, multipartFile);
				
				File file = new File(boardFile.getFileUuId()+"_"+boardFile.getFileName());
				multipartFile.transferTo(file);
				boardFileRepository.save(boardFile);
				if(boardFile.getRegDate() != null) {
					count++;
				}
			}
		}
		return count;
	}

	@Override
	public List<BoardFileDto> getBoardFileDtoList(Long bno) {
		List<BoardFile> boardFiles = boardFileRepository.findByBoardId(bno);
		List<BoardFileDto> boardFileDtos = boardFiles.stream()
				.map(entity -> this.entityToDto(entity))
				.collect(Collectors.toList());
		return boardFileDtos;
	}

}
