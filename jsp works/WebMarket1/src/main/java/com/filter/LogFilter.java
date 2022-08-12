package com.filter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LogFilter implements Filter{
	
	static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd hh:mm:ss.SSS");
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("클라이언트 IP: "+request.getRemoteAddr());
		System.out.println("접근한 URL 경로: "+getURLPath(request));
		long start = System.currentTimeMillis();
		chain.doFilter(request, response);
		long end = System.currentTimeMillis();
		System.out.println("요청 처리 시작 시간: "+getCurruntTime(start));
		System.out.println("요청 처리 종료 시간: "+getCurruntTime(end));
		System.out.println("요청 처리 소요 시간: "+(end-start)+"ms");
		System.out.println("============================================");
	}
	
	private static String getCurruntTime(long time) {
		return simpleDateFormat.format(time);
	}
	
	private static String getURLPath(ServletRequest request) {
		if(!(request instanceof HttpServletRequest)) {
			return "request is not HttpServletRequest";
		}
		HttpServletRequest req = (HttpServletRequest)request;
		String currentPath = req.getRequestURI();
		String queryString = req.getQueryString();
		queryString = queryString==null?"":"?"+queryString;
		return currentPath+queryString;
	}
	
}
