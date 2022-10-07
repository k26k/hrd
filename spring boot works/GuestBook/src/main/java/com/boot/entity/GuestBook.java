package com.boot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@TableGenerator(
    name = "guestBookSeqGenerator",
    table = "guest_book_id_seq",
    pkColumnName = "table_name",
    pkColumnValue = "guest_book_id",
    valueColumnName = "table_max_id",
    initialValue = 0,
    allocationSize = 1
)
@Entity
public class GuestBook extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "guestBookSeqGenerator")
	@Column(name = "guest_book_id")
	private Long gno;
	
	@Column(length = 100, nullable = false)
	private String title;
	
	@Column(length = 1500, nullable = false)
	private String content;
	
	@Column(length = 50, nullable = false)
	private String writer;
	
	public void changeTitle(String title) {
		this.title = title;
	}
	
	public void changeContent(String content) {
		this.content = content;
	}
	
}
