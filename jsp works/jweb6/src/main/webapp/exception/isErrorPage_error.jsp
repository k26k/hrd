<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% if(exception == null){ %>
	<p>오류 없음</p>
<% }else{ %>
	<p>오류 발생</p>
	<p>예외 유형: <%= exception.getClass().getName() %></p>
	<p>오류 메시지: <%= exception.getMessage() %></p>
<% } %>
</body>
</html>