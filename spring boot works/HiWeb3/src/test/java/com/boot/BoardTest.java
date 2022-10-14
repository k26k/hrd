package com.boot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.boot.repository.BoardRepository;
import com.boot.repository.MemberRepository;

@SpringBootTest
public class BoardTest {

	@Autowired
	private BoardRepository boardRepository;
	
	@Autowired
	private MemberRepository memberRepository;
	
////	@Test
//	public void setBoard() {
//		Member member = memberRepository.findById("member").get();
//		for(int i=1; i<=7; i++) {
//			Board board = new Board();
//			board.setMember(member);
//			board.setTitle(member.getName()+"이가 등록한 "+i+"번 게시글 제목");
//			board.setContent(member.getName()+"이가 등록한 "+i+"번 게시글 내용");
//			boardRepository.save(board);
//		}
//		
//		member = memberRepository.findById("admin").get();
//		for(int i=1; i<=7; i++) {
//			Board board = new Board();
//			board.setMember(member);
//			board.setTitle(member.getName()+"이가 등록한 "+i+"번 게시글 제목");
//			board.setContent(member.getName()+"이가 등록한 "+i+"번 게시글 내용");
//			boardRepository.save(board);
//		}
//	}
//	
////	@Test
//	public void getBoardBySeq() {
//		Board board = boardRepository.findById(5L).get();
//		System.out.println("getBoardBySeq board: "+board.toString());
//	}
//	
////	@Test
//	public void getBoardByMember() {
//		Member member = memberRepository.findById("member").get();
//		for(Board board: member.getBoardList()) {
//			System.out.println("board: "+board.toString());
//		}
//		
//	}
	
}
