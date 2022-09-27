package com.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.boot.domain.Member;
import com.boot.service.MemberService;

@SessionAttributes("member")
@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@ModelAttribute
	public Member setMember() {
		return new Member();
	}
	
	@GetMapping("/memberList")
	public String memberList(@RequestParam(defaultValue = "") String search,
							 @RequestParam(defaultValue = "1")int page, 
							 @RequestParam(defaultValue = "10")int size, 
							 Model model) {
		Pageable paging = PageRequest.of(page-1, size, Sort.by(Sort.Direction.ASC, "role"));
		model.addAttribute("memberList", memberService.getMemberListByKeywordAndPage(search, search, paging));
		return "member/memberList";
	}
	
	@GetMapping("/memberView")
	public String memberView() {
		return "member/memberView";
	}
	
	@PostMapping("/updateMember")
	public String updateMember(@ModelAttribute("member") Member memberOrigin, Member memberNew, String oldId, Model model) {
		memberOrigin.setPassword(memberNew.getPassword());
		memberOrigin.setName(memberNew.getName());
		memberService.updateMember(memberOrigin);
		model.addAttribute("member", memberOrigin);
		return "redirect:memberView";
	}
	
	@GetMapping("/signUp")
	public String signUpView() {
		return "member/signUp";
	}
	
	@PostMapping("/signUp")
	public String signUpProcess(Member member) {
		member.setRole("ROLE_USER");
		memberService.insertMember(member);
		return "redirect:login";
	}
	
}
