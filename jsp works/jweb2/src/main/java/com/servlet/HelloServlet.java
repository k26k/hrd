package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		
		response.setContentType("text/html; charset=utf-8;");
		
		PrintWriter out = response.getWriter();
		
		int cnt=1;
		String para = request.getParameter("cnt");
		if(para != null) {cnt=Integer.parseInt(para);}
		
		for(int i=1; i<=cnt; i++) {
			out.println(i+". 안녕 Servlet<br>");
		}
		
		out.close();
		
	}

}
