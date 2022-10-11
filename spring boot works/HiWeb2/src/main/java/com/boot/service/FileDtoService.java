package com.boot.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.boot.domain.Board;
import com.boot.dto.FileDto;

public interface FileDtoService {

	public boolean saveFiles(Board board, MultipartFile[] multipartFiles) throws IllegalStateException, IOException;

	public List<FileDto> loadFiles();
	
}
