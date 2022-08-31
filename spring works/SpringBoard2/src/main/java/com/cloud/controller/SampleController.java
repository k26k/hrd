package com.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.cloud.service.MemberService;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class SampleController {

	@GetMapping("/all")
	public String doAll() {
		log.info("all");
		return "/sample/all";
	}
	
	@GetMapping("/member")
	public String doMember() {
		log.info("member");
		return "/sample/member";
	}
	
	@GetMapping("/admin")
	public String doAdmin() {
		log.info("admin");
		return "/sample/admin";
	}
	
}
