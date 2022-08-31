package com.cloud.service;

import com.cloud.domain.MemberVO;

public interface MemberService {

	public int checkMember(String userid, String passwd);
	
	public MemberVO getMember(String userid);
	
	public int addMember(MemberVO memberVO);
	
	public int updateMember(MemberVO memberVO, String oldid);
	
	public int deleteMember(String userid);
		
}
