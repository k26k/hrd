<%@page import="java.util.ArrayList"%>
<%@ page import="com.repository.Member" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<jsp:useBean id="MemberDAO" class="com.repository.MemberDAO" scope="application" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
<link rel="stylesheet" type="text/css" href="./resources/css/common.css">
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
			<c:forEach var="member" items="${MemberDAO.getAllList()}">
				<tr>
					<td><c:out value="${member.getMemberID()}"/></td>
					<td><c:out value="${member.getPasswd()}"/></td>
					<td><c:out value="${member.getName()}"/></td>
					<td><c:out value="${member.getGender()}"/></td>
					<td><c:out value="${member.getJoinDate()}"/></td>
					<td>
						<form action="./memberDelete.jsp" method="post">
							<input type="hidden" name="deleteID" value="${member.getMemberID()}">
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