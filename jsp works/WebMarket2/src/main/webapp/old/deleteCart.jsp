<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.removeAttribute("cartList");
	response.sendRedirect("/wm2/cart.jsp");
%>