package com.boot.domain;

import lombok.Data;

@Data
public class Search {

	private String searchCondition;
	
	private String searchKeyword;
	
	public Search() {}
	
	public Search(String searchCondition, String searchKeyword) {
		this.searchCondition = searchCondition;
		this.searchKeyword = searchKeyword;
	}
	
}
