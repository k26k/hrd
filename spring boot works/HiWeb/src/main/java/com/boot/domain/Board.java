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
@Data
@Entity
public class Board {

	@Id
	@GeneratedValue
	private Long seq;
	
	private	String title;
	
	private	String content;
	
	@Column(insertable = false,
			updatable = false,
			columnDefinition = "timestamp DEFAULT CURRENT_TIMESTAMP")
	private Date createDate;
	
	@Column(insertable = false,
			updatable = false,
			columnDefinition = "bigint DEFAULT 0")
	private Long cnt = 0L;
	
	@ManyToOne
	@JoinColumn(name = "member_id",
				nullable = false,
				updatable = false)
	private Member member;
	
	public void setMember(Member member) {
		this.member = member;
		member.getBoardList().add(this);
	}
	
}
