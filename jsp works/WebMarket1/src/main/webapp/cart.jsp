<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<%@ page import="com.vo.Product" %>
<jsp:useBean id="product" class="com.vo.Product"/>
<% String cartId = session.getId(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<title>cart</title>
</head>
<body>
	<%@ include file="/menu.jsp" %>
	<div class="jumbotron">
		<div class="container">
			<h1>장바구니</h1>
		</div>
	</div>
	<div class="container">
	<c:choose>
	<c:when test="${empty sessionScope.cartList}">
		<div class="container">
			<h3>장바구니가 비어있습니다.</h3>
			<p><a href="./products.jsp" class="btn btn-secondary">상품 보러가기</a></p>
		</div>
	</c:when>
	<c:otherwise>	
	<div class="row">
		<div class="col-md-10">
		<c:forEach var="product" items="${sessionScope.cartList}">
			<%-- <p> <c:out value="${ product.productId }"/> , <c:out value="${ product.quality }"/> </p> --%>
			<div class="row col-md-12">
				<div class="col-md-3">
					<a href='/wm1/product.jsp?id=<c:out value="${ product.productId }"/>'>
						<img src="/wm1/upload/images/<c:out value="${ product.filename }"/>" style="width: 100%;">
					</a>
				</div>
				<div class="col-md-7">
					<h3><c:out value="${ product.pName }"/></h3>
					<c:choose>
					<c:when test="${empty product.productId }">
						<p>설명 없음</p>
					</c:when>
					<c:otherwise>
						<%-- <p><c:out value="${ product.description }"/></p> --%>
						<%-- <p><%= product.getDescription().replace("//", "<br>") %></p> --%>
					</c:otherwise>
					</c:choose>
					<div class="row col-md-12 ">
						<p class="col-md-4"><c:out value="${ product.unitPrice }"/>원</p>
						<p class="col-md-4">선택 수량: <c:out value="${ product.quality }"/>개</p>
						<p class="col-md-4">총합: <c:out value="${ product.unitPrice * product.quality }"/>원</p>
					</div>
				</div>
				<div class="col-md-2">
					<a href='./removeCart.jsp?id=<c:out value="${ product.productId }"/>' class="btn btn-warning">삭제</a>
				</div>
			</div>
		</c:forEach>
		</div>
		<div class="col-md-2 ">
			<a href='/wm1/shippingInfo.jsp?cartId=<%= cartId %>' class="btn btn-info col-xs-4 col-md-12 my-1" >결제 하기</a>
			<a href='/wm1/deleteCart.jsp' class="btn btn-warning my-1">전체 삭제</a>
			<a href="/wm1/products.jsp" class="btn btn-secondary my-1">상품 보러가기</a>
		</div>
	</div>
	</c:otherwise>
	</c:choose>
	</div>
	<%@ include file="/footer.jsp" %>
</body>

</html>