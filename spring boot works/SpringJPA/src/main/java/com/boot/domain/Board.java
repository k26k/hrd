package com.boot.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.ToString;

@ToString(exclude = "member")
@Entity
@Data
public class Board {
	
	@Id
	@GeneratedValue
	// 기본키, 값이 자동으로 올라감
	private Long seq;
	
	private String title;
	
//	@Column(updatable = false) // 업데이트시 수정 안됨
//	private String writer;
	
	private String content;
	
	@Column(insertable = false, 
			updatable = false, 
			columnDefinition = "timestamp default current_timestamp") 
	// 입력시 수동입력 안됨, 업데이트시 수정 안됨, 시간 자동으로 입력됨
	private Date createDate;
	
//	@Column(insertable = false, 
//			updatable = false, 
//			columnDefinition = "bigint default 0 on update cnt + 1") 
//	// 입력시 수동입력 안됨, 업데이트시 수정 안됨, 기본으로 0 입력됨
//	private Long cnt;
	
	@Column(insertable = false, 
			updatable = false, 
			columnDefinition = "bigint default 0") 
	// 입력시 수동입력 안됨, 업데이트시 수정 안됨, 기본으로 0 입력됨
	private Long cnt;
	
	@ManyToOne
	@JoinColumn(name = "MEMBER_ID",
				updatable = false)
	private Member member;
	
}

