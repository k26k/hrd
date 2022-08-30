package com.cloud.service;

import com.cloud.domain.UserVO;

public interface UserService {

	public int checkUser(String id, String passwd);
	
	public UserVO getUser(String id);
	
	public int addUser(UserVO userVO);
	
	public int updateUser(UserVO userVO, String oldId);
	
	public int deleteUser(String id);
	
}
