<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userid = request.getParameter("userid");
	String userpw = request.getParameter("userpw");
	
	if(userid.equals("qwer") && userpw.equals("1234")){
		Cookie cookieID = new Cookie("userid", userid);
		cookieID.setMaxAge(30);
		out.println(cookieID.getMaxAge());
		Cookie cookiePW = new Cookie("userpw", userpw);
		cookiePW.setMaxAge(60);
		out.println(cookiePW.getMaxAge());
		
		response.addCookie(cookieID);
		response.addCookie(cookiePW);
		
		out.println("id, pw 쿠키 생성 성공");
	}else{
		out.println("id, pw 쿠키 생성 실패");
	}
	
%>