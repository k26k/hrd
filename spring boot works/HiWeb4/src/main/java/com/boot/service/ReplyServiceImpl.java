package com.boot.service;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.boot.dto.PageRequestDto;
import com.boot.dto.PageResultDto;
import com.boot.dto.ReplyDto;
import com.boot.entity.Reply;
import com.boot.repository.ReplyRepository;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyRepository replyRepository;
	
	@Override
	public PageResultDto<ReplyDto, Object[]> getReplyPage(Long bno, Pageable pageable) {
		Page<Object[]> page = replyRepository.getByBno(bno, pageable);
		Function<Object[], ReplyDto> func = (o->this.entityToDto(o));
		PageResultDto<ReplyDto, Object[]> pageResultDto = new PageResultDto<>(page, func);
		return pageResultDto;
	}

	@Override
	public Long writeReply(ReplyDto replyDto) {
		Reply reply = this.dtoToEntity(replyDto);
		replyRepository.save(reply);
		return reply.getRno();
	}

	@Override
	public boolean updateReply(ReplyDto replyDto) {
		return false;
	}

	@Override
	public boolean deleteReply(String userId, Long rno) {
		return false;
	}

}
