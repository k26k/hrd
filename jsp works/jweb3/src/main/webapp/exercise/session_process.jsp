<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	if(id.equals("qwer") && pw.equals("1234")) {
		session.setAttribute("userID", id);
		response.sendRedirect("welcome.jsp");
	}else{
		out.println("아이디와 비밀번호가 일치하지 않습니다.<br><br>");
		out.println("<a href='session.jsp'>뒤로가기</a>");
	}
%>