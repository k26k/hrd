package com.boot.repository;

import java.util.stream.IntStream;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.boot.entitiy.Board;
import com.boot.entitiy.Member;

@SpringBootTest
public class BoardRepositoryTest {

	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private BoardRepository boardRepository;
	
	
//	@Test
	public void insertBoard() {
		IntStream.rangeClosed(1, 100).forEach( i -> {
			IntStream.rangeClosed(1, 10).forEach( j -> {
				Member member = memberRepository.findById("id"+i+"@qwe.com").get();
				Board board = Board.builder()
						.writer(member)
						.title(member.getName()+"의 "+j+"번째 게시물")
						.content(i+", "+j+" 내용")
						.build();
				
				boardRepository.save(board);
			});
		});
	}
	
//	@Test
	@Transactional
	public void getBoard() {
		
		Board board = boardRepository.findById(100L).get();
		
		System.out.println(board.getBno()+"번 게시글");
		System.out.println("작성자: "+board.getWriter().toString());
		
	}
	
//	@Test
	public void getBoardByGetBoardWithWriter() {
		Object object = boardRepository.getBoardWithWriter(1L);
		for(Object o : (Object[])object) {
			System.out.println(o.toString());
		}
		
	}
	
//	@Test
	public void getBoardByGetBoardWithReplyCount() {
		Pageable pageable = PageRequest.of(1, 10);
		Page<Object[]> page = boardRepository.getBoardWithReplyCount(pageable);
		
		page.forEach(p->{
			for(Object o: p) {
				System.out.print(o+" / ");
			}
			System.out.println("");
		});
	}
	
//	@Test
	public void getBoardByGetBoardByBno() {
		Object object = boardRepository.getBoardByBno(1L);
		
		for(Object o: (Object[])object) {
			System.out.println(o.toString());
		}
	}
	
}
