package com.spring.polymorphism;

public class LGTV implements TV {

	@Override
	public void powerOn() {
		System.out.println("LGTV-- ���� �ѱ�");
	}

	@Override
	public void powerOff() {
		System.out.println("LGTV-- ���� ����");
	}

	@Override
	public void volumeUp() {
		System.out.println("LGTV-- ���� �ø���");
	}

	@Override
	public void volumDown() {
		System.out.println("LGTV-- ���� ������");
	}
	
}
