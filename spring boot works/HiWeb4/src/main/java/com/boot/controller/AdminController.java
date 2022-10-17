package com.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.dto.PageRequestDto;
import com.boot.service.MemberService;

@RequestMapping("/admin/*")
@Controller
public class AdminController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("/getMemberList")
	public String getMemberList(PageRequestDto pageRequestDto, Model model) {
		model.addAttribute("memberPage", memberService.getMemberPage(pageRequestDto));
		model.addAttribute("search", false);
		return "admin/memberList";
	}
	
	@GetMapping("/searchMemberList")
	public String searchMemberList(@ModelAttribute("pageRequest") PageRequestDto pageRequestDto, Model model) {
		System.out.println("searchMemberList pageRequest: "+pageRequestDto.toString());
		model.addAttribute("memberPage", memberService.searchMemberPage(pageRequestDto));
		model.addAttribute("search", true);
		return "admin/memberList";
	}
	
	@GetMapping("/getMemberAdmin")
	public String getMemberAdmin(String userId, Model model) {
		model.addAttribute("member", memberService.getMember(userId));
		return "admin/memberViewAdmin";
	}
	
}
