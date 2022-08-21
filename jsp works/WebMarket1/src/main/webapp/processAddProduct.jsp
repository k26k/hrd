<%@page import="java.io.File"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.check.Check"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="com.vo.Product"%>
<%@page import="com.dao.ProductRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	
	String realFolder = "C:\\dev\\hrd\\jsp works\\WebMarket1\\src\\main\\webapp\\upload\\images";
			
	MultipartRequest multi = null;
	
	try{
		multi = new MultipartRequest(request, realFolder, 5*1024*1024, "utf-8", new DefaultFileRenamePolicy());
	}catch(Exception e){
		System.out.println("multi error");
		return;
	}
	
	ProductRepository dao = ProductRepository.getInstance();
	
	//Check.check(response.getWriter(), multi, 0);
	
	String productId = multi.getParameter("productId");	
	String pName = multi.getParameter("pName");
	String unitPrice = multi.getParameter("unitPrice");
	String description = multi.getParameter("description");
	String manufacturer = multi.getParameter("manufacturer");
	String category = multi.getParameter("category");
	String unitsInStock = multi.getParameter("unitsInStock");
	String condition = multi.getParameter("condition");
	File productImage = multi.getFile("productImage");
	
	if(productId==null || productId.equals("")){
		productId="none";
	}
	if(pName==null || pName.equals("")){
		pName="none";
	}
	if(unitPrice==null || unitPrice.equals("")){
		unitPrice="-1";
	}
	if(description==null || description.equals("")){
		description="none";
	}
	if(manufacturer==null || manufacturer.equals("")){
		manufacturer="none";
	}
	if(category==null || category.equals("")){
		category="none";
	}
	if(unitsInStock==null || unitsInStock.equals("")){
		unitsInStock="-1";
	}
	if(condition==null || condition.equals("")){
		condition="none";
	}
	String filename = productImage.getName();
	//if(filename==null || filename.equals("")){
	//	filename="default.png";
	//}
	
	
	//String resourcesImages = "C:/dev/hrd/jsp works/WebMarket1/src/main/webapp/resources/images";
	
	Product product = new Product();
	product.setProductId(productId);
	product.setpName(pName);
	product.setUnitPrice(Integer.valueOf(unitPrice));
	product.setDescription(description);
	product.setmanufacturer(manufacturer);
	product.setCategory(category);
	product.setUnitsInStock(Long.valueOf(unitsInStock));
	product.setCondition(condition);
	product.setFilename(filename);
	
	dao.addProduct(product);
%>
<p>성공</p>
<script type="text/javascript">
	location.href="/wm1/products.jsp";
</script>