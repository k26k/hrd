package com.boot.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class FileService {

	public String uploadFile(String uploadPath
			, String originalFileName
			, byte[] fileData) throws IOException {
		UUID uuid = UUID.randomUUID();
		System.out.println(originalFileName);
		String extension = originalFileName.substring(
				originalFileName.lastIndexOf("."));
		System.out.println(extension);
		String saveFileName = uuid.toString() + extension;
		String fileUploadFullUrl = uploadPath + "/" + saveFileName;
		
		FileOutputStream fos = new FileOutputStream(fileUploadFullUrl);
		fos.write(fileData);
		fos.close();
		
		return saveFileName;
	}
	
	public void deleteFile(String filePath) {
		File deleteFile = new File(filePath);
		if(deleteFile.exists()) {
			deleteFile.delete();
			System.out.println("파일 삭제 성공");
		}else {
			System.out.println("파일 찾기 실패");
		}
	}
	
}
