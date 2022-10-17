package com.boot.dto;

import java.time.LocalDateTime;

import com.boot.domain.Role;

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
	
	private String replyerId;
	
	private String replyerName;
	
	private Role replyerRole;
	
	private Boolean replyerEnabled; 
	
	private Long bno;
	
	private LocalDateTime regDate;
	
	private LocalDateTime modDate;
	
}
