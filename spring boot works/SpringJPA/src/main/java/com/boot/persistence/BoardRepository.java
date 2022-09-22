package com.boot.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.boot.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long> {

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
	
}
