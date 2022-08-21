<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="addrDAO" class="com.dao.AddrBookDAO" scope="application" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=0.5">
<title>로그인 처리중</title>
<link rel="stylesheet" type="text/css" href="./resources/addr.css">
</head>
<body>
	<div id="container">
<%
	request.setCharacterEncoding("utf-8");
	String email = request.getParameter("email");
	if(!addrDAO.checkLogin(email)){
%>
		<h2>로그인 실패</h2>
<%
	}else{
		session.setAttribute("sessionID", email);
%>
		<%@ include file="./loginStatus.jsp" %>
<%
	}
%>		
		<hr>
		<p><a href="./addrForm.jsp">[주소록 등록]</a></p>
		<p><a href="addrList.jsp">[목록 보기]</a></p>
	</div>
</body>
</html>