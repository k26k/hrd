<%@page import="com.vo.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	request.setCharacterEncoding("utf-8");
	
	String shipping_cartId = "";
	String shipping_shippingDate = "";

	Cookie[] cookies = request.getCookies();
	
	for(Cookie c:cookies){
		if(c.getName().equals("Shipping_cartId")){
			shipping_cartId = URLDecoder.decode(c.getValue(),"utf-8");
		}
		if(c.getName().equals("Shipping_shippingDate")){
			shipping_shippingDate = URLDecoder.decode(c.getValue(),"utf-8");
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<title>주문 완료</title>
</head>
<body>
	<%@ include file="/menu.jsp" %>
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">주문 완료</h1>
		</div>
	</div>
	<div class="container">
		<h2 class="alert alert-danger">주문해 주셔서 감사합니다.</h2>
		<p>주문은 <%= shipping_shippingDate %>에 배송될 예정입니다</p>
		<p>주문번호: <%= shipping_cartId %></p>
	</div>
	<div class="container">
		<p><a href="/wm2/products.jsp" class="btn btn-secondary">상품 목록</a></p>
	</div>
	<%@ include file="/footer.jsp" %>
</body>
</html>
<%
	session.invalidate();

	cookies = request.getCookies();

	for(Cookie c:cookies){
		if(c.getName().equals("Shipping_cartId")){
			c.setMaxAge(0);
		}
		if(c.getName().equals("Shipping_name")){
			c.setMaxAge(0);
		}
		if(c.getName().equals("Shipping_shippingDate")){
			c.setMaxAge(0);
		}
		if(c.getName().equals("Shipping_country")){
			c.setMaxAge(0);
		}
		if(c.getName().equals("Shipping_zipCode")){
			c.setMaxAge(0);
		}
		if(c.getName().equals("Shipping_addressName")){
			c.setMaxAge(0);
		}
		response.addCookie(c);
	}
%>