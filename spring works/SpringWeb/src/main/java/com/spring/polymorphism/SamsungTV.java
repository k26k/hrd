package com.spring.polymorphism;

public class SamsungTV implements TV {

	@Override
	public void powerOn() {
		System.out.println("SamsungTV-- ���� �ѱ�");
	}

	@Override
	public void powerOff() {
		System.out.println("SamsungTV-- ���� ����");
	}

	@Override
	public void volumeUp() {
		System.out.println("SamsungTV-- ���� �ø���");
	}

	@Override
	public void volumDown() {
		System.out.println("SamsungTV-- ���� ������");
	}
	
}
