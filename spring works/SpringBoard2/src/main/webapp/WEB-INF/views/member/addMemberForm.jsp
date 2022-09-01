<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" type="text/css" href="/resources/css/style.css">
<script type="text/javascript">
	function checkMember() {
		if(!userid.value){
			alert("userid x");
			userid.focus();
			return false;
		}
		if(!userpw.value){
			alert("userpw x");
			userpw.focus();
			return false;
		}
		if(!userpw2.value){
			alert("userpw2 x");
			userpw2.focus();
			return false;
		}
		if(userpw.value!=userpw2.value){
			alert("userpw != userpw2");
			userpw2.focus();
			return false;
		}
		if(!username.value){
			alert("username x");
			username.focus();
			return false;
		}
		
		return true;
	}
</script>
</head>
<body>
	<div class="container">
		<h1>회원가입</h1>
		<jsp:include page="/WEB-INF/views/menu.jsp"/>
		<hr>
		<c:if test="${ param.error == 1 }">
			<h4 class="error">회원가입에 실패했습니다 다시 확인해 주세요</h4>
		</c:if>
		<div class="max600">
			<div class="left">
				<a href="/"><input type="button" value="홈"></a>
			</div>
			<form action="/addMemberProcess" method="post" onsubmit="return (checkMember()==true)">
				<table>
					<tr>
						<td class="gray"><label for="userid">아이디</label></td>
						<td><input type="text" class="max" id="userid" name="userid" ></td>
					</tr>
					<tr>
						<td class="gray"><label for="userpw">비밀번호</label></td>
						<td><input type="text" class="max" id="userpw" name="userpw" ></td>
					</tr>
					<tr>
						<td class="gray"><label for="userpw2">비밀번호 확인</label></td>
						<td><input type="text" class="max" id="userpw2" name="userpw2" ></td>
					</tr>
					<tr>
						<td class="gray"><label for="username">이름</label></td>
						<td><input type="text" class="max" id="username" name="username" ></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="가입">
							<input type="reset" value="취소">
							<a href="/customLogin"><input type="button" value="로그인"></a>
						</td>
					</tr>
				</table>
				<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
			</form>
		</div>
	</div>
</body>
</html>