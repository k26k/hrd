package com.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.boot.domain.Member;
import com.boot.service.MemberService;

@SessionAttributes("member")
@Controller
public class LoginController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("/login")
	public String viewLogin() {
		return "login";
	}
	
	@PostMapping("/login")
	public String loginProcess(String id, String password, Model model) {
		System.out.println("id: "+id+" ,  password: "+password);
		Member member = memberService.selectMemberById(id);
		if(member != null && member.getPassword().equals(password)) {
			model.addAttribute("member", member);
			return "redirect:";
		}
		
		return "redirect:customerror?error=1";
	}
	
	@GetMapping("/logout")
	public String logoutProcess(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "redirect:";
	}
}
