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
public class BoardDto {

	private Long bno;
	
	private String title;
	
	private String content;

	private String writerEmail;
	
	private String writerName;
	
	private Long replyCount;
	
	private LocalDateTime regDate;
	
	private LocalDateTime modDate;

}
