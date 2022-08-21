package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("servlet/login2")
public class LoginServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("get");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String userid = request.getParameter("userid");
		String userpw = request.getParameter("userpw");
		String phone = request.getParameter("phone");
		
		System.out.println("id: "+userid);
		System.out.println("pw: "+userpw);
		System.out.println("phone: "+phone);
		
		String data = "<html><body>";
		data += "<p>id: "+userid+"</p>";
		data += "<p>pw: "+userpw+"</p>";
		data += "<p>phone: "+phone+"</p>";
		data += "</body></html>";
		
		out.println(data);
	}

}
