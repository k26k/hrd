package com.boot.domain;

import lombok.Data;

@Data
public class Search {

	private String condition;
	
	private String word;
	
	public Search() {}
	
	public Search(String condition, String word) {
		this.condition = condition;
		this.word = word;
	}
	
}
