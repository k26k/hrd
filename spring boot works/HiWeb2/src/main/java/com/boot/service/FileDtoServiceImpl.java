package com.boot.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.boot.domain.Board;
import com.boot.dto.FileDto;
import com.boot.repository.FileDtoRepository;

@Service
public class FileDtoServiceImpl implements FileDtoService {

	@Autowired
	private FileDtoRepository FileDtoRepository;
	
	@Override
	public boolean saveFiles(Board board, MultipartFile[] multipartFiles) throws IllegalStateException, IOException {
		for(MultipartFile multipartFile:multipartFiles) {
			if(!multipartFile.isEmpty()) {
				FileDto fileDto = new FileDto(	UUID.randomUUID().toString(), 
												multipartFile.getOriginalFilename(),
												multipartFile.getContentType());
				fileDto.setBoard(board);
				File file = new File(fileDto.getUuid()+"_"+fileDto.getFileName());
				multipartFile.transferTo(file);
				FileDtoRepository.save(fileDto);
			}
		}
		return true;
	}

	@Override
	public List<FileDto> loadFiles() {
		return null;
	}

}
