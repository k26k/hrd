<%@page import="com.dao.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String productId = request.getParameter("id");
	
	ProductDAO dao = new ProductDAO();
	
	dao.delete(productId);
%>
<script type="text/javascript">
	location.href="/wm2/editProducts.jsp?edit=delete";
</script>