package com.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.domain.Role;
import com.boot.dto.MemberDto;
import com.boot.service.MemberService;

@RequestMapping("/member/*")
@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("viewSelf")
	public String viewSelfForm(Authentication authentication, Model model) {
		MemberDto memberDto =  memberService.getMember(authentication.getName());
		model.addAttribute("member", memberDto);
		if(memberDto.getRole() == Role.ROLE_ADMIN) {
			return "admin/memberViewAdmin";
		}
		return "member/memberView";
	}
	
	
}
