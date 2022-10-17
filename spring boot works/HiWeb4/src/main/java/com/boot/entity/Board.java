package com.boot.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.ColumnDefault;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@TableGenerator(
    name = "boardSeqGenerator",
    table = "board_table_id_seq",
    pkColumnName = "table_name",
    pkColumnValue = "board_id",
    valueColumnName = "table_max_id",
    initialValue = 0,
    allocationSize = 1
)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"writer", "boardFileList", "replyList"})
@Getter
@Entity
@Table(name="board_table")
public class Board extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "boardSeqGenerator")
	@Column(name = "board_id")
	private Long bno;
	
	private	String title;
	
	private	String content;
	
	@Column(insertable = false,
			updatable = false,
			columnDefinition = "bigint")
	@ColumnDefault("0")
	private Long cnt;
	
	@Column(insertable = false,
			updatable = false,
			columnDefinition = "bigint")
	@ColumnDefault("0")
	private Long replyCount;
	
	@ManyToOne
	@JoinColumn(name = "member_id",
				nullable = false,
				updatable = false)
	private Member writer;
	
	@OneToMany(mappedBy = "board", fetch = FetchType.LAZY)
	private List<BoardFile> boardFileList;
	
	@OneToMany(mappedBy = "board", fetch = FetchType.LAZY)
	private List<Reply> replyList;
	
}
