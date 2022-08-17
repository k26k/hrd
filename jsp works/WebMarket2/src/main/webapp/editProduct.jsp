<%@page import="com.vo.Product"%>
<%@page import="com.dao.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<title>상품 목록</title>
<% if(request.getParameter("edit") != null && request.getParameter("edit").equals("delete")){ %>
<script type="text/javascript">
	function deleteConfirm(id) {
		if(confirm("해당 상품을 삭제할까요?")){
			location.href="./deleteProduct.jsp?id="+id;
		}
	}
</script>
<% } %>
</head>
<body>
	<%@ include file="/menu.jsp" %>
	<div class="jumbotron">
		<div class="container">
			<h1>상품 목록</h1>
		</div>
	</div>
	<div class="container">
		<div class="row" align="center">
			<% for(Product product:new ProductDAO().getAllList()) { %>
			<div class="col-md-4">
				<img src="/wm2/upload/images/<%= product.getProductImage() %>" style="width: 100%;">
				<h3><%= product.getpName() %></h3>
				<% if(product.getDescription()!=null){ %>
				<p><%= product.getDescription().replace("//", "<br>") %></p>
				<% }else{ %>
				<p>설명 없음</p>
				<% } %>
				<p><%= product.getUnitPrice() %>원</p>
				<p>
				<% if(request.getParameter("edit") != null){if(request.getParameter("edit").equals("update")){ %>
					<a href="./updateProduct.jsp?id=<%= product.getProductId() %>" class="btn btn-success" role="button">수정 &raquo;</a>
				<% }else if(request.getParameter("edit").equals("delete")){ %>
					<a href="#" onclick="deleteConfirm('<%= product.getProductId() %>')" class="btn btn-danger" role="button">삭제 &raquo;</a>
				<% }} %>
				</p>
				
			</div>
			<% } %>
		</div>
	</div>
	<%@ include file="/footer.jsp" %>
</body>

</html>