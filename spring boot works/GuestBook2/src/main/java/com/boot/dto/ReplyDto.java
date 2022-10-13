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
public class ReplyDto {
	
	private Long rno;
	
	private String text;
	
	private String replyerName;
	
	private String replyerEmail;
	
	private Long bno;
	
	private LocalDateTime regDate;
	
	private LocalDateTime modDate;
	
}
