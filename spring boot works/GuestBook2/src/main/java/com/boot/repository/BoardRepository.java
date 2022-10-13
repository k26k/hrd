package com.boot.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.boot.entitiy.Board;
import com.querydsl.core.BooleanBuilder;

public interface BoardRepository extends JpaRepository<Board, Long> {

	@Query("SELECT b, w FROM Board b LEFT JOIN b.writer w WHERE b.bno = :bno")
	public Object getBoardWithWriter(@Param("bno") Long bno);
	
	@Query("SELECT b, r FROM Board b LEFT JOIN Reply r ON r.board = b WHERE b.bno = :bno")
	public Object getBoardWithReply(@Param("bno") Long bno);
	
	@Query( value = "SELECT b, w, count(r) "
			+ "FROM Board b "
			+ "LEFT JOIN b.writer w "
			+ "LEFT JOIN Reply r ON r.board = b "
			+ "GROUP BY b",
			countQuery = "SELECT count(b) FROM Board b")
	public Page<Object[]> getBoardWithReplyCount(Pageable pageable);
	
	@Query( value = "SELECT b, w, count(r)"
			+ "FROM Board b "
			+ "LEFT JOIN b.writer w "
			+ "LEFT JOIN Reply r ON r.board = b "
			+ "WHERE b.bno = :bno")
	public Object getBoardByBno(@Param("bno") Long bno);
	
}
