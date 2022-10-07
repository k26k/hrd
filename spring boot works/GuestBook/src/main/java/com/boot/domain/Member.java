package com.boot.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@ToString(exclude = "boardList")
@Data
//@Entity
public class Member {

	@Id
	@Column(name="member_id")
	private String userId;
	
	private String password;
	
	private String name;

	@Column(insertable = false, 
			updatable = false, 
			columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime regDate;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@Column(columnDefinition = "bit DEFAULT 1")
	private boolean enabled = true; 
	
	@OneToMany(mappedBy = "member", fetch = FetchType.EAGER)
	private List<Board> boardList = new ArrayList<Board>();

}
