package com.boot.repository;

import java.util.Iterator;
import java.util.stream.IntStream;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@SpringBootTest
public class ReplyRepositoryTest {

	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private BoardRepository boardRepository;
	
	@Autowired
	private ReplyRepository replyRepository;
	
//	@Test
//	public void insertReply() {
//		IntStream.rangeClosed(1, 100).forEach( i -> {
//			IntStream.rangeClosed(1, 20).forEach( j -> {
//				int randNum = (int)(Math.random() * 20);
//				randNum++;
//				Member member = memberRepository.findById("id"+randNum+"@qwe.com").get();
//				Board board = boardRepository.findById(Long.valueOf(i)).get();
//				Reply reply = Reply.builder()
//						.board(board)
//						.replyer(member)
//						.text(board.getBno()+"번 게시글에 "+member.getName()+"이가 작성한 댓글")
//						.build();
//				
//				replyRepository.save(reply);
//			});
//		});
//	}
//	
////	@Test
//	@Transactional
//	public void getReply() {
//		Reply reply = replyRepository.findById(1L).get();
//		System.out.println(reply.getRno()+"번 댓글");
//		System.out.println("게시판: "+reply.getBoard());
//	}
//	
////	@Test
//	@Transactional
//	public void getReplyByBoard() {
//		Board board = Board.builder().bno(1L).build();
//		Pageable pageable = PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "rno"));
//		
////		Page<Reply> page = replyRepository.findByBoard(board, pageable);
////		page.toList().forEach(p->System.out.println(p.toString()));
//	}
	
}
