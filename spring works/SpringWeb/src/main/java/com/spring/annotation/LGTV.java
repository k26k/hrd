package com.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("tv5")
public class LGTV implements TV {

	@Autowired
	private Speaker speaker;

	public LGTV() {
		System.out.println("==> LGTV(1) 객체 생성");		
	}
	
	@Override
	public void powerOn() {
		System.out.println("LGTV -- 전원 켜기");
	}

	@Override
	public void powerOff() {
		System.out.println("LGTV -- 전원 끄기");
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
