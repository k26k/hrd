package com.boot.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.boot.domain.Role;

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

	private String writerId;
	
	private String writerName;
	
	private Role writerRole;
	
	private boolean writerEnabled; 
	
	private Long cnt;
	
	private Long replyCount;
	
	private LocalDateTime regDate;
	
	private LocalDateTime modDate;

}
