package com.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boot.config.SecurityUser;
import com.boot.domain.Board;
import com.boot.domain.Member;
import com.boot.service.BoardService;
import com.boot.service.MemberService;

@RequestMapping("/ajax/*")
@Controller
public class AjaxController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private BoardService boardService;
	
	@ResponseBody
	@GetMapping("/signInSuccess")
	public String signInSuccess() {
		return "{\"result\": true}";
	}
	
	@ResponseBody
	@GetMapping("/signInFail")
	public String signInFail() {
		return "{\"result\": false}";
	}
	
	@ResponseBody
	@PostMapping("/checkId")
	public String checkId(String userId) {
		System.out.println("checkId userId: "+userId);
		if(memberService.checkId(userId)) {
			return "{\"result\": true}";
		}else {
			return "{\"result\": false}";
		}
	}
	
	@ResponseBody
	@PostMapping("/signUp")
	public String checkId(Member member) {
		System.out.println("signUp member: "+member.toString());
		if(memberService.insertMember(member)) {
			return "{\"result\": true}";
		}else {
			return "{\"result\": false}";
		}
	}
	
	@ResponseBody
	@PostMapping("/updateMemberSelf")
	public String updateMemberSelf(Authentication authentication, Member member) {
		String userId = authentication.getName();
		System.out.println("updateMemberSelf userId: "+userId);
		System.out.println("updateMemberSelf member: "+member.toString());
		if(memberService.updateMember(userId, member)) {
			
			return "{\"result\": true}";
		}
			
		return "{\"result\": false}";
	}
	
	@ResponseBody
	@PostMapping("/writeBoard")
	public String writeBoard(Authentication authentication, Board board) {
		board.setMember(((SecurityUser) authentication.getPrincipal()).getMember());
		System.out.println("writeBoard board: "+board.toString());
		if(boardService.insertBoard(board)) {
			
			return "{\"result\": true}";
		}
		
		return "{\"result\": false}";
	}
	
}
