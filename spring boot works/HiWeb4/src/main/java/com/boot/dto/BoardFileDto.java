package com.boot.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BoardFileDto {
	
	private String fileUuId; 		//파일 이름을 unique하게 만들 필드
	
	private String fileName; 	//파일 이름
	
	private String contentType;	//확장자
	
	private Long bno;
	
	private String fileLink;
	
	private LocalDateTime regDate;
	
	private LocalDateTime modDate;
}
