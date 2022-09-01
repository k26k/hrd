package com.cloud.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
	
	@PreAuthorize("hasAnyRole('ROLE_MEMBER','ROLE_ADMIN')")
	@GetMapping("/annoMember")
	public String doMember2() {
		log.info("member");
		return "/sample/member";
	}
	
	@Secured({"ROLE_ADMIN"})
	@GetMapping("/annoAdmin")
	public String doAdmin2() {
		log.info("admin");
		return "/sample/admin";
	}
}
