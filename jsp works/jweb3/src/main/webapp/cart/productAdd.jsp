<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	if((String)session.getAttribute("username")==null){
		response.sendRedirect("loginForm.jsp");
	}

	ArrayList<String> productList = (ArrayList)session.getAttribute("productList");

	if(productList == null){
		productList = new ArrayList<>();
		session.setAttribute("productList", productList);
	}
	
	String product = request.getParameter("product");
	if(product==null){
	%>
		<script type="text/javascript">
			alert("상품이 선택되지 않았습니다.");
		</script>
	<%	
	}else{
		productList.add(product);
		session.setAttribute("productList", productList);
	%>
		<script type="text/javascript">
			alert("<%= product %>가 추가되었습니다.");
		</script>
	<%
	}
%>
<script>
	history.go(-1);
</script>