<%@page import="com.vo.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dao.ProductRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="/exptionNoProductId.jsp" %>
<%
	String id = request.getParameter("id");
	if(id == null || id.equals("")){
		response.sendRedirect("/wm1/cart.jsp");
		return;
	}
	
	ArrayList<Product> productList = (ArrayList<Product>)session.getAttribute("cartList");
	for(int i=0; i<productList.size(); i++){
		if(productList.get(i).getProductId().equals(id)){
			productList.remove(i);
			break;
		}
	}
	
	response.sendRedirect("/wm1/cart.jsp");
%>