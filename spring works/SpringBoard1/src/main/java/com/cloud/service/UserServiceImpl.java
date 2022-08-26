package com.cloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.repository.UserDAO;
import com.cloud.repository.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public boolean checkUser(String id, String passwd) {
		return userDAO.checkUser(id, passwd);
	}

	@Override
	public int addUser(UserVO userVO) {
		return userDAO.addUser(userVO);
	}

	@Override
	public int updateUser(UserVO userVO) {
		return userDAO.updateUser(userVO);
	}

	@Override
	public int deleteUser(String id) {
		return userDAO.deleteUser(id);
	}

}
