package com.boot.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.boot.constant.Role;
import com.boot.constant.SellStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
@Entity
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "item_id")
	private Long id;

	@Column(nullable = false, length = 50)
	private String itemName;

	@Column(nullable = false)
	private Integer price;
	
	@Column(nullable = false)
	private Integer stockNumber;
	
	@Lob
	@Column(nullable = false)
	private String itemDetail;
	
	@Enumerated(EnumType.STRING)
	private SellStatus sellStatus;

	@CreatedDate
	private LocalDate regDate;

	@LastModifiedDate
	private LocalDate updateDate;

}
