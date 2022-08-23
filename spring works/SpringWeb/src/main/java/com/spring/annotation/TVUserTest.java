package com.spring.annotation;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUserTest {

	public static void main(String[] args) {
		
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicatonContext.xml");
		TV tv = (TV) factory.getBean("tv5");
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumDown();
		tv.powerOff();
		
	}
	
}
