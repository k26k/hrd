package com.boot.entitiy;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Entity
public class Member extends BaseEntity {

	@Id
	private String email;
	
	private String password;
	
	private String name;
	
//	@OneToMany(mappedBy = "writer", fetch = FetchType.LAZY)
//	private List<Board> boardList;
//	
//	@OneToMany(mappedBy = "replyer", fetch = FetchType.LAZY)
//	private List<Reply> replyList;
	
}
