package com.boot.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.boot.domain.Board;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"board"})
@Data
@Entity
public class FileDto {
	
	@Id
	private String uuid; 		//파일 이름을 unique하게 만들 필드
	
	private String fileName; 	//파일 이름
	
	private String contentType;	//확장자
	
	@ManyToOne
	@JoinColumn(name = "board_id",
				nullable = false,
				updatable = false)
	private Board board;
	
	public FileDto(String uuid, String fileName, String contentType) {
		 this.uuid = uuid;
		 this.fileName = fileName;
		 this.contentType = contentType;
	}
	
}
