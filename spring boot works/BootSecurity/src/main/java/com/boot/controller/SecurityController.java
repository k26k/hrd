package com.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class SecurityController {

	@GetMapping("/")
	public String index() {
		log.info("index 요청 입니다.");
		return "index";
	}
	
	@GetMapping("/member")
	public void forMember() {
		log.info("member 요청 입니다.");
	}
	
	@GetMapping("/manager")
	public void forManager() {
		log.info("manager 요청 입니다.");
	}
	
	@GetMapping("/admin")
	public void forAdmin() {
		log.info("admin 요청 입니다.");
	}
	
	@GetMapping("/accessDenied")
	public void accessDenied() {
		log.info("accessDenied 접근 거부.");
	}
	
	@GetMapping("/login")
	public void login() {
		log.info("login 요청 입니다.");
	}
	
	@GetMapping("/loginSuccess")
	public void loginSuccess() {
		log.info("login 성공 입니다.");
	}
	
	@GetMapping("/logout")
	public void logout() {
		log.info("logout 요청 입니다.");
	}
	
	@GetMapping("/logoutSuccess")
	public void logoutSuccess() {
		log.info("logout 성공 입니다.");
	}
}
