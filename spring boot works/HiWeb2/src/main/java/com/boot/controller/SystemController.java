package com.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.config.SecurityUser;
import com.boot.domain.Member;
import com.boot.domain.Role;
import com.boot.service.MemberService;

@RequestMapping("/s/*")
@Controller
public class SystemController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("signIn")
	public String signInForm() {
		return "system/signIn";
	}
	
	@GetMapping("signUp")
	public String signUpForm() {
		return "system/signUp";
	}
	
	@PostMapping("signUp")
	public String signUpProcess(Member member) {
		member.setRole(Role.ROLE_MEMBER);
		member.setPassword(passwordEncoder.encode(member.getPassword()));
		return "redirect=/system/signIn";
	}
	
}
