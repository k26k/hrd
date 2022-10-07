package com.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.boot.domain.Search;
import com.boot.service.MemberService;

@RequestMapping("/admin/*")
@Controller
public class AdminController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("/getMemberList")
	public String getMemberList(	@RequestParam(defaultValue = "1") int page, 
								Search search, 
								Model model) {
		
		//model.addAttribute("memberPage", memberService.getMemberPage(null));
		return "admin/memberList";
	}
	
}
