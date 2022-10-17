package com.boot.service;

import org.springframework.data.domain.Pageable;

import com.boot.dto.PageResultDto;
import com.boot.dto.ReplyDto;
import com.boot.entity.Board;
import com.boot.entity.Member;
import com.boot.entity.Reply;

public interface ReplyService {

	public PageResultDto<ReplyDto, Object[]> getReplyPage(Long bno, Pageable pageable);
	
	public Long writeReply(ReplyDto replyDto);
	
	public boolean updateReply(ReplyDto replyDto);
	
	public boolean deleteReply(String userId, Long rno);
	
	public default ReplyDto entityToDto(Object[] objects) {
		Reply reply = (Reply) objects[0];
		Member member = (Member) objects[1];
		Long bno = (Long) objects[2];
		
		
		ReplyDto replyDto = ReplyDto.builder()
				.rno(reply.getRno())
				.text(reply.getText())
				.replyerName(member.getName())
				.replyerId(member.getUserId())
				.bno(bno)
				.regDate(reply.getRegDate())
				.modDate(reply.getModDate())
				.build();
		return replyDto;
	}
	
	public default Reply dtoToEntity(ReplyDto replyDto) {
		Member member = Member.builder()
				.userId(replyDto.getReplyerId())
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
