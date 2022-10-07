package com.boot.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;

import lombok.Data;
import lombok.ToString;

@TableGenerator(
    name = "boardSeqGenerator",
    table = "board_id_seq",
    pkColumnName = "table_name",
    pkColumnValue = "board_id",
    valueColumnName = "table_max_id",
    initialValue = 0,
    allocationSize = 1
)
@ToString(exclude = "member")
@Data
@Entity
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "boardSeqGenerator")
	@Column(name = "board_id")
	private Long seq;
	
	private	String title;
	
	private	String content;
	
	@Column(insertable = false,
			updatable = false,
			columnDefinition = "timestamp DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime createDate;
	
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
