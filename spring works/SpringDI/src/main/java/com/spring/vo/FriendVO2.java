package com.spring.vo;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FriendVO2 {

	private String name;
	private int age;
	
//	public FriendVO2(String name, int age) {
//		this.name = name;
//		this.age = age;
//	}

	@Override
	public String toString() {
		return "FriendVO2 [name=" + name + ", age=" + age + "]";
	}
}
