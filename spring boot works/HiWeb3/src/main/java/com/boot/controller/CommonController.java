package com.boot.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CommonController {

	@GetMapping("/")
	public String index(Model model) {
		List<String> imgList = new ArrayList<String>();
		imgList.add("/images/lion.jpg");
		imgList.add("/images/lion.jpg");
		imgList.add("/images/lion.jpg");
		imgList.add("/images/lion.jpg");
		imgList.add("/images/lion.jpg");
		model.addAttribute("imgList", imgList);
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
