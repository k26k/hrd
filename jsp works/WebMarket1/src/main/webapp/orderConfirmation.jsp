<%@page import="com.vo.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	request.setCharacterEncoding("utf-8");
	
	String cartId = session.getId();
	String shipping_cartId = "";
	String shipping_name = "";
	String shipping_shippingDate = "";
	String shipping_country = "";
	String shipping_zipCode = "";
	String shipping_addressName = "";

	Cookie[] cookies = request.getCookies();
	
	for(Cookie c:cookies){
		if(c.getName().equals("Shipping_cartId")){
			shipping_cartId = URLDecoder.decode(c.getValue(),"utf-8");
		}
		if(c.getName().equals("Shipping_name")){
			shipping_name = URLDecoder.decode(c.getValue(),"utf-8");
		}
		if(c.getName().equals("Shipping_shippingDate")){
			shipping_shippingDate = URLDecoder.decode(c.getValue(),"utf-8");
		}
		if(c.getName().equals("Shipping_country")){
			shipping_country = URLDecoder.decode(c.getValue(),"utf-8");
		}
		if(c.getName().equals("Shipping_zipCode")){
			shipping_zipCode = URLDecoder.decode(c.getValue(),"utf-8");
		}
		if(c.getName().equals("Shipping_addressName")){
			shipping_addressName = URLDecoder.decode(c.getValue(),"utf-8");
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
<title>주문 정보</title>
</head>
<body>
	<%@ include file="/menu.jsp" %>
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">주문 정보</h1>
		</div>
	</div>
	<div class="container col-8 alert alert-info">
		<div class="text-center">
			<h1>영수증</h1>
		</div>
		<div class="row justify-content-between">
			<div class="col-4" align="left">
				<strong>배송 주소<br> 성명: <%= shipping_name %></strong><br>
				우편번호: <%= shipping_zipCode %><br>
				주소: <%= shipping_addressName %>(<%= shipping_country %>)
			</div>
			<div class="col-4" align="right">
				<p> <em>배송일 <%= shipping_shippingDate %></em> </p>
			</div>
		</div>
		<div>
			<table class="table table-hover">
				<tr>
					<th class="text-center">상품</th>
					<th class="text-center">수량</th>
					<th class="text-center">가격</th>
					<th class="text-center">소계</th>
				</tr>
				<% 
					int sum=0;
					ArrayList<Product> cartList = (ArrayList<Product>)session.getAttribute("cartList");
					if(cartList == null){
						cartList = new ArrayList<>();
					}
					
					for(Product p:cartList){
						int total = p.getUnitPrice() * p.getQuality();
						sum+=total;
				%>
				<tr>
					<td class="text-center"><em><%= p.getpName() %></em></td>
					<td class="text-center"><%= p.getQuality() %></td>
					<td class="text-center"><%= p.getUnitPrice() %></td>
					<td class="text-center"><%= total %></td>
				</tr>
				<%
					}
				%>
				<tr>
					<td></td>
					<td></td>
					<td class="text-center">총액: </td>
					<td class="text-center"><%= sum %></td>
				</tr>
			</table>
			<a href="/wm1/shippingInfo.jsp?cartId=<%= shipping_cartId %>" class="btn btn-secondary">이전</a>
			<a href="/wm1/thanksCustomer.jsp" class="btn btn-success">주문 완료</a>
			<a href="/wm1/checkOutCancelled.jsp" class="btn btn-secondary">취소</a>
		</div>
	</div>
	<%@ include file="/footer.jsp" %>
</body>

</html>