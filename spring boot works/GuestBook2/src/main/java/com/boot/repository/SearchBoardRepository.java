package com.boot.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.querydsl.core.Tuple;

public interface SearchBoardRepository  {

	public List<Tuple> searchList();
	
	Page<Object[]> searchPage(String type, String keyword, Pageable pageable);
	
}
