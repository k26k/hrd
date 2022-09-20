package com.cloud.service;

import java.util.List;

import com.cloud.domain.ReplyVO;

public interface ReplyService {

	public int addReply(ReplyVO replyVO);
	
	public List<ReplyVO> getReplyList(int bno);
	
}
