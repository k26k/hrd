package com.spring.polymorphism;

public class SamsungTV implements TV {

	@Override
	public void powerOn() {
		System.out.println("SamsungTV-- 전원 켜기");
	}

	@Override
	public void powerOff() {
		System.out.println("SamsungTV-- 전원 끄기");
	}

	@Override
	public void volumeUp() {
		System.out.println("SamsungTV-- 볼륨 올리기");
	}

	@Override
	public void volumDown() {
		System.out.println("SamsungTV-- 볼륨 내리기");
	}
	
}
