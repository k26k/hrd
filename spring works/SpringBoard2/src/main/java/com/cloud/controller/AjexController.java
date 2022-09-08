package com.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloud.service.MemberService;

import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/ajax/*")
@Controller
public class AjexController {

	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/calc")
	public String calc() {
		return "/ajax/calc";
	}
	
	@RequestMapping("/sayhello")
	public void returnHello() {
		
	}
	
	@ResponseBody
	@RequestMapping(value="/doPlus", produces="application/text; charset=UTF-8")
	public String doPlus(int num1, int num2) {
		log.info(num1);
		log.info(num2);
		String result = "{\"result\":"+(num1+num2)+",\"result_msg\":\"AJAX 계산 성공\"}";
		log.info(result);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/usernameCheck", produces="application/text; charset=UTF-8")
	public String usernameCheck(String name) {
		String result = null;
		if(name==null) {
			log.info("name: null");
		}else {
			log.info("name: notNull "+name);
		}
		if(memberService.checkMemberUserid(name)!=null) {
			result = "{\"result\":true}";
		}else {
			result = "{\"result\":false}";
		}
		log.info(result);
		return result;
	}
}