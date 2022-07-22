<%@page import="java.util.ArrayList"%>
<%@page import="dao.AddrBook"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소록 상세 조회</title>
<link rel="stylesheet" type="text/css" href="css/addrbook.css">
</head>
<jsp:useBean id="addrDAO" class="dao.AddrBookDAO" scope="application" />
<%-- <body>
	<div id="container" >
		<h2>주소록 상세 조회</h2>
		<hr>
		<% 	
			request.setCharacterEncoding("utf-8");
			String userIndex = request.getParameter("userIndex");
			
			if(userIndex != null && user){	
				ArrayList<addrBook>	addrList = 
				
		%>
		<table id="tbl" >
			<tr>
				<td>이름</td>
				<td><%= addrBook.getUsername() %></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><%= addrBook.getTel() %></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><%= addrBook.getEmail() %></td>
			</tr>
			<tr>
				<td>성별</td>
				<td><%= addrBook.getGender() %></td>
			</tr>
		</table>
		<%
			}else{
				%>
		<script type="text/javascript">
			alert("해당 주소록이 없습니다.");
			location.href="addrForm.jsp";
		</script>
				<%
			}
		%>
		<p>
			<a href="addrList.jsp">목록 보기</a>
		</p>
	</div>
</body>
</html> --%>
<body>
	<div id="container" >
		<h2>주소록 상세 조회</h2>
		<hr>
		<% 	
			AddrBook addrBook = null;
			try{
				int userIndex = Integer.parseInt(request.getParameter("userIndex"));
				addrBook = addrDAO.getAddress(userIndex);			
		%>
		<table id="tbl" >
			<tr>
				<td>이름</td>
				<td><%= addrBook.getUsername() %></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><%= addrBook.getTel() %></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><%= addrBook.getEmail() %></td>
			</tr>
			<tr>
				<td>성별</td>
				<td><%= addrBook.getGender() %></td>
			</tr>
		</table>
		<%
			}catch(Exception e){
				%>
		<script type="text/javascript">
			alert("해당 주소록이 없습니다.");
			location.href="addrForm.jsp";
		</script>
				<%
			}
		%>
		<p>
			<a href="addrList.jsp">목록 보기</a>
		</p>
	</div>
</body>
</html>