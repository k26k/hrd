package com.boot.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.boot.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long>, QuerydslPredicateExecutor<Board> {

	@Transactional
	@Modifying
	@Query("UPDATE Board b set b.cnt = b.cnt+1 WHERE b.bno = :bno")
	public void cntUp(Long bno);
	
	@Transactional
	@Modifying
	@Query("UPDATE Board b set b.replyCount = b.replyCount+1 WHERE b.bno = :bno")
	public void replyCountUp(Long bno);
	
	@Transactional
	@Modifying
	@Query("UPDATE Board b set b.replyCount = b.replyCount-1 WHERE b.bno = :bno")
	public void replyCountDowm(Long bno);
	
	@Query( value = "SELECT b, w "
			+ "FROM Board b "
			+ "LEFT JOIN b.writer w "
			+ "GROUP BY b")
	public Page<Object[]> getBoardPage(Pageable pageable);
	
	@Query( value = "SELECT b, w "
			+ "FROM Board b "
			+ "LEFT JOIN b.writer w "
			+ "WHERE b.bno = :bno")
	public Object getBoardByBno(@Param("bno") Long bno);
	
}
