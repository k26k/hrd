package com.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Chapter01Application {

	public static void main(String[] args) {
//		SpringApplication.run(Chapter01Application.class, args);
//		Spring Boot App으로 실행
		
		SpringApplication application = new SpringApplication(Chapter01Application.class);
		
//		application.setWebApplicationType(WebApplicationType.NONE);
//		java 애플리케이션으로 실행
		
		application.setWebApplicationType(WebApplicationType.SERVLET);
//		Spring Boot App으로 실행
		
		application.run(args);
	}

}
