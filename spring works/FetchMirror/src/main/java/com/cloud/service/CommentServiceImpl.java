package com.cloud.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.mapper.CommentMapper;
import com.cloud.vo.BoardCategoryVO;
import com.cloud.vo.CommentVO;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentMapper commentMapper;

	@Override
	public ArrayList<CommentVO> getCommentList(int postnum) {
		return commentMapper.getCommentList(postnum);
	}

	@Override
	public void addComment(CommentVO commentVO) {
		commentMapper.addComment(commentVO);
	}

	@Override
	public void updateComment(CommentVO commentVO) {
		
	}

	@Override
	public void deleteComment(int comment_num) {
		
	}
	
	
	
}
