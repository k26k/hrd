package com.boot.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

import com.boot.domain.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"boardList", "replyList"})
@Getter
@Entity
@Table(name="member_table")
public class Member extends BaseEntity {

	@Id
	@Column(name="member_id")
	private String userId;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private String name;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@Column(insertable = false, columnDefinition = "bit")
	@ColumnDefault("1")
	private boolean enabled; 
	
	@OneToMany(mappedBy = "writer", fetch = FetchType.LAZY)
	private List<Board> boardList;
	
	@OneToMany(mappedBy = "replyer", fetch = FetchType.LAZY)
	private List<Reply> replyList;

}
