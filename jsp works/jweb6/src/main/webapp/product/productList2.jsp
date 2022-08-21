<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<jsp:useBean id="product" class="com.bean.Product" />
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
			<c:forEach var="prod" items="${product.getProductList()}">
				<option><c:out value="${prod}"></c:out></option>
			</c:forEach>
			</select>
			<input type="submit" value="선택">
		</form>
	</div>
</body>
</html>