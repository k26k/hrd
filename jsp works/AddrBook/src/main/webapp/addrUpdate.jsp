<%@page import="java.util.ArrayList"%>
<%@page import="com.dao.AddrBook"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="addrDAO" class="com.dao.AddrBookDAO" scope="application" />

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
<% 	
	try{
		int num = Integer.parseInt(request.getParameter("num"));
		AddrBook addrBook = addrDAO.getAddress(num);
		if(addrBook == null){
			out.println("<script>");
			out.println("alert('null error');");
			out.println("location.href='./addrList.jsp';");
			out.println("</script>");
			return;
		}
%>
	<div id="container" >
		<h2>주소록 수정</h2>
		<hr>
		<form action="">
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
		</form>


		<p>
			<a href="addrList.jsp">목록 보기</a>
		</p>
	</div>
<%
	}catch(Exception e){
		//e.printStackTrace();
%>
<script type="text/javascript">
	alert("해당 주소록이 없습니다.");
	location.href="addrList.jsp";
</script>
<%
	}
%>
</body>		
</html>