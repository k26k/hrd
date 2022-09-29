package com.boot.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.boot.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

	Page<Board> findByTitleContainingOrContentContaining(String keyword1, String keyword2, Pageable pageable);
	
	@Modifying
	@Query("UPDATE Board b SET b.cnt = b.cnt + 1 WHERE b.seq = :seq")
	void cntUp(Long seq);
	
}
