<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	
	String userid = request.getParameter("userid");
	String userpw = request.getParameter("userpw");
	
	try{
		if(userid.equals("qwer") && userpw.equals("1234")){
			response.sendRedirect("loginSuccess.jsp");
		}else{
			response.sendRedirect("loginFail.jsp");
		}
	}catch(Exception e){
		response.sendRedirect("loginFail.jsp");
	}
	
%>