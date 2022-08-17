<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% 
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<title>회원가입</title>
<script type="text/javascript">
	function checkAddMember(){
		let idV = id.value;
		let passwordV = password.value;
		let nameV = description.value;
		let genderV = manufacturer.value;
		let birthV = birth1.value+"-"+birth2.value+"-"+birth3.value;
		let mailV = mail1.value+"@"+mail2.value;
		let phoneV = phone.value;
		let addressV = address.value;
		
		let regExId = /^[p][0-9]{4,12}$/;
		let regExPassword = /^[a-zA-Z가-힣0-9\s]{2,30}$/;
		let regExDesc = /^[a-zA-Z가-힣0-9!@#$%^&*?/\s]{10,400}$/;
		let regExBirth = /^[]-[]-[]*$/
		let regExMail = /^[a-zA-Z][a-zA-Z0-9]{1,20}@[a-zA-Z0-9.].[a-zA-Z]{2,3}$/
		
		if(!regExPId.test(productIdV)){
			alert("상품 코드는 P숫자(4~12)");
			return true;
		}
		if(!regExPName.test(pNameV)){
			alert("상품명은 한글 영어 숫자만 사용해서 2~30자리");
			return true;
		}
		if(unitPrice.value < 1){
			alert("가격은 1이상이어야 합니다.");
			return true;
		}
		if(!regExDesc.test(descriptionV)){
			alert("상품 설명은 10 ~ 400자리");
			return true;
		}
		if(!regExPName.test(manufacturerV)){
			alert("제조사는 한글 영어 숫자만 사용해서 2~30자리");
			return true;
		}
		if(!regExPName.test(categoryV)){
			alert("카테고리는 한글 영어 숫자만 사용해서 2~30자리");
			return true;
		}
		if(unitsInStock.value < 1){
			alert("재고는 1이상이어야 합니다.");
			return true;
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
			return true;
		}
		if(!productImage.value){
			alert("상품 사진은 하나 이상 첨부해야 합니다");
			return true;
		} 
		
		newMember.submit();
	}
	
	
</script>
</head>
<body>
	<%@ include file="/menu.jsp" %>
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">회원가입</h1>
		</div>
	</div>
	<div class="container">
		<form name="newMember" action="/wm2/member/processAddMember.jsp" class="form-horizontal" method="post" onsubmit="return checkAddMember()">
			<div class="form-group row">
				<label class="col-sm-2" for="id">아이디</label>
				<div class="col-sm-3">
					<input type="text" id="id" name="id" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2" for="password">비밀번호</label>
				<div class="col-sm-3">
					<input type="text" id="password" name="password" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2" for="name">이름</label>
				<div class="col-sm-3">
					<input type="text" id="name" name="name" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">성별</label>
				<div class="col-sm-3">
					<input type="radio" name="gender" value="남"><label class="col-sm-3">남자</label>
					<input type="radio" name="gender" value="녀"><label class="col-sm-3">여자</label>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2" for="birth">생일</label>
				<div class="col-sm-5 row">
					<div class="col-sm-4">
						<select id="birth" name="birth1" class="form-control">
						<c:forEach var="i" begin="0" end="150">
							<option value="${ 2022-i }"><c:out value="${ 2022-i }년"/></option>
						</c:forEach>
						</select>
					</div>
					<div class="col-sm-4">
						<select id="birth" name="birth2" class="form-control">
						<c:forEach var="i" begin="1" end="12">
							<option value="${ i }"><c:out value="${ i }월"/></option>
						</c:forEach>
						</select>
					</div>
					<div class="col-sm-4">
						<select id="birth" name="birth3" class="form-control">
						<c:forEach var="i" begin="1" end="12">
							<option value="${ i }"><c:out value="${ i }일"/></option>
						</c:forEach>
						</select>
					</div>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2" for="mail">메일</label>
				<div class="col-sm-4 row">
					<div class="col-sm-5">
						<input type="text" id="mail" name="mail1" class="form-control">
					</div>
					@
					<div class="col-sm-6">
						<input type="text" id="mail" name="mail2" class="form-control">
					</div>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2" for="phone">전화번호</label>
				<div class="col-sm-3">
					<input type="text" id="phone" name="phone" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="submit" class="btn btn-primary" value="가입">
					<input type="reset" class="btn btn-secondary" value="취소">
				</div>
			</div>
		</form>
	</div>
	<%@ include file="/footer.jsp" %>
</body>

</html>