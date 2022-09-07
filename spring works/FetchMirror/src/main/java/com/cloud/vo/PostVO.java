package com.cloud.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class PostVO {
	private int boardnum;
	private int postnum;
	private String title;
	private String id;
	private String content; 
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date writedate;
	private int hitcount;
}
