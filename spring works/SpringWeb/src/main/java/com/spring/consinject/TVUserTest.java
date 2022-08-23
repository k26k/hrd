package com.spring.consinject;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUserTest {

	public static void main(String[] args) {
		
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicatonContext.xml");
		TV tv1 = (TV) factory.getBean("tv2");
		
		tv1.powerOn();
		tv1.volumeUp();
		tv1.volumDown();
		tv1.powerOn();
		
		TV tv2 = (TV) factory.getBean("tv3");
		
		tv2.powerOn();
		tv2.volumeUp();
		tv2.volumDown();
		tv2.powerOn();
		
	}
	
}
