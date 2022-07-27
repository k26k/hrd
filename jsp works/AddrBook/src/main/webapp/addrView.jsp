<%@page import="java.util.ArrayList"%>
<%@page import="com.dao.AddrBook"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="addrDAO" class="com.dao.AddrBookDAO" scope="application" />

<%
	if(session.getAttribute("sessionID")==null){
%>
<script>
	alert("로그인 해야합니다.");
	location.href="./loginForm.jsp";
</script>
<%		
		return;
	}

	int num = -1;
	if(request.getParameter("num")==null||request.getParameter("num")==""){
%>
	<script>
		location.href="./addrList.jsp";
	</script>
<%			
	}
	
	num = Integer.parseInt(request.getParameter("num"));
	if(session.getAttribute("num")==null){
		
	}
%>
<%-- 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=0.5">
<title>주소록 상세 조회</title>
<link rel="stylesheet" type="text/css" href="./resources/addr.css">
</head>
<body>
	<div id="container" >
		<h2>주소록 상세 조회</h2>
		<hr>
		<table id="tbl">
			<tr>
				<td> <label for="username" >이름</label> </td>
				<td> <input type="text" id="username" name="username" maxlength=20 size=20 value="<%= addrBook.getUsername() %>" readonly > </td>
			</tr>
			<tr>
				<td> <label for="tel" >전화번호</label> </td>
				<td> <input type="text" id="tel" name="tel" maxlength=20 size=20 value="<%= addrBook.getTel() %>" readonly > </td>
			</tr>
			<tr>
				<td> <label for="email" >이메일</label> </td>
				<td> <input type="text" id="email" name="email" maxlength=20 size=20 value="<%= addrBook.getEmail() %>" readonly > </td>
			</tr>
			<tr>
				<td> 성별 </td>
				<td>
					<% if(addrBook.getGender().equals("남자")){ %>
					<input type="radio" id="male" name="gender" value="남자" checked>
					<label for="male" >남</label>
					<input type="radio" id="female" name="gender" value="여자" disabled>
					<label for="female" >여</label>
					<% }else{ %>
					<input type="radio" id="male" name="gender" value="남자" disabled>
					<label for="male" >남</label>
					<input type="radio" id="female" name="gender" value="여자" checked>
					<label for="female" >여</label>
					<% } %>
				</td>
			<tr>
				<td colspan="2">
					<a href="./addrUpdate.jsp?num=<%= num %>">
						<input type="button" value="수정">	
					</a>
					<a href="./addrList.jsp?num=<%= num %>">
						<input type="button" onclick="return confirm('삭?제');" value="삭제">	
					</a>
					<a href="./addrList.jsp">
						<input type="button" value="목록">	
					</a>
				</td>
			</tr>
			
		</table>
		<p>
		</p>
	</div>
</body>		
</html> --%>