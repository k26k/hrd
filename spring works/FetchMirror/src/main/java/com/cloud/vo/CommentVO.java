package com.cloud.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class CommentVO {
	private int comment_num;
	private int postnum;
	private String contents;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date writedate;
	private String id;
}
