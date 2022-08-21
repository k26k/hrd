<%@ page import="bean.Calculator" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="container">
		<h2>계산 결과</h2>
		<hr>
		<%
			Calculator calc = new Calculator(); 
			calc.setNum1(Integer.parseInt(request.getParameter("num1")));
			calc.setNum2(Integer.parseInt(request.getParameter("num2")));
			calc.setOp(request.getParameter("op"));
			calc.calculator();
		%>
		<p>계산 결과: <%= calc.getResult() %></p>
	</div>
</body>
</html>