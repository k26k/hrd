package com.cloud.service;

import com.cloud.repository.userVO;

public interface UserService {

	public boolean checkUser(String id, String passwd);
	
	public int addUser(userVO userVO);
	
	public int updateUser(userVO userVO);
	
	public int deleteUser(String id);
	
}
