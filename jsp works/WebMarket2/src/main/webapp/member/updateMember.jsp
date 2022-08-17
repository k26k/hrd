<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ page errorPage="/member/loginMember.jsp" %> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql"  prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn" %>
<% 
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="member" class="com.vo.Member"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<title>회원정보</title>
<script type="text/javascript">
	function checkUpdateMember(){
		/* let productIdV = productId.value;
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
		} */
		
		updateMember.submit();
	}
	
	
</script>
</head>
<body>
	<sql:setDataSource var="dataSource"
	driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/jspdb?useUnicode=true&serverTimezone=Asia/Seoul"
	user="root"
	password="12345"
	/>
	<sql:query dataSource="${ dataSource }" var="resultSet">
		select * from member where id=?;
		<sql:param value="${ sessionId }"/>
	</sql:query>
	<c:forEach var="row" items="${ resultSet.rows }">
		${ member.id = row.id }
		${ member.password = row.password }
		${ member.name = row.name }
		${ member.gender = row.gender }
		${ member.birth = row.birth }
		${ member.mail = row.mail }
		${ member.phone = row.phone }
		${ member.address = row.address }
	</c:forEach>
	<%@ include file="/menu.jsp" %>
	<% System.out.println(session.getAttribute("sessionId")); %>
	<% System.out.println(member.getId()); %>
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">회원정보</h1>
		</div>
	</div>
	<div class="container">
		<form name="updateMember" action="/wm2/member/processUpdateMember.jsp" class="form-horizontal" method="post">
			<div class="form-group row">
				<label class="col-sm-2" for="id">아이디</label>
				<div class="col-sm-3">
					<input type="text" id="id" name="id" class="form-control" value="${ member.id }">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2" for="password">비밀번호</label>
				<div class="col-sm-3">
					<input type="text" id="password" name="password" class="form-control" value="${ member.password }">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2" for="name">이름</label>
				<div class="col-sm-3">
					<input type="text" id="name" name="name" class="form-control" value="${ member.name }">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">성별</label>
				<div class="col-sm-3">
					<input type="radio" name="gender" value="남" <c:if test='${ member.gender eq "남" }'>checked</c:if> ><label class="col-sm-3">남자</label>
					<input type="radio" name="gender" value="녀" <c:if test='${ member.gender eq "녀" }'>checked</c:if>><label class="col-sm-3">여자</label>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2" for="birth">생일</label>
				<c:set var="births" value='${ fn:split(member.birth,"-") }'/>
				<div class="col-sm-5 row">
					<div class="col-sm-4">
						<select id="birth" name="birth1" class="form-control">
						<c:forEach var="i" begin="0" end="150">
							<option value="${ 2022-i }" <c:if test="${ 2022-i eq births[0] }">selected</c:if>><c:out value="${ 2022-i }년"/></option>
						</c:forEach>
						</select>
					</div>
					<div class="col-sm-4">
						<select id="birth" name="birth2" class="form-control">
						<c:forEach var="i" begin="1" end="12">
							<option value="${ i }" <c:if test="${ i eq births[1] }">selected</c:if>><c:out value="${ i }월"/></option>
						</c:forEach>
						</select>
					</div>
					<div class="col-sm-4">
						<select id="birth" name="birth3" class="form-control">
						<c:forEach var="i" begin="1" end="12">
							<option value="${ i }" <c:if test="${ i eq births[2] }">selected</c:if>><c:out value="${ i }일"/></option>
						</c:forEach>
						</select>
					</div>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2" for="mail">메일</label>
				<c:set var="mails" value='${ fn:split(member.mail,"@") }'/>
				<div class="col-sm-4 row">
					<div class="col-sm-5">
						<input type="text" id="mail1" name="mail1" class="form-control" value="${ mails[0] }">
					</div>
					@
					<div class="col-sm-6">
						<input type="text" id="mail2" name="mail2" class="form-control" value="${ mails[1] }">
					</div>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2" for="phone">전화번호</label>
				<div class="col-sm-3">
					<input type="text" id="phone" name="phone" class="form-control" value="${ member.phone }">
				</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="button" class="btn btn-primary" value="가입" onclick="checkUpdateMember()">
					<input type="reset" class="btn btn-secondary" value="취소">
				</div>
			</div>
		</form>
	</div>
	<%@ include file="/footer.jsp" %>
</body>

</html>