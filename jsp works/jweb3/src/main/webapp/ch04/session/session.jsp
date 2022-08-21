<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 발급된 세션 가져오기
	String id = (String)session.getAttribute("userID");
	String pw = (String)session.getAttribute("userPW");
	out.print("id: "+id+"<br>pw: "+pw);
%>