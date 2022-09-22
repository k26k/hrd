package com.boot.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Board {
	
	@Id // 기본키
	@GeneratedValue // 기본키 자동 할당
	private Long seq;
	
	private String title;
	private String writer;
	private String content;
	
	private Date createDate;
	private Long cnt;
	
}
