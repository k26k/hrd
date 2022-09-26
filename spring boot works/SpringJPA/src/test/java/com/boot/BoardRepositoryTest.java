package com.boot;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.boot.domain.Board;
import com.boot.domain.Member;
import com.boot.persistence.BoardRepository;
import com.boot.persistence.MemberRepository;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class BoardRepositoryTest {

	@Autowired
	private BoardRepository boardRepository;
	
	@Autowired
	private MemberRepository memberRepository;
	
//	@Test
//	public void testManyToOnInsert() {
//		Member member1 = new Member();
//		member1.setId("member1");
//		member1.setName("뽀로로");
//		member1.setPassword("member1");
//		member1.setRole("ROLE_USER");
//		
//		memberRepository.save(member1);
//		
//		Member member2 = new Member();
//		member2.setId("member2");
//		member2.setName("아기상어");
//		member2.setPassword("member2");
//		member2.setRole("ROLE_ADMIN");
//		
//		memberRepository.save(member2);
//		
//		for(int i=1; i<=3; i++) {
//			Board board = new Board();
//			board.setTitle("뽀로로 이스 히어 "+i);
//			board.setContent("뽀로로로롱 "+i);
//			board.setMember(member1);
//			
//			boardRepository.save(board);
//		}
//		for(int i=1; i<=3; i++) {
//			Board board = new Board();
//			board.setTitle("아기상어 뚜루두뚜루 "+i);
//			board.setContent("귀여운 뚜루두뚜루 "+i);
//			board.setMember(member2);
//			
//			boardRepository.save(board);
//		}
//	}
	
	@Test
	public void showBoard() {
		System.out.println("showBoard() start ...");
		Iterable<Board> boards = boardRepository.findBoardByTitleContainingOrderBySeqDesc("");
		System.out.println("boards hasNext: "+boards.iterator().hasNext());
		for(Board board:boards) {
			log.info(board.toString());
		}
	}
	
	
//	삽입
//	@Test
//	public void testInsertBoard() {
//		Board board = new Board();
//		board.setTitle("CrudRepository insert 테스트 제목");
//		board.setWriter("admin");
//		board.setContent("CrudRepository insert 테스트 내용");
//		board.setCreateDate(new Date());
//		board.setCnt(0L);
//		
//		boardRepository.save(board);
//	}

	
//	조회
//	@Test
//	public void testGetBoard() {
//		log.info(boardRepository.findById(1L).toString());
//	}

	
//	전체 조회
//	@Test
//	public void testGetBoardList() {
//		Iterable<Board> boardList = boardRepository.findAll();
//		
//		for(Board board:boardList) {
//			log.info(board.toString());
//		}
//	}
	
	
//	수정
//	@Test
//	public void testUpdateBoard() {
//		Board board = boardRepository.findById(1L).get();
//		log.info(board.toString());
//		board.setTitle("CrudRepository update 테스트 제목 수정됨");
//		board.setContent("CrudRepository update 테스트 내용 수정됨");
//		log.info(board.toString());
//		boardRepository.save(board);		
//	}
	
	
//	삭제
//	@Test
//	public void testUpdateBoard() {
//		boardRepository.deleteById(2L);
//	}
	
}
