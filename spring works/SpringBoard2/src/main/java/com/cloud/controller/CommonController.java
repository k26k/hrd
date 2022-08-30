package com.cloud.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class CommonController {
	
	@GetMapping("/accessError")
	public String accessError(Authentication auth, Model model) {
		log.info("Access Denied: "+auth);
		model.addAttribute("msg", "Access Denied");
		return "/error/accessError";
	}
	
	@GetMapping("/customLogin")
	public void customLogin(String error, String logout, Model model) {
		log.info("error: "+error);
		log.info("logout: "+logout);
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
	}
	
	@GetMapping("/customLogout")
	public String customLogout() {
		log.info("customLogout");
		return"/customLogout";
	}
}
