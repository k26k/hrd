<%@page import="com.dao.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="/exptionNoProductId.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>

<% 
	ProductDAO dao = new ProductDAO(); 
	request.setCharacterEncoding("utf-8");
%>
<fmt:setLocale value="${param.language}"/>
<fmt:setBundle basename="com.bundle.message"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<title>상품 등록</title>
<script type="text/javascript">
	function checkAddProduct(){
		let productIdV = productId.value;
		let pNameV = pName.value;
		let descriptionV = description.value;
		let manufacturerV = manufacturer.value;
		let categoryV = category.value;
		let condition = document.getElementsByName("condition");
		let productImageV = productImage.value;
		
		let regExPId = /^[p][0-9]{4,12}$/;
		let regExPName = /^[a-zA-Z가-힣0-9\s]{2,30}$/;
		let regExDesc = /^[a-zA-Z가-힣0-9!@#$%^&*?/\s]{10,400}$/;
		
		if(!regExPId.test(productIdV)){
			alert("상품 코드는 P숫자(4~12)");
			return;
		}
		if(!regExPName.test(pNameV)){
			alert("상품명은 한글 영어 숫자만 사용해서 2~30자리");
			return;
		}
		if(unitPrice.value < 1){
			alert("가격은 1이상이어야 합니다.");
			return;
		}
		if(!regExDesc.test(descriptionV)){
			alert("상품 설명은 10 ~ 400자리");
			return;
		}
		if(!regExPName.test(manufacturerV)){
			alert("제조사는 한글 영어 숫자만 사용해서 2~30자리");
			return;
		}
		if(!regExPName.test(categoryV)){
			alert("카테고리는 한글 영어 숫자만 사용해서 2~30자리");
			return;
		}
		if(unitsInStock.value < 1){
			alert("재고는 1이상이어야 합니다.");
			return;
		}
		let radioV = false;
		for(let i=0; i<condition.length; i++){
			if(condition[i].checked){
				radioV = true;
				break;
			}
		}
		if(!radioV){
			alert("제품 상태는 하나 이상 체크해야 합니다");
			return;
		}
		if(!productImage.value){
			alert("상품 사진은 하나 이상 첨부해야 합니다");
			return;
		}
		
		newProduct.submit();
	}
	
	
</script>
</head>
<body>
	<%@ include file="/menu.jsp" %>
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3"><fmt:message key="title"/></h1>
		</div>
	</div>
	<div class="container">
		<div class="text-right">
			<a href="?language=ko">Korea</a> | <a href="?language=en">English</a>
		</div>
		<div class="text-right">
			<a href="/wm2/logout.jsp">로그아웃</a>
		</div>
		<form name="newProduct" action="/wm2/processAddProduct.jsp" class="form-horizontal" method="post" enctype="multipart/form-data">
			<div class="form-group row">
				<label class="col-sm-2" for="productId"><fmt:message key="productId"/></label>
				<div class="col-sm-3">
					<input type="text" id="productId" name="productId" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2" for="pName"><fmt:message key="pName"/></label>
				<div class="col-sm-3">
					<input type="text" id=pName name="pName" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2" for="unitPrice"><fmt:message key="unitPrice"/></label>
				<div class="col-sm-3">
					<input type="text" id="unitPrice" name="unitPrice" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2" for="description"><fmt:message key="description"/></label>
				<div class="col-sm-3">
					<input type="text" id="description" name="description" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2" for="manufacturer"><fmt:message key="manufacturer"/></label>
				<div class="col-sm-3">
					<input type="text" id="manufacturer" name="manufacturer" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2" for="category"><fmt:message key="category"/></label>
				<div class="col-sm-3">
					<input type="text" id="category" name="category" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2" for="unitsInStock"><fmt:message key="unitsInStock"/></label>
				<div class="col-sm-3">
					<input type="text" id="unitsInStock" name="unitsInStock" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2"><fmt:message key="condition"/></label>
				<div class="col-sm-6">
					<input type="radio" name="condition" value="New"><label class="col-sm-3"><fmt:message key="condition_New"/></label>
					<input type="radio" name="condition" value="Old"><label class="col-sm-3"><fmt:message key="condition_Old"/></label>
					<input type="radio" name="condition" value="Refurbished"><label class="col-sm-3"><fmt:message key="condition_Refurbished"/></label>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2" for="productImage"><fmt:message key="productImage"/></label>
				<div class="col-sm-3">
					<input type="file" id="productImage" name="productImage" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="button" class="btn btn-primary" value="<fmt:message key="buttonAdd"/>" onclick="checkAddProduct()">
					<input type="reset" class="btn btn-secondary" value="<fmt:message key="buttonReset"/>">
				</div>
			</div>
		</form>
	</div>
	<%@ include file="/footer.jsp" %>
</body>

</html>