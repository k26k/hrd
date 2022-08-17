<%@page import="java.time.LocalDate"%>
<%@page import="java.util.Date"%>
<%@page import="com.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="member" class="com.vo.Member" scope="page"/>
<%
	request.setCharacterEncoding("utf-8");
	
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	String name = request.getParameter("name");
	String gender = request.getParameter("gender");
	String birth = request.getParameter("birth1")+"-"+request.getParameter("birth2")+"-"+request.getParameter("birth3");
	String mail = request.getParameter("mail1")+"@"+request.getParameter("mail2");
	String phone = request.getParameter("phone");
	String address = request.getParameter("address");
	
	LocalDate localDate = LocalDate.now();
	String registDay = localDate.getYear()+"-"+localDate.getMonthValue()+"-"+localDate.getDayOfMonth();
	
	member.setId(id);
	member.setPassword(password);
	member.setName(name);
	member.setGender(gender);
	member.setBirth(birth);
	member.setMail(mail);
	member.setPhone(phone);
	member.setAddress(address);
	member.setRegistDay(registDay);
	
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
		insert into member values(?,?,?,?,?,?,?,?,?);
		<sql:param value="${ member.id }"/>
		<sql:param value="${ member.password }"/>
		<sql:param value="${ member.name }"/>
		<sql:param value="${ member.gender }"/>
		<sql:param value="${ member.birth }"/>
		<sql:param value="${ member.mail }"/>
		<sql:param value="${ member.phone }"/>
		<sql:param value="${ member.address }"/>
		<sql:param value="${ member.registDay }"/>
	</sql:update>
	<c:choose>
	<c:when test="${ resultSet >= 1 }">
		<script type="text/javascript">
			location.href="/wm2/member/resultMember.jsp?msg=addSuccess";
		</script>
	</c:when>
	<c:otherwise>
		<script type="text/javascript">
			window.history.go(-1);
		</script>
	</c:otherwise>
	</c:choose>
</body>
</html>