package com.spring.service;

import com.spring.user.UserDAO;
import com.spring.user.UserVO;

public class UserServiceImpl implements UserService {

	private UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@Override
	public boolean login(UserVO user) {
		return userDAO.login(user);
	}


}
