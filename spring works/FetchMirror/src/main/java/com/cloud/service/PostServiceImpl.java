package com.cloud.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.mapper.PostMapper;
import com.cloud.vo.PostVO;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostMapper postMapper;
	
	@Override
	public ArrayList<PostVO> getPostList(int boardnum) {
		return postMapper.getPostList(boardnum);
	}

	@Override
	public PostVO getPost(int postnum) {
		return postMapper.getPost(postnum);
	}

	@Override
	public void addPost(PostVO postVO) {
	}

	@Override
	public void updatePost(PostVO postVO) {
	}

	@Override
	public void deletePost(int postnum) {
	}

	@Override
	public void hitUp(int postnum) {
	}

	
}
