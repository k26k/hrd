package com.spring.polymorphism;

public class LGTV implements TV {

	@Override
	public void powerOn() {
		System.out.println("LGTV-- 전원 켜기");
	}

	@Override
	public void powerOff() {
		System.out.println("LGTV-- 전원 끄기");
	}

	@Override
	public void volumeUp() {
		System.out.println("LGTV-- 볼륨 올리기");
	}

	@Override
	public void volumDown() {
		System.out.println("LGTV-- 볼륨 내리기");
	}
	
}
