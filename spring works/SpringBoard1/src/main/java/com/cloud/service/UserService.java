package com.cloud.service;

import com.cloud.repository.UserVO;

public interface UserService {

	public boolean checkUser(String id, String passwd);
	
	public int addUser(UserVO userVO);
	
	public int updateUser(UserVO userVO);
	
	public int deleteUser(String id);
	
}
