package com.cloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.domain.MemberVO;
import com.cloud.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper memderMapper;
	
	@Override
	public int checkMember(String userid, String passwd) {
		return 0;
	}

	@Override
	public MemberVO getMember(String userid) {
		return memderMapper.getMember(userid);
	}

	@Override
	public int addMember(MemberVO memberVO) {
		return memderMapper.addMember(memberVO);
	}

	@Override
	public int updateMember(MemberVO memberVO, String oldid) {
		return 0;
	}

	@Override
	public int deleteMember(String userid) {
		return 0;
	}

}
