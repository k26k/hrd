package com.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.domain.Member;
import com.boot.service.MemberService;

import lombok.extern.slf4j.Slf4j;

//로그인 컨트롤러 역할 수행
@Slf4j
@RequestMapping("/system/*")
@Controller
public class SecurityController {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private MemberService memberService;
	
//	/system/login.html로 매칭해줌
	@GetMapping("/login")
	public void login() {}
	
//	/system/logout.html로 매칭해줌
	@GetMapping("/logout")
	public void logout() {}
	
	@GetMapping("/signUp")
	public void signUpForm() {}
	
	@PostMapping("/signUp")
	public String signUpProcess(Member member) {
		member.setPassword(passwordEncoder.encode(member.getPassword()));
		System.out.println("POST signUp member: "+member);
		memberService.addMember(member);
		return "redirect:/";
	}
	
	@GetMapping("/accessDenied")
	public void showAccessDenied(Authentication auth) {
		log.info("accessDenied 접근 권한 없음");
		if(auth != null) {
			log.info("Authentication: "+auth.getPrincipal());
		}else {
			log.info("Authentication: null");
		}
	}
	
	
}
