package com.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.config.SecurityUser;
import com.boot.domain.Member;
import com.boot.service.MemberService;

@RequestMapping("/member/*")
@Controller
public class MemberController {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/memberView")
	public String showMember(Authentication authentication, Model model) {
		System.out.println("memberView getPrincipal: "+((SecurityUser)authentication.getPrincipal()).getMember());
		Member member = ((SecurityUser)authentication.getPrincipal()).getMember();
		model.addAttribute("member", member);
		return "member/memberView";
	}
	
	@PostMapping("/updateMember")
	public String updateMemberProcess(Authentication authentication, Member member) {
		Member originMember = ((SecurityUser)authentication.getPrincipal()).getMember();
		System.out.println("updateMember getPrincipal: "+originMember);
		if(!originMember.getPassword().equals(member.getPassword())) {
			originMember.setPassword(passwordEncoder.encode(member.getPassword()));
		}
		originMember.setName(member.getName());
		System.out.println("updateMember member: "+originMember);
		memberService.updateMember(originMember);
		return "redirect:/system/logout";
	}
	
	
	
}
