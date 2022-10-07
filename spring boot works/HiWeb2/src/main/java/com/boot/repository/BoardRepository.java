package com.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.transaction.annotation.Transactional;

import com.boot.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long>, QuerydslPredicateExecutor<Board> {

	@Transactional
	@Modifying
	@Query("UPDATE Board b set b.cnt = b.cnt+1 WHERE b.seq = :seq")
	public void cntUp(Long seq);
	
}
