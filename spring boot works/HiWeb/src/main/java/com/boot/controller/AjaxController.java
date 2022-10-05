package com.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boot.service.MemberService;

@RequestMapping("/ajax/*")
@Controller
public class AjaxController {

	@Autowired
	private MemberService memberService;
	
	
	@PostMapping("/checkId")
	@ResponseBody
	public String checkId(String id) {
		System.out.println("ajax checkId id: "+id);
		if(memberService.checkId(id)) {
			return "{\"result\":true}";
		}
		
		return "{\"result\":false}";
	}
	
}
