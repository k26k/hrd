<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl sql 태그 예제</title>
</head>
<body>
	<sql:setDataSource var="dataSource"
	driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/jspdb?useUnicode=true&serverTimezone=Asia/Seoul"
	user="root"
	password="12345"
	/>
	
	<sql:update var="resultSet" dataSource="${ dataSource }">
		insert into engineer values(?, ?, ?)
		<sql:param value="${ param.eid }"/>
		<sql:param value="${ param.passwd }"/>
		<sql:param value="${ param.name }"/>
	</sql:update>
	
	<c:import url="./sql_select.jsp"/>
</body>
</html>