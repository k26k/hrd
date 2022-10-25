package com.boot.SecurityConfig;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;
import java.util.function.BiConsumer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.web.context.request.async.WebAsyncManager;

import com.boot.dto.AjaxResultDto;
import com.fasterxml.jackson.databind.ObjectMapper;

import antlr.collections.List;

public class SrcurityLoginSuccessHandler implements AuthenticationSuccessHandler {

	private RequestCache requestCache = new HttpSessionRequestCache();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		System.out.println(authentication.toString());
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		SavedRequest savedRequest = requestCache.getRequest(request, response);
		String url = savedRequest == null ? "/":savedRequest.getRedirectUrl();
		
		response.setContentType("json");
		PrintWriter writer = response.getWriter();
		
		AjaxResultDto ajaxResultDto = AjaxResultDto.builder()
				.result(true)
				.message("로그인 성공!")
				.redirectLink(url)
				.build();
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(ajaxResultDto);
		
		writer.print(jsonStr);
	}

}
