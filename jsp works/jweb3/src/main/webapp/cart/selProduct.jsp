<%@page import="javax.websocket.SendResult"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String username = (String)request.getParameter("username");
	
	if(username==null){
		response.sendRedirect("loginForm.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<title>상품선택</title>
<link rel="stylesheet" type="text/css" href="css/cart.css">
</head>
<body>
	<div id="container">
		<h2>상품선택</h2>
		<hr>
		<p><%= username %>님이 로그인 한 상태입니다.</p>
		<hr>
		<form action="productAdd.jsp" method="post">
			<p>
				<select id="product" name="product">
					<option>사과</option>
					<option>귤</option>
					<option>토마토</option>
					<option>키위</option>
				</select>
				<input type="submit" value="추가">
			</p>
		</form>
		<p>
			<input type="button" value="계산하기" onclick="location.href='checkOut.jsp'">
		</p>
	</div>
</body>
</html>