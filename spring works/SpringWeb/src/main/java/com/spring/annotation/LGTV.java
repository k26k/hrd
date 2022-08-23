package com.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("tv5")
public class LGTV implements TV {

	@Autowired
	private Speaker speaker;

	public LGTV() {
		System.out.println("==> LGTV(1) ��ü ����");		
	}
	
	@Override
	public void powerOn() {
		System.out.println("LGTV -- ���� �ѱ�");
	}

	@Override
	public void powerOff() {
		System.out.println("LGTV -- ���� ����");
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
