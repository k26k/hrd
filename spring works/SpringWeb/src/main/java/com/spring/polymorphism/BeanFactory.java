package com.spring.polymorphism;

public class BeanFactory {

	public Object getBean(String beanName) {
		if(beanName.equals("samsung")) {
			return new SamsungTV();
		}
		if(beanName.equals("lg")) {
			return new LGTV();
		}
		
		return null;
	}
	
}
