package com.spring.service;

import org.springframework.stereotype.Service;

import com.spring.vo.FriendVO;
import com.spring.vo.FriendVO2;

@Service
public class HomeService {

	
	
	public void sayHello() {
		//System.out.println("하이루");
		
		FriendVO friendVO1 = new FriendVO();
		friendVO1.setName("안산");
		friendVO1.setAge(21);
		
		FriendVO2 friendVO2 = new FriendVO2("장", 26);
		
		System.out.println(friendVO1.toString());
		System.out.println(friendVO2.toString());
	}
	
}
