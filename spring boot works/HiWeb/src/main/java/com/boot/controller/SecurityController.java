package com.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//로그인 컨트롤러 역할 수행
@Controller
public class SecurityController {

//	/system/login.html로 매칭해줌
	@GetMapping("/system/login")
	public void login() {}
	
}
