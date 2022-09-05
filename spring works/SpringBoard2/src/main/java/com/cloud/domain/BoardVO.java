package com.cloud.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class BoardVO implements Serializable{
	private static final long serialVersionUID = 1L;

	private int bno;
	private String title;
	private String writer;
	private String content;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	private Date regDate;
	private int cnt;

	private MultipartFile uploadFile;
}
