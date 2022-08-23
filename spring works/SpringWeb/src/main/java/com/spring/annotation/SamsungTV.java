package com.spring.annotation;

public class SamsungTV implements TV {

	private Speaker speaker;
	private int price;
	
	public SamsungTV() {
		System.out.println("==> SamsungTV(1) ��ü ����");		
	}
	
	public Speaker getSpeaker() {
		return speaker;
	}
	public void setSpeaker(Speaker speaker) {
		System.out.println("setSpeaker() ȣ��");
		this.speaker = speaker;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		System.out.println("setPrice() ȣ��");
		this.price = price;
	}

	@Override
	public void powerOn() {
		System.out.println("SamsungTV -- ���� �ѱ�(����: "+price+"��)");
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
	
}
