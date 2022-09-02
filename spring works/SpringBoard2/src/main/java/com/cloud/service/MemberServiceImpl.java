package com.cloud.service;

import java.util.List;
import java.util.Map;

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
	public List<MemberVO> getMemberList() {
		return memderMapper.getMemberList();
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
	public int updateMember(Map<String, Object> map) {
		return memderMapper.updateMember(map);
	}

	@Override
	public int deleteMember(String userid) {
		return memderMapper.deleteMember(userid);
	}

}
