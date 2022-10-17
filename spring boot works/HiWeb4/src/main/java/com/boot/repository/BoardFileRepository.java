package com.boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.boot.entity.BoardFile;

public interface BoardFileRepository extends JpaRepository<BoardFile, String> {

	@Modifying
	@Query("SELECT bf FROM BoardFile bf WHERE bf.board.bno = :bno")
	public List<BoardFile> findByBoardId(Long bno);
	
}
