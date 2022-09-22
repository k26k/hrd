package com.boot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

// 프로퍼티 재정의
@SpringBootTest(properties = {
		"author.name=updated",
		"author.age=127",
		"author.nation=korea"
})
public class PropertiesTest {

	@Autowired
	private Environment environment;
	
	@Test
	public void testMethod() {
		System.out.println("testMethod start ...");
		
		System.out.println("이름: "+environment.getProperty("author.name"));
		System.out.println("나이: "+environment.getProperty("author.age"));
		System.out.println("국적: "+environment.getProperty("author.nation"));

		System.out.println("testMethod end ...");
	}

}
