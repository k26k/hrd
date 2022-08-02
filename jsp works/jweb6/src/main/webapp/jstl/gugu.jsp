<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>구구단</h2>
	<table>
	<%
		for(int i=1; i<=9; i++){
	%>
		<tr>
		<% 
			for(int j=1; j<=9; j++){
		%>
			<td width="100px"><%= j+" x "+i+" = "+j*i %></td>
		<% 
			}
		%>
		</tr>
	<%
		}
	%>
	</table>
	<hr>
	<table>
		<c:forEach var="i" begin="1" end="9" step="1">
			<tr>
				<c:forEach var="j" begin="1" end="9" step="1">
					<td style="width:100px;">${j} x ${i} = ${i*j}</td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
</body>
</html>