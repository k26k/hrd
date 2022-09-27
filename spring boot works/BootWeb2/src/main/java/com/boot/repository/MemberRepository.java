package com.boot.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.domain.Member;

public interface MemberRepository extends JpaRepository<Member, String> {
	
	Page<Member> findByIdContainingOrNameContaining(String searchKeywordId, String searchKeywordName, Pageable paging);
	
}
