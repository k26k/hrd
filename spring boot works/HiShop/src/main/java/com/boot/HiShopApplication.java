package com.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class HiShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(HiShopApplication.class, args);
	}

}
