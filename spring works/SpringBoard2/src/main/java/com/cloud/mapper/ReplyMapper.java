package com.cloud.mapper;

import java.util.List;

import com.cloud.domain.ReplyVO;

public interface ReplyMapper {

	public int addReply(ReplyVO replyVO);
	
	public List<ReplyVO> getReplyList(int bno);
	
}
