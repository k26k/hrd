package com.cloud.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.cloud.domain.MemberVO;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication auth) throws IOException, ServletException {
		
		log.warn("loginSuccess");
		
		MemberVO memberVO = ((CustomUser) auth.getPrincipal()).getMemberVO();
		
		List<String> roleNames = new ArrayList<>();
		
		auth.getAuthorities().forEach(authority -> {
			roleNames.add(authority.getAuthority());
		});
		
		log.warn("ROLE NAMES: "+roleNames);
		log.warn("USERNAME: "+memberVO.getUsername());
		log.warn("PASSWORD: "+memberVO.getUserpw());
		
		
		
		if(roleNames.contains("ROLE_ADMIN")) {
			response.sendRedirect("/admin");
			return;
		}
		if(roleNames.contains("ROLE_MEMBER")) {
			response.sendRedirect("/member");
			return;
		}
		if(roleNames.contains("ROLE_USER")) {
			response.sendRedirect("/all");
			return;
		}
			
		response.sendRedirect("/");
	}

}
