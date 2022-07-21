<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>get 방식</title>
</head>
<body>
	<%
		int cnt = 0;
		String strCount = request.getParameter("cnt");
		if(strCount != null){
			cnt = Integer.parseInt(strCount);	
		}
	
		for(int i=0; i<cnt; i++) {
			out.println("안녕 JSP"+"<br>");
		}
	%>
</body>
</html>