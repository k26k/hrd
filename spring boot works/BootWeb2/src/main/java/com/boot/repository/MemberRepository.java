package com.boot.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.boot.domain.Member;

public interface MemberRepository extends JpaRepository<Member, String> {
	
	Page<Member> findByIdContainingOrNameContaining(String searchKeywordId, String searchKeywordName, Pageable paging);
	
	@Query("SELECT COUNT(member_id) FROM Member m WHERE member_id = ?1 ")
	public int checkId(String id);
	
}
