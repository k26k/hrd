<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String username = (String)session.getAttribute("username");
	if(username==null){
		response.sendRedirect("loginForm.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계산</title>
<link rel="stylesheet" type="text/css" href="css/cart.css">
</head>
<body>
	<div id="container">
		<h2>계산</h2>
		<p>선택한 상품 목록</p>
		<hr>
		<p>
			<%
				ArrayList<String> productList = (ArrayList)session.getAttribute("productList");
				
				if(productList!=null){
					for(String product:productList){
						if(product == null){
							out.println("=null=<br>");	
						}else if(product.trim().equals("")){
							out.println("[]<br>");	
						}else{
							out.println(product+"<br>");
						}
					}
				}else{
					out.println("선택된 상품이 없습니다");
				}
			%>
		</p>
	</div>
</body>
</html>