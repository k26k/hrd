<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<title>배송 정보</title>
</head>
<body>
	<%@ include file="/menu.jsp" %>
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">배송 정보</h1>
		</div>
	</div>
	<div class="container">
		<form action="/wm2/processShippingInfo.jsp?cartId=<%= request.getParameter("cartId") %>" class="form-horizontal" method="post" >
			<div class="form-group row">
				<label class="col-sm-2" for="name">성명</label>
				<div class="col-sm-3">
					<input type="text" id="name" name="name" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2" for="shippingDate">배송일</label>
				<div class="col-sm-3">
					<input type="text" id="shippingDate" name="shippingDate" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2" for="country">국가명</label>
				<div class="col-sm-3">
					<input type="text" id="country" name="country" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2" for="zipCode">우편번호</label>
				<div class="col-sm-3">
					<input type="text" id="zipCode" name="zipCode" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2" for="addressName">주소</label>
				<div class="col-sm-3">
					<input type="text" id="addressName" name="addressName" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-offset-2 col-sm-10">
					<a href="/wm2/cart.jsp" class="btn btn-secondary" role="button">이전</a>
					<input type="submit" class="btn btn-primary" value="등록">
					<a href='/wm2/checkOutCancelled.jsp' class="btn btn-secondary" role="button">이전</a>
				</div>
			</div>
		</form>
	</div>
	<%@ include file="/footer.jsp" %>
</body>

</html>