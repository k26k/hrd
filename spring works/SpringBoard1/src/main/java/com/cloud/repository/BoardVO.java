package com.cloud.repository;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class BoardVO {
	
	private int bno;
	private String title;
	private String writer;
	private String content;
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss.SSS")
	private Date regDate;
	private int cnt;

}
