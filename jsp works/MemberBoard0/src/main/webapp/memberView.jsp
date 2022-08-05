<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<jsp:useBean id="member" class="com.repository.Member" />
<jsp:useBean id="memberDAO" class="com.repository.MemberDAO" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<link rel="stylesheet" type="text/css" href="./resources/css/common.css">
</head>
<body>
	<div class="container">
		<jsp:include page="./menu.jsp"/>
		<div class="contents">
			<div class="first_title">
				<h1>회원 가입</h1>
			</div>
			<form action="./updateMember.jsp" method="post" class="member_add_form">
				<table>
					<tr>
						<td>아이디</td>
						<td><input type="text" name="memberID" value="${member.memberID}"></td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type="text" name="passwd" value="<%= member.getPasswd() %>"></td>
					</tr>
					<tr>
						<td>이름</td>
						<td><input type="text" name="name" value="<%= member.getName() %>"></td>
					</tr>
					<tr>
						<td>성별</td>
						<td>
						<% if(member.getGender().equals("남")){ %>
							<label for="male">남</label>
							<input type="radio" id="male" name="gender" value="남" checked>
							<label for="female">녀</label>
							<input type="radio" id="female" name="gender" value="녀">
						<% }else if(member.getGender().equals("녀")){ %>
							<label for="male">남</label>
							<input type="radio" id="male" name="gender" value="남">
							<label for="female">녀</label>
							<input type="radio" id="female" name="gender" value="녀" checked>
						<% } %>
						</td>
					</tr>
					<tr>
						<td>가입일</td>
						<td><input type="text" name="joinDate" value="<%= member.getJoinDate() %>" readonly></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="수정">
							<input type="reset" value="취소">
						</td>
					</tr>
				</table>			
			</form>
		</div>
		<jsp:include page="./footer.jsp"/>
	</div>
</body>
</html>