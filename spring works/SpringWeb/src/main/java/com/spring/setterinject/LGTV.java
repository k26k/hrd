package com.spring.setterinject;

public class LGTV implements TV {

	public LGTV() {
		System.out.println("==> LGTV ��ü ����");
	}
	
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
