package com.cloud.service;

import java.util.ArrayList;

import com.cloud.vo.BoardCategoryVO;
import com.cloud.vo.CommentVO;

public interface CommentService {

	public ArrayList<CommentVO> getCommentList(int postnum);
	
	public void addComment(CommentVO commentVO);
	
	public void updateComment(CommentVO commentVO);
	
	public void deleteComment(int comment_num);

}
