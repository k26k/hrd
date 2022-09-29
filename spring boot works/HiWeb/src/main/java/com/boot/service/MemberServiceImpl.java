package com.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.repository.BoardRepository;
import com.boot.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private BoardRepository boardRepository;
	
	@Autowired
	private MemberRepository memberRepository;
	
}
