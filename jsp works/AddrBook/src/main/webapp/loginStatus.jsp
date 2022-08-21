<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
	String sessionEmail = (String)session.getAttribute("sessionID");
//	if(){
//		
//	}
	if(sessionEmail==null){
%>
<p><a href="./loginForm.jsp">[로그인]</a></p>
<%
	}else{
%>
<h2><%= sessionEmail %>로 로그인</h2>
<p><a href="./logout.jsp">[로그아웃]</a></p>
<%
	}
%>