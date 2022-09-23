package com.boot.persistence;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.boot.domain.Board;

public interface BoardRepository2 extends JpaRepository<Board, Long> {

//	변수와 일치하는 목록을 검색
//	쿼리 메소드 find + 엔티티 이름 + By + 변수 이름 (엔티티 이름은 생략 가능함)
	List<Board> findBoardByTitle(String title);
	
//	변수를 포함하는 목록을 검색
//	쿼리 메소드 find + 엔티티 이름 + By + 변수 이름 + Containing (엔티티 이름은 생략 가능함)
	List<Board> findBoardByContentContaining(String content);
	
//	복수의 조건을 가진 목록을 검색
//	쿼리 메소드 find + 엔티티 이름 + By + 변수1 + Or + 변수2  (엔티티 이름은 생략 가능함)
	List<Board> findBoardByTitleContainingOrContentContaining(String title, String content);

//	데이터 정렬하기
//	쿼리 메소드 find + 엔티티 이름 + By + 변수1 + OrderBy + 변수 + Asc, Desc  (엔티티 이름은 생략 가능함)
	List<Board> findBoardByTitleContainingOrderBySeqDesc(String title);
	
//	Quert 어노테이션을 이용한 sql 쿼리문 사용하기
	@Query("SELECT b FROM Board b ORDER BY seq DESC")
	List<Board> queryOrderByDesc();
	
//	위치 기반 파라미터 설정
	@Query("SELECT b FROM Board b WHERE b.title LIKE %?1% ORDER BY b.seq DESC")
	List<Board> queryAnnotationTest1(String text);
	
//	파라미터 이름 기반 파라미터 설정
	@Query("SELECT b FROM Board b WHERE b.title LIKE %:text% ORDER BY b.seq DESC")
	List<Board> queryAnnotationTest2(@Param("text") String text);
	
}
