package com.cloud.mapper;

import com.cloud.domain.MemberAuthVO;

public interface MemberAuthMapper {

	public MemberAuthVO getMamberAuth(String userid);
	
	public int addMemberAuth(MemberAuthVO memberAuthVO);
	
	public int updateMemberAuth(MemberAuthVO memberAuthVO);
	
	public int deleteMemberAuth(MemberAuthVO memberAuthVO);

}
