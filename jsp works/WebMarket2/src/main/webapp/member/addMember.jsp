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
		let nameV = document.getElementById("name").value;
		let genderV = null;
		for(let i=0; i<gender.length; i++){
			if(gender[i].checked){
				genderV = gender[i].value;
			}
		}
		let birthV = birth1.value+"-"+birth2.value+"-"+birth3.value;
		let mailV = mail1.value+"@"+mail2.value;
		let phoneV = phone.value;
		let addressV = address.value;
		
		let regExId = /^[0-9a-zA-Z]{4,10}$/;
		let regExName = /^[a-zA-Z가-힣0-9]{2,10}$/;
		let regExBirth = /^[0-9]{4}-[0-9]{1,2}-[0-9]{1,2}$/
		let regExMail = /^[a-zA-Z0-9]{1,20}@[a-zA-Z0-9.]+[.]{1}[a-zA-Z]{2,3}$/
		let regExPhone1 = /^[0-9]{9,12}$/
		let regExPhone2 = /^[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}$/
		
		console.log(mailV);
		console.log();
		
		if(!regExId.test(idV)){
			alert("아이디는 영문 숫자 4~10자리");
			return false;
		}
		if(!regExId.test(passwordV)){
			alert("비밀번호는 영문 숫자 4~10자리");
			return false;
		}
		if(!regExName.test(nameV)){
			alert("이름은 영문 숫자 한글 2~10자리");
			return false;
		}
		if(genderV!=="남" &&  genderV!=="녀"){
			alert("성별을 선택해 주세요");
			return false;
		}
		if(!regExBirth.test(birthV)){
			alert("생일이 잘못되었습니다");
			return false;
		}
		if(!regExMail.test(mailV)){
			alert("메일이 잘못되었습니다");
			return false;
		}
		if(!regExPhone1.test(phoneV) && !regExPhone2.test(phoneV)){
			alert("전화번호가 잘못되었습니다");
			return false;
		}
		if(!addressV){
			alert("주소를 입력해주세요");
			return false;
		}
		
		return true;
		//newMember.submit();
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
					<input type="radio" id="gender" name="gender" value="남"><label class="col-sm-3">남자</label>
					<input type="radio" id="gender" name="gender" value="녀"><label class="col-sm-3">여자</label>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2" for="birth">생일</label>
				<div class="col-sm-5 row">
					<div class="col-sm-4">
						<select id="birth1" name="birth1" class="form-control">
						<c:forEach var="i" begin="0" end="150">
							<option value="${ 2022-i }"><c:out value="${ 2022-i }년"/></option>
						</c:forEach>
						</select>
					</div>
					<div class="col-sm-4">
						<select id="birth2" name="birth2" class="form-control">
						<c:forEach var="i" begin="1" end="12">
							<option value="${ i }"><c:out value="${ i }월"/></option>
						</c:forEach>
						</select>
					</div>
					<div class="col-sm-4">
						<select id="birth3" name="birth3" class="form-control">
						<c:forEach var="i" begin="1" end="31">
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
						<input type="text" id="mail1" name="mail1" class="form-control">
					</div>
					<div>@</div>
					<div class="col-sm-5">
						<input type="text" id="mail2" name="mail2" class="form-control">
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
				<label class="col-sm-2" for="address">주소</label>
				<div class="col-sm-3">
					<input type="text" id="address" name="address" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="submit" class="btn btn-primary" value="가입">
					<input type="button" class="btn btn-primary" value="정규식 테스트" onclick="checkAddMember()">
					<input type="reset" class="btn btn-secondary" value="취소">
				</div>
			</div>
		</form>
	</div>
	<%@ include file="/footer.jsp" %>
</body>

</html>