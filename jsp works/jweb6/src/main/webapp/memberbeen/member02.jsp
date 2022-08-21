<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="member" class="com.bean.Member"/>
<jsp:setProperty property="userid" name="member"/>
<jsp:setProperty property="userpw" name="member"/>
<jsp:setProperty property="username" name="member"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소록 등록</title>
<link rel="stylesheet" type="text/css" href="./css/member.css">
</head>
<body>
	<div id="container">
		<h2>회원 정보</h2>
		<hr>
		<table>
			<tr>
				<td>아이디</td>
				<td>패스워드</td>
				<td>이름</td>
			</tr>
			<tr>
				<td><%= member.getUserid() %></td>
				<td><%= member.getUserpw() %></td>
				<td><%= member.getUsername() %></td>
			</tr>
		</table>
	</div>
</body>
</html>