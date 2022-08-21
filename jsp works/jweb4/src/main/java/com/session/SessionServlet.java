package com.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sess1")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(10);
		
		out.println("세션 아이디: "+session.getId()+"<br>");
		out.println("세션 생성 시간: "+new Date(session.getCreationTime())+"<br>");
		out.println("세션 접근 시간: "+new Date(session.getLastAccessedTime())+"<br>");
		out.println("세션 유효 시간: "+session.getMaxInactiveInterval()+"초<br>");
		
		if(session.isNew()) {
			out.println("새거");
		}else {
			out.println("헌거");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
