<%@page import="com.vo.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dao.ProductRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
	if(id == null || id.equals("")){
		response.sendRedirect("/wm1/products.jsp");
		return;
	}
	
	ProductRepository dao = ProductRepository.getInstance();
	
	ArrayList<Product> productList = dao.getAllProducts();
	Product product = null;
	for(Product pd:productList){
		if(pd.getProductId().equals(id)){
			product = pd;
			break;
		}
	}
	productList = (ArrayList<Product>)session.getAttribute("cartList");
	if(productList==null){
		session.setAttribute("cartList", new ArrayList<>());
		productList = (ArrayList<Product>)session.getAttribute("cartList");
	}
	
	int count = 0;
	for(Product pd:productList){
		if(pd.getProductId().equals(id)){
			count = pd.getQuality()+1;
			pd.setQuality(count);
		}
	}
	if(count == 0){
		product.setQuality(1);
		productList.add(product);
	}
	
	//session.setAttribute("cartList", productList);
	response.sendRedirect("/wm1/product.jsp?id="+id);
%>