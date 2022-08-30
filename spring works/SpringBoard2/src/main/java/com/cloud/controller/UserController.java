package com.cloud.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cloud.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	//@RequestMapping("/login")
	public String login() {
		return "/login/loginForm";
	}
	
	//@RequestMapping("/logout")
	public String logout(HttpSession session, RedirectAttributes redirectAttributes) {
		session.invalidate();
		redirectAttributes.addFlashAttribute("title", "로그아웃");
		redirectAttributes.addFlashAttribute("text", "로그아웃 성공");
		redirectAttributes.addFlashAttribute("link", "/");
		redirectAttributes.addFlashAttribute("button", "처음 화면으로");
		return "redirect:/result";
	}
	
	@PostMapping("/loginProcess")
	public String loginProcess(String id, String passwd, HttpSession session, RedirectAttributes redirectAttributes) {
		System.out.println("id:"+id+" | passwd:"+passwd);
		if(userService.checkUser(id, passwd)>0) {
			session.setAttribute("sessionId", id);
			redirectAttributes.addFlashAttribute("title", "로그인");
			redirectAttributes.addFlashAttribute("text", "로그인 성공");
			redirectAttributes.addFlashAttribute("link", "/");
			redirectAttributes.addFlashAttribute("button", "처음 화면으로");
			return "redirect:/result";
		}else {
			return "redirect:/login?error=1";
		}
	}
	
	@GetMapping("/result")
	public String result() {
		return "/result";
	}
	
	
}
