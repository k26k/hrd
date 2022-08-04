<%@page import="java.util.ArrayList"%>
<%@ page import="com.repository.Member" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<% ArrayList<Member> memberList = (ArrayList<Member>)request.getAttribute("memberList");  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
<link rel="stylesheet" type="text/css" href="/resources/css/common.css">
</head>
<body>
	<div class="container">
		<jsp:include page="./menu.jsp"/>
		<div class="contents">
			<table class="member_list">
				<tr>
					<th>id</th>
					<th>pw</th>
					<th>name</th>
					<th>gender</th>
					<th>date</th>
					<th>delete</th>
				</tr>
			<c:forEach var="member" items="${memberList}">
				<tr>
					<td><c:out value="${member.memberID}"/></td>
					<td><c:out value="${member.passwd}"/></td>
					<td><c:out value="${member.name}"/></td>
					<td><c:out value="${member.gender}"/></td>
					<td><c:out value="${member.joinDate}"/></td>
					<td>
						<form action="./memberDelete.jsp" method="post">
							<input type="hidden" name="deleteID" value="${member.memberID}">
							<input type="submit" value="delete">
						</form>
					</td>
				</tr>
			</c:forEach>
			</table>
		</div>
		<jsp:include page="./footer.jsp"/>
	</div>
</body>
</html>