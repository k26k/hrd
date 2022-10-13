package com.boot.service;

import java.time.LocalDateTime;

import org.springframework.data.domain.Pageable;

import com.boot.dto.PageResultDto;
import com.boot.dto.ReplyDto;
import com.boot.entitiy.Board;
import com.boot.entitiy.Member;
import com.boot.entitiy.Reply;

public interface ReplyService {

	public PageResultDto<ReplyDto, Object[]> getReplyPage(Long bno, Pageable pageable);
	
	public default ReplyDto entityToDto(Object[] objects) {
		Reply reply = (Reply) objects[0];
		Member member = (Member) objects[1];
		Long bno = (Long) objects[2];
		
		
		ReplyDto replyDto = ReplyDto.builder()
				.rno(reply.getRno())
				.text(reply.getText())
				.replyerName(member.getName())
				.replyerEmail(member.getEmail())
				.bno(bno)
				.regDate(reply.getRegDate())
				.modDate(reply.getModDate())
				.build();
		return replyDto;
	}
	
	public default Reply dtoToEntity(ReplyDto replyDto) {
		Member member = Member.builder()
				.email(replyDto.getReplyerEmail())
				.build();
		Board board = Board.builder()
				.bno(replyDto.getBno())
				.build();
		
		Reply reply = Reply.builder()
				.rno(replyDto.getRno())
				.text(replyDto.getText())
				.replyer(member)
				.board(board)
				.build(); 
		return reply;
	}
	
}
