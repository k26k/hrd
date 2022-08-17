<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page errorPage="/member/loginMember.jsp?error=error" %>
<jsp:useBean id="member" class="com.vo.Member" scope="page"/>
<%
	request.setCharacterEncoding("utf-8");
	
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	member.setId(id);
	member.setPassword(password);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<sql:setDataSource var="dataSource"
	driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/jspdb?useUnicode=true&serverTimezone=Asia/Seoul"
	user="root"
	password="12345"
	/>
	<sql:query dataSource="${ dataSource }" var="resultSet">
		select * from member where id=? and password=?;
		<sql:param value="${ member.id }"/>
		<sql:param value="${ member.password }"/>
	</sql:query>
	<c:forEach var="row" items="${ resultSet.rows }" >
		<% session.setAttribute("sessionId", id); %>
		<c:redirect url="/member/resultMember.jsp?msg=loginSuccess"/>
	</c:forEach>
	<c:redirect url="/member/loginMember.jsp?error=loginNone"/>
</body>
</html>