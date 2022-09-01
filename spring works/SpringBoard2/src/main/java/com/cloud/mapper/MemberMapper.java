package com.cloud.mapper;

import org.apache.ibatis.annotations.Param;

import com.cloud.domain.MemberAuthVO;
import com.cloud.domain.MemberVO;


public interface MemberMapper {

	public int checkMember(@Param("userid") String userid, @Param("passwd") String passwd);
	
	public MemberVO getMember(@Param("userid") String userid);
	
	public int addMember(MemberVO memberVO);
	
	public int updateMember(MemberVO memberVO, @Param("oldid") String oldid);
	
	public int deleteMember(String userid);

}
