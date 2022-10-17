package com.boot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@TableGenerator(
    name = "replySeqGenerator",
    table = "reply_table_id_seq",
    pkColumnName = "table_name",
    pkColumnValue = "reply_id",
    valueColumnName = "table_max_id",
    initialValue = 0,
    allocationSize = 1
)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"board", "replyer"})
@Getter
@Entity
@Table(name="reply_table")
public class Reply extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "replySeqGenerator")
	@Column(name="reply_id")
	private Long rno;
	
	private String text;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Board board;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Member replyer;
	
}
