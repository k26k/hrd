<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	request.setCharacterEncoding("utf-8");
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
	<sql:update dataSource="${ dataSource }" var="resultSet">
		delete from member where id=?;
		<sql:param value="${ sessionId }"/>
	</sql:update>
	<c:choose>
	<c:when test="${ resultSet >= 1 }">
		<c:import url="/logout.jsp"/>
		<script type="text/javascript">
			location.href="/wm2/member/resultMember.jsp?msg=deleteSuccess";
		</script>
	</c:when>
	<c:otherwise>
		<script type="text/javascript">
			history.go(-1);
			location.href="/wm2";
		</script>
	</c:otherwise>
	</c:choose>
</body>
</html>