<%@page import="com.dao.ProductDAO"%>
<%@page import="java.io.File"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.check.Check"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="com.vo.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	
	String realFolder = "C:\\dev\\hrd\\jsp works\\WebMarket2\\src\\main\\webapp\\upload\\images";
		
	MultipartRequest multi = null;
	
	try{
		multi = new MultipartRequest(request, realFolder, 5*1024*1024, "utf-8", new DefaultFileRenamePolicy());
	}catch(Exception e){
		System.out.println("multi error");
		return;
	}
	
	Check.check(response.getWriter(), multi, 0);
	
	ProductDAO dao = new ProductDAO();
	
	//Check.check(response.getWriter(), multi, 0);
	
	Product product = dao.getProduct(request.getParameter("id"));
	
	String productId = multi.getParameter("productId");	
	String pName = multi.getParameter("pName");
	String unitPrice = multi.getParameter("unitPrice");
	String description = multi.getParameter("description");
	String manufacturer = multi.getParameter("manufacturer");
	String category = multi.getParameter("category");
	String unitsInStock = multi.getParameter("unitsInStock");
	String condition = multi.getParameter("condition");
	File productImage = multi.getFile("productImage");
	String productImageChange = multi.getParameter("productImageChange");
	
	if(productId!=null && !productId.equals("")){
		product.setProductId(productId);
	}
	if(pName!=null && !pName.equals("")){
		product.setpName(pName);
	}
	if(unitPrice!=null && !unitPrice.equals("")){
		product.setUnitPrice(Integer.valueOf(unitPrice));
	}
	if(description!=null && !description.equals("")){
		product.setDescription(description);
	}
	if(manufacturer!=null && !manufacturer.equals("")){
		product.setManufacturer(manufacturer);
	}
	if(category!=null && !category.equals("")){
		product.setCategory(category);
	}
	if(unitsInStock!=null && !unitsInStock.equals("")){
		product.setUnitsInStock(Long.valueOf(unitsInStock));
	}
	if(condition!=null && !condition.equals("")){
		product.setCondition(condition);
	}
	if(productImageChange==null || !productImageChange.equals("on")){
		if(productImage!=null && !productImage.getName().equals("")){
			product.setProductImage(productImage.getName());
		}
	}
	
	dao.update(product);
%>
<p>성공</p>
<script type="text/javascript">
	location.href="/wm2/editProducts.jsp?edit=edit";
</script>