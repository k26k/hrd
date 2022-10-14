package com.boot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"board"})
@Getter
@Entity
@Table(name="file_table")
public class BoardFile extends BaseEntity {

	@Id
	@Column(name="file_id")
	private String fileUuId ; 		//파일 이름을 unique하게 만들 필드
	
	private String fileName; 	//파일 이름
	
	private String contentType;	//확장자
	
	@ManyToOne
	@JoinColumn(name = "board_id",
				nullable = false,
				updatable = false)
	private Board board;
	
}
