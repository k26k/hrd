package com.cloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.domain.UserVO;
import com.cloud.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper; 
	
	@Override
	public int checkUser(String id, String passwd) {
		return userMapper.checkUser(id, passwd);
	}

	@Override
	public UserVO getUser(String id) {
		return userMapper.getUser(id);
	}

	@Override
	public int addUser(UserVO userVO) {
		return userMapper.addUser(userVO);
	}

	@Override
	public int updateUser(UserVO userVO, String oldId) {
		return userMapper.updateUser(userVO, oldId);
	}

	@Override
	public int deleteUser(String id) {
		return userMapper.deleteUser(id);
	}

}
