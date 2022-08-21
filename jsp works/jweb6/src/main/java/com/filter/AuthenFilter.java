package com.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AuthenFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//초기 설정
		System.out.println("AuthenFilter 초기화");
	}
	
	@Override
	public void destroy() {
		System.out.println("AuthenFilter 해제");
	}



	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("AuthenFilter 실행");
		// 1. 한글 인코딩 요청 - 필터로 등록
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		
		// 2. 입력값이 없을 경우 필터 처리
		if(name == null || name.equals("")) {
//			out.println("name = null");
//			return;
			name = "null";
			request.getParameterMap();
		}
		
		// 필터 실행
		chain.doFilter(request, response);
	}

}
