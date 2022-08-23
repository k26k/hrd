package com.spring.annotation;

public class SamsungTV implements TV {

	private Speaker speaker;
	private int price;
	
	public SamsungTV() {
		System.out.println("==> SamsungTV(1) 객체 생성");		
	}
	
	public Speaker getSpeaker() {
		return speaker;
	}
	public void setSpeaker(Speaker speaker) {
		System.out.println("setSpeaker() 호출");
		this.speaker = speaker;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		System.out.println("setPrice() 호출");
		this.price = price;
	}

	@Override
	public void powerOn() {
		System.out.println("SamsungTV -- 전원 켜기(가격: "+price+"원)");
	}

	@Override
	public void powerOff() {
		System.out.println("SamsungTV -- 전원 끄기");
	}

	@Override
	public void volumeUp() {
		speaker.volumeUp();
	}

	@Override
	public void volumDown() {
		speaker.volumeDown();
	}
	
}
