package com.boot.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class FileDto {
	
	@Id
	private String uuid; 		//파일 이름을 unique하게 만들 필드
	private String fileName; 	//파일 이름
	private String contentType;	//확장자
	
	//@
	//private Board 
	
	public FileDto() {}
	
	public FileDto(String uuid, String fileName, String contentType) {
		 this.uuid = uuid;
		 this.fileName = fileName;
		 this.contentType = contentType;
	}
	
}
