package com.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.boot.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long>{
	
	@Modifying // SELECT를 제외한 쿼리문 사용시 사용
	@Query("UPDATE Board b SET b.cnt = b.cnt+1 WHERE b.seq = ?1")
	void boardCntUp(Long seq);
	
}

