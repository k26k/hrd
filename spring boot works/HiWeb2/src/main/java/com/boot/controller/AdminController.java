package com.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
	public String getMemberList(@RequestParam(defaultValue = "1") int page, 
								Model model) {
		
		Pageable pageable = PageRequest.of(page-1, 10, Sort.by(Sort.Direction.DESC, "role"));
		model.addAttribute("memberPage", memberService.getMemberPage(pageable));
		model.addAttribute("memberLink", "/admin/getMemberList");
		return "admin/memberList";
	}
	
	@GetMapping("/searchMemberList")
	public String searchMemberList(@RequestParam(defaultValue = "1") int page, 
									@RequestParam(defaultValue = "") Search search, 
									Model model) {
		
		Pageable pageable = PageRequest.of(page-1, 10, Sort.by(Sort.Direction.DESC, "role"));
		model.addAttribute("memberPage", memberService.getMemberPage(pageable));
		return "admin/memberList";
	}
	
}
