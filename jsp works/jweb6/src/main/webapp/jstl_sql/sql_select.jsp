<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl sql 태그 예제</title>
<style type="text/css">
table, td, th {border-collapse: collapse; border: 1px solid #ccc;}
th, td {padding: 8px 15px;}
th{background-color: #eee;}
</style>
</head>
<body>
	<sql:setDataSource var="dataSource"
	driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/jspdb?useUnicode=true&serverTimezone=Asia/Seoul"
	user="root"
	password="12345"
	/>
	
	<sql:query var="resultSet" dataSource="${ dataSource }">
		SELECT * FROM engineer
	</sql:query>
	<p><input type="button" onclick="location.href='./sql_insert.jsp'" value="입력하기"></p>
	<table>
		<tr>
		<c:forEach var="columnName" items="${ resultSet.columnNames }">
			<th><c:out value="${ columnName }"/></th>
		</c:forEach>
		</tr>
		<c:forEach var="row" items="${ resultSet.rowsByIndex }">
		<tr>
			<c:forEach var="column" items="${ row }">
			<td>
				<c:if test="${ !empty column }">
				<c:out value="${ column }"/>
				</c:if>
				<c:if test="${ !empty column }">
				&nbsp;
				</c:if>
			</td>
			</c:forEach>
		</tr>
		</c:forEach>
	</table>
	
</body>
</html>