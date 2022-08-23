package com.spring.consinject;

public class SamsungTV implements TV {

	private SonySpeaker speaker;
	
	public SamsungTV() {
		System.out.println("==> SamsungTV(1) ��ü ����");		
	}
	
	public SamsungTV(SonySpeaker speaker) {
		System.out.println("==> SamsungTV(2) ��ü ����");	
		this.speaker = speaker;
	}
	
	@Override
	public void powerOn() {
		System.out.println("SamsungTV -- ���� �ѱ�");
	}

	@Override
	public void powerOff() {
		System.out.println("SamsungTV -- ���� ����");
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
//		System.out.println("SamsungTV -- ���� �ø���");
//	}
//
//	@Override
//	public void volumDown() {
//		System.out.println("SamsungTV -- ���� ������");
//	}
	
}
