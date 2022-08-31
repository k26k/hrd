package com.cloud.mapper;

import org.apache.ibatis.annotations.Param;

import com.cloud.domain.UserVO;


public interface UserMapper {

	public int checkUser(@Param("id") String id, @Param("passwd") String passwd);
	
	public UserVO getUser(String id);
	
	public int addUser(UserVO userVO);
	
	public int updateUser(UserVO userVO, @Param("oldId") String oldId);
	
	public int deleteUser(String id);

}
