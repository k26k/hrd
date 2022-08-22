package com.spring.polymorphism;

public class TVUser {

	public static void main(String[] args) {
		
		TV tv = new LGTV();
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumDown();
		tv.powerOn();
		
	}
	
}
