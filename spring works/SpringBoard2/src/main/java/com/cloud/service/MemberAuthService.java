package com.cloud.service;

import com.cloud.domain.MemberAuthVO;
import com.cloud.domain.MemberVO;

public interface MemberAuthService {

	public int checkMemberAuth(String userid, String passwd);
	
	public MemberVO getMemberAuth(String userid);
	
	public int addMemberAuth(MemberAuthVO memberVO);
	
	public int updateMemberAuth(MemberAuthVO memberVO, String oldid);
	
	public int deleteMemberAuth(String userid);
		
}
