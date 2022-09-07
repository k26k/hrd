package com.cloud.mapper;

import java.util.ArrayList;

import com.cloud.vo.PostVO;

public interface PostMapper {

	public ArrayList<PostVO> getPostList(int boardnum);
	
	public PostVO getPost(int postnum);
	
	public void addPost(PostVO postVO);
	
	public void updatePost(PostVO postVO);
	
	public void deletePost(int postnum);

	public void hitUp(int postnum);
	
}
