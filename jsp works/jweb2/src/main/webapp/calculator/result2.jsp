<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/calc.css">
</head>
<body>
	<jsp:useBean id="calc" class="bean.Calculator"></jsp:useBean>
	<jsp:setProperty property="num1" name="calc"/>
	<jsp:setProperty property="num2" name="calc"/>
	<jsp:setProperty property="op" name="calc"/>
	
	<div id="container">
		<h2>계산 결과</h2>
		<hr>
		<%
			calc.calculator();
		%>
		<p>계산 결과: <%= calc.getResult() %></p>
	</div>
</body>
</html>