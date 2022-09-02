package com.cloud.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.cloud.domain.MemberVO;


public interface MemberMapper {

	public int checkMember(@Param("userid") String userid, @Param("passwd") String passwd);
	
	public List<MemberVO> getMemberList();
	
	public MemberVO getMember(@Param("userid") String userid);
	
	public int addMember(MemberVO memberVO);
	
	public int updateMember(@Param("map") Map<String, Object> map);
	
	public int deleteMember(String userid);

}
