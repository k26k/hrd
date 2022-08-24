package com.spring.service;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.board.BoardDAO;
import com.spring.board.BoardVO;
import com.spring.user.UserDAO;
import com.spring.user.UserVO;

public class UserServiceClient {

	public static void main(String[] args) {
		
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		UserService userService = (UserService) container.getBean("userService");
		 		
		UserVO userVO = new UserVO();
		userVO.setId("test");
		userVO.setPasswd("1234");
		
		boolean login = userService.login(userVO);
		
		if(login) {
			System.out.println("로그인 성공");
		}else{
			System.out.println("로그인 실패");
		}
		
		container.close();
	}
	
}
