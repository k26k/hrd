package com.boot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CommonController {

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@ResponseBody
	@RequestMapping("/hink0x07pp/**")
	public String check(HttpServletRequest http) {
		System.out.println("hink0x07pp **");
		System.out.println("ip: "+http.getRemoteAddr());
		return "x";
	}
	
}
