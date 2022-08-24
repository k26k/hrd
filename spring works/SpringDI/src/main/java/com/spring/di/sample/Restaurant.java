package com.spring.di.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@Component
public class Restaurant {
	
	@Autowired
	private Chef chef;
	
	public Restaurant() {
		//System.out.println("==> Restaurant 객체 생성");
	}
}
