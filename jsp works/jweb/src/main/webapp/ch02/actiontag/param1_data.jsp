<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>param ์ก์ ํ๊ทธ</title>
</head>
<body>
	<% 
		String 	id = request.getParameter("id"),
				pw = request.getParameter("pw");
		
		/* out.println("id: "+id+" <br> pw: "+pw); */
	%>
	<p>id: <%=id %><br>pw: <%=pw %></p>
</body>
</html>