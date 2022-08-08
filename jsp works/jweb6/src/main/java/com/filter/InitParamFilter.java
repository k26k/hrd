package com.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class InitParamFilter implements Filter{
	private FilterConfig filterConfig = null;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// 초기 설정
		System.out.println("AuthenFilter 초기화");
		this.filterConfig = filterConfig;
	}
	
	@Override
	public void destroy() {
		// 종료 설정
		System.out.println("AuthenFilter 해제");
	}



	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		String param1 = filterConfig.getInitParameter("param1");
		String param2 = filterConfig.getInitParameter("param2");
		
		String message = "";
		
		if(id.equals(param1) && pw.equals(param2)) {
			message = "로그인 성공";
		}else {
			message = "로그인 실패";
		}
		
		out.println(message);
		
		chain.doFilter(request, response);
	}

}
