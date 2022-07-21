<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
	
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		String gender = request.getParameter("gender");
		/* String hobby1 = request.getParameter("hobby1");
		String hobby2 = request.getParameter("hobby2");
		String hobby3 = request.getParameter("hobby3"); */
		String[] hobby = request.getParameterValues("hobby"); // 다중 처리
		String comment = request.getParameter("comment");
		
	%>
	
	<p>id: <%= id %></p>
	<p>pw: <%= pw %></p>
	<p>name: <%= name %></p>
	<p>phone: <%= phone1 %>-<%= phone2 %>-<%= phone3 %></p>
	<p>gender: <%= gender %></p>
	<%-- <p>hobby: <%= hobby1 %>, <%= hobby2 %>, <%= hobby3 %></p> --%>
	<p>hobby <%	out.print(hobby.length+"개: "); 
				for(String str:hobby) {out.println(str+" ");}%></p>
	<p>comment: <%= comment %></p>
</body>
</html>