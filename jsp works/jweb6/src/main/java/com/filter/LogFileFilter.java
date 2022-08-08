package com.filter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LogFileFilter implements Filter{
	
	PrintWriter writer;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String fileName = filterConfig.getInitParameter("fileName");
		if(fileName == null) {throw new ServletException("로그 파일의 이름을 찾을 수 없습니다.");}
		try {
			writer = new PrintWriter(new FileWriter(fileName, true), true);
		}catch(IOException e) {
			throw new ServletException("로그 파일을 열 수 없습니다.");
		}
	}
	
	@Override
	public void destroy() {
		if(writer!=null) {
			writer.close();
		}
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		  System.out.println("logging..."); 
		  
		  String clientAddr = request.getRemoteAddr(); 
		  writer.printf("클라이언트 IP 주소: %s %n", clientAddr);
		  
		  String contentType = response.getContentType();
		  writer.printf("문서의 컨텐츠 유형: %s %n", contentType);
		  
		  writer.printf("현재 일시: %s %n", getCurrentTime());
		 
		
		chain.doFilter(request, response);
	}
	
	private Object getCurrentTime() {
		DateFormat formatter = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		return formatter.format(calendar.getTime());
	}
	
}
