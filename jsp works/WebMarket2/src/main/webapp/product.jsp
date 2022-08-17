<%@page import="com.dao.ProductDAO"%>
<%@page import="com.vo.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="/exptionNoProductId.jsp" %>
<%
	String id = request.getParameter("id"); 
	ProductDAO dao = new ProductDAO();
	Product product = dao.getProduct(id);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title><%= product.getpName() %> 상세 페이지</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script type="text/javascript">
	function addToCart() {
		if(confirm("장바구니 추가?")){
			document.addForm.submit();
		}
	}
</script>
</head>
<body>
	<%@ include file="/menu.jsp" %>
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">상품 정보</h1>
		</div>
	</div>
	<div class="container">
		<div class="row" align="center">
			<div class="col-md-5">
				<img src="/wm2/upload/images/<%= product.getProductImage() %>" style="width: 100%;">
			</div>
			<div class="col-md-6">
				<h3><%= product.getpName() %></h3>
				<p><%= product.getDescription().replace("//", "<br>") %></p>
				<p><b>상품 코드</b>: <span class="badge badge-danger"><%= product.getProductId() %></span></p>
				<p><b>제조사</b>: <%= product.getManufacturer() %></p>
				<p><b>분류</b>: <%= product.getCategory() %></p>
				<p><b>재고 수</b>: <%= product.getUnitsInStock() %></p>
				<h4><%= product.getUnitPrice() %>원</h4>
				<p>
					<form name="addForm" action="/wm2/addCart.jsp?id=<%= product.getProductId() %>" method="post">
						<a href="#" class="btn btn-info" onclick="addToCart()">상품 주문 &raquo;</a>
						<a href="/wm2/cart.jsp" class="btn btn-warning">장바구니 &raquo;</a>
						<a href="/wm2/products.jsp" class="btn btn-secondary">상품 목록 &raquo;</a>
					</form>
			</div>
		</div>
	</div>
	<%@ include file="/footer.jsp" %>
</body>
</html>