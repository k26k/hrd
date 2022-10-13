package com.boot.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.boot.entitiy.Board;
import com.boot.entitiy.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Long> {

	@Query( value = "SELECT r, m, r.board.bno "
			+ "FROM Reply r "
			+ "LEFT JOIN r.replyer m "
			+ "WHERE r.board.bno = :bno "
			+ "GROUP BY r")
	public Page<Object[]> getByBno(@Param("bno") Long bno, Pageable pageable);
	
}
