package com.boot.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.boot.entity.Member;
import com.querydsl.core.Tuple;

public interface SearchRepository  {

	public List<Tuple> searchList();
	
	public Page<Object[]> searchBoardPage(String type, String keyword, Pageable pageable);
	
	public Page<Member> searchMemberPage(String type, String keyword, Pageable pageable);
	
}
