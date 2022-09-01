package com.cloud.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cloud.domain.MemberAuthVO;
import com.cloud.domain.MemberVO;
import com.cloud.service.MemberAuthService;
import com.cloud.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@AllArgsConstructor
@Log4j
@Controller
public class MemberController {

	private MemberService memberService;
	private MemberAuthService memberAuthService;
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/addMember")
	public String addMember() {
		return "/member/addMemberForm";
	}
	
	@PostMapping("/addMemberProcess")
	public String addMemberProcess(MemberVO memberVO) {
		String memberVOPwE = passwordEncoder.encode(memberVO.getUserpw());
		memberVO.setUserpw(memberVOPwE);
		MemberAuthVO memberAuthVO = new MemberAuthVO();
		memberAuthVO.setUserid(memberVO.getUserid());
		memberAuthVO.setAuth("ROLE_USER");
		memberService.addMember(memberVO);
		memberAuthService.addMemberAuth(memberAuthVO);
		return "redirect:/customLogin";
	}
	
	@GetMapping("/showMember")
	public String showMember() {
		return "/member/showMember";
	}
	
	@PostMapping("/updateMemberProcess")
	public String updateMemberProcess(Authentication auth) {
		
		return "redirect:/customLogin";
	}
	

	
}
