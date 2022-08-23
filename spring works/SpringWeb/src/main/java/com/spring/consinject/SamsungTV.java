package com.spring.consinject;

public class SamsungTV implements TV {

	private SonySpeaker speaker;
	
	public SamsungTV() {
		System.out.println("==> SamsungTV(1) 객체 생성");		
	}
	
	public SamsungTV(SonySpeaker speaker) {
		System.out.println("==> SamsungTV(2) 객체 생성");	
		this.speaker = speaker;
	}
	
	@Override
	public void powerOn() {
		System.out.println("SamsungTV -- 전원 켜기");
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
	
//	@Override
//	public void volumeUp() {
//		System.out.println("SamsungTV -- 볼륨 올리기");
//	}
//
//	@Override
//	public void volumDown() {
//		System.out.println("SamsungTV -- 볼륨 내리기");
//	}
	
}
