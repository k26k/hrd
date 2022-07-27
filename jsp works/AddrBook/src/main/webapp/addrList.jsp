<%@page import="java.util.ArrayList"%>
<%@page import="com.dao.AddrBook"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
    request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="addrDAO" class="com.dao.AddrBookDAO" scope="application" />
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=0.5">
    
<title>주소록 목록</title>
<link rel="stylesheet" type="text/css" href="./resources/addr.css">
</head>
<body>
	<div id="container" >
		<h2>주소록 목록</h2>
		<hr>
		<%@ include file="./loginStatus.jsp" %>
		<table id="tbl_list" >
			<tr>
				<th>이름</th>
				<th>보기</th>
			</tr>
<%
	ArrayList<AddrBook> addrList = addrDAO.getAllList();
	//for(int i=0; i<addrList.size(); i++){
	for(AddrBook addrBook:addrList){
		int num = addrBook.getNum();
%>
			<tr>
				<td><%= addrBook.getUsername() %></td>
				<td>
					<a href="addrView.jsp?num=<%= num %>">
						<button type="button">보기</button>
					</a>
				</td>
		
			</tr>
<%
	}
%>
		</table>
		<p><a href="addrForm.jsp">[주소록 등록]</a></p>
	</div>
</body>
</html>