package com.cloud.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cloud.repository.UserDAO;
import com.cloud.repository.UserVO;
import com.cloud.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public String loginForm() {
		return "/login/loginForm";
	}
	
	@RequestMapping(value="/loginProcess", method = RequestMethod.POST)
	public String loginProcess(String id, String passwd, HttpSession session, Model model) {
		boolean check = userService.checkUser(id, passwd);
		if(check) {
			session.setAttribute("sessionId", id);
			model.addAttribute("title", "로그인");
			model.addAttribute("text", "로그인 성공");
			model.addAttribute("link", "/");
			model.addAttribute("button", "처음 화면으로");
		}else {
			return "redirect:/login?error=1";
		}
		return "/result";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session, Model model) {
		session.invalidate();
		model.addAttribute("title", "로그아웃");
		model.addAttribute("text", "로그아웃 성공");
		model.addAttribute("link", "/");
		model.addAttribute("button", "처음 화면으로");
		return "/result";
	}
	
	@RequestMapping("/register")
	public String register() {
		return "/login/registerForm";
	}
	
	@RequestMapping(value="/registerProcess", method = RequestMethod.POST)
	public String registerProcess(UserVO user, HttpSession session, Model model) {
		int result = userService.addUser(user);
		if(result == 1) {
			model.addAttribute("title", "회원가입");
			model.addAttribute("text", "회원가입 성공");
			model.addAttribute("link", "/login");
			model.addAttribute("button", "로그인 화면으로");
		}else {
			return "redirect:/register?error=1";
		}
		return "/result";
	}
	
}
