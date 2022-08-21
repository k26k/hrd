<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소록 내용</title>
<link rel="stylesheet" type="text/css" href="css/addrbook.css">
</head>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="addrBook" class="dao.AddrBook"/>
<jsp:setProperty property="username" name="addrBook" />
<jsp:setProperty property="tel" name="addrBook" />
<jsp:setProperty property="email" name="addrBook" />
<jsp:setProperty property="gender" name="addrBook" />
<jsp:useBean id="addrDAO" class="dao.AddrBookDAO" scope="application" />
<% 	
	if(addrBook.nullCheck()){
		%>
		<script type="text/javascript">
			alert("값을 입력해 주세요.");
			location.href="addrForm.jsp";
		</script>
		<%
	}else{
		addrDAO.addAddress(addrBook);
	}
%>


<body>
	<div id="container" >
		<h2>주소록 내용</h2>
		<hr>
		<p>이름: <%= addrBook.getUsername() %></p>
		<p>전화번호: <%= addrBook.getTel() %></p>
		<p>이메일: <%= addrBook.getEmail() %></p>
		<p>성별: <%= addrBook.getGender() %></p>
		<hr>
		<a href="addrList.jsp">목록 보기</a>
	</div>
</body>
</html>