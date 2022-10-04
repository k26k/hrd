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

import com.boot.service.MemberService;

@RequestMapping("/admin/*")
@Controller
public class AdminController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/memberList")
	public void showMemberList(	@RequestParam(name = "search", defaultValue = "") String search,
								@RequestParam(name = "page", defaultValue = "1") int page,
								Model model) {
		Pageable pageable = PageRequest.of(page-1, 10, Sort.Direction.DESC, "role");
		model.addAttribute("memberList", memberService.getMemberPage("", pageable));
	}
	
}
