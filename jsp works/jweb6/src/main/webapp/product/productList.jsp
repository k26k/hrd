<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="product" class="com.bean.Product" scope=""/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="container">
		<h2>상품 목록</h2>
		<hr>
		<form action="selProduct.jsp" method="post">
			<select name="select">
				<% for(String item:product.getProductList()){
					out.println("<option>"+item+"</option>");
				}%>
			</select>
			<input type="submit" value="선택">
		</form>
	</div>
</body>
</html>