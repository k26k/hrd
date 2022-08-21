<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="login" class="bean.LoginBean" scope="request"/>
<jsp:setProperty property="userid" name="login"/>
<jsp:setProperty property="passwd" name="login"/>
<%
	if(login.checkUser()){
		out.println("로그인 성공");
	}
	else{
		out.println("로그인 실패");
	}
%>
<hr>
<p>아이디: <jsp:getProperty property="userid" name="login"/> </p>
<p>비밀번호: <jsp:getProperty property="passwd" name="login"/> </p>