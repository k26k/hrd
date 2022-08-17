package com.filter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LogFileFilter implements Filter{
	PrintWriter writer = null;
	static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd hh:mm:ss.SSS");
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String filename = filterConfig.getInitParameter("filename");
		if(filename == null) {
			throw new ServletException("로그 파일의 이름을 찾을 수 없습니다.");
		}
		try {
			writer = new PrintWriter(new FileWriter(filename, true), true);
		}catch(IOException e) {
			throw new ServletException("로그 파일을 열 수 없습니다.");
		}
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		writer.println("클라이언트 IP: "+request.getRemoteAddr());
		writer.println("접근한 URL 경로: "+getURLPath(request));
		long start = System.currentTimeMillis();
		chain.doFilter(request, response);
		long end = System.currentTimeMillis();
		writer.println("요청 처리 시작 시간: "+getCurruntTime(start));
		writer.println("요청 처리 종료 시간: "+getCurruntTime(end));
		writer.println("요청 처리 소요 시간: "+(end-start)+"ms");
		writer.println("============================================");
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
