<%@page import="dao.AddrBook"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소록 조회</title>
<link rel="stylesheet" type="text/css" href="css/addrbook.css">
</head>
<jsp:useBean id="addrDAO" class="dao.AddrBookDAO" scope="application" />
<body>
	<div id="container" >
		<h2>주소록 조회</h2>
		<hr>
		<p>
			<a href="addrForm.jsp">주소 추가</a>
		</p>
		<table id="tbl_list" >
			<tr>
				<td>이름</td>
				<td>전화번호</td>
				<td>이메일</td>
				<td>성별</td>
				<td>보기</td>
				<td>삭제</td>
			</tr>
			<% 
				ArrayList<AddrBook> addrList = addrDAO.getAllList();
				for(int i=0; i<addrList.size(); i++){
					AddrBook addrBook = addrList.get(i);
			%>
			<tr>
				<td><%= addrBook.getUsername() %></td>
				<td><%= addrBook.getTel() %></td>
				<td><%= addrBook.getEmail() %></td>
				<td><%= addrBook.getGender() %></td>
				<td>
					<a href="addrView.jsp?userIndex=<%= i %>">
						<button type="button">보기</button>
					</a>
				</td>
				<td>
					<a href="addrDelete.jsp?userIndex=<%= i %>">
						<button type="button">삭제</button>
					</a>
				</td>
			</tr>
			<%
				}
			%>
		</table>
	</div>
</body>
</html>