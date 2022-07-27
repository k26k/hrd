<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("userid");
	String pw = request.getParameter("userpw");
	String name = request.getParameter("username");
%>
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
				<td><%= id %></td>
				<td><%= pw %></td>
				<td><%= name %></td>
			</tr>
		</table>
	</div>
</body>
</html>