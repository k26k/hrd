package com.cloud.mapper;

import org.apache.ibatis.annotations.Param;

import com.cloud.domain.MemberAuthVO;

public interface MemberAuthMapper {

	public MemberAuthVO getMamberAuth(String userid);
	
	public int addMemberAuth(MemberAuthVO memberAuthVO);
	
	public int updateMemberAuth(MemberAuthVO memberAuthVO, @Param("oldid") String oldid);
	
	public int deleteMemberAuth(MemberAuthVO memberAuthVO);

}
