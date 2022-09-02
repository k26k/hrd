package com.cloud.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.cloud.domain.MemberVO;

public interface MemberService {

	public int checkMember(String userid, String passwd);
	
	public List<MemberVO> getMemberList();
	
	public MemberVO getMember(String userid);
	
	public int addMember(MemberVO memberVO);
	
	public int updateMember(Map<String, Object> map);
	
	public int deleteMember(String userid);
		
}
