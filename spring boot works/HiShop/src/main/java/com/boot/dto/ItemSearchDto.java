package com.boot.dto;

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
public class ItemSearchDto {

	private String searchDateType; // 등록일 조건
	
	private SellStatus sellStatus; // 판매 상태
	
	private String searchBy; // 검색 유형
	
	private String searchQuery; // 검색어
	
}
