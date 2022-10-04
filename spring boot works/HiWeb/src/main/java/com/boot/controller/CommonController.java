package com.boot.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpSession;

import org.springframework.boot.web.servlet.server.Session;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.boot.domain.Role;

@Controller
public class CommonController {
	
	@GetMapping("/")
	public String index(HttpSession session, Model model) {
//		Enumeration<String> AttributeNames = session.getAttributeNames();
//		while(AttributeNames.hasMoreElements()) {
//			String key = AttributeNames.nextElement();
//			System.out.println("key: "+key);
//			System.out.println("attribute:"+session.getAttribute(key));
//		}
		
		return "index";
	}
	
}
