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
import com.boot.domain.Role;
import com.boot.dto.MemberDto;
import com.boot.entity.Member;
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
	public String signUpProcess(MemberDto memberDto) {
		memberDto.setRole(Role.ROLE_MEMBER);
		memberDto.setPassword(passwordEncoder.encode(memberDto.getPassword()));
		memberService.insertMember(memberDto);
		return "redirect=/system/signIn";
	}
	
}
