<%@ page import="bean.MemberBean2" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="member" class="bean.M"/>
	
	<p>아이디: <jsp:getProperty property="id" name="member"/> </p>
	<p>이름: <jsp:getProperty property="name" name="member"/> </p>
</body>
</html>