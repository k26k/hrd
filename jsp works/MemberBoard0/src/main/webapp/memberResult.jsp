<%@page import="java.util.Enumeration"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home</title>
<link rel="stylesheet" type="text/css" href="./resources/css/common.css">
</head>
<body>
	<div class="container">
		<jsp:include page="./menu.jsp"/>
		<div class="contents">
			<div class="first_title">
				<h1>Welcome to our community</h1>
			</div>
			<div class="first_title" style="background-color: #f66;">
				<h2>${requestScope.text}</h2>
			</div>
		</div>
		<jsp:include page="./footer.jsp"/>
	</div>
</body>
</html>