package com.cloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.domain.MemberAuthVO;
import com.cloud.domain.MemberVO;
import com.cloud.mapper.MemberAuthMapper;

@Service
public class MemberAuthServiceImpl implements MemberAuthService {

	@Autowired
	private MemberAuthMapper memberAuthMapper;
	
	@Override
	public int checkMemberAuth(String userid, String passwd) {
		return 0;
	}

	@Override
	public MemberVO getMemberAuth(String userid) {
		return null;
	}

	@Override
	public int addMemberAuth(MemberAuthVO memberAuthVO) {
		return memberAuthMapper.addMemberAuth(memberAuthVO);
	}

	@Override
	public int updateMemberAuth(MemberAuthVO memberAuthVO, String oldid) {
		return 0;
	}

	@Override
	public int deleteMemberAuth(MemberAuthVO memberAuthVO) {
		return 0;
	}

}
