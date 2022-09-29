package com.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boot.service.MemberService;

@RequestMapping("/ajax/*")
@Controller
public class AjaxContoller {

	@Autowired
	private MemberService memberService;
	
	
	@ResponseBody
	@GetMapping(value="/usernameCheck", produces="application/text; charset=UTF-8")
	public String usernameCheck(String name) {
		System.out.println("usernameCheck name: "+name);
		String result = null;
		if(memberService.checkId(name)) {
			result = "{\"result\":true}";
		}else {
			result = "{\"result\":false}";
		}
		return result;
	}
	
}
