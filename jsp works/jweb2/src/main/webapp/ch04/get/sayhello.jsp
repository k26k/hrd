<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>get ë°Šė</title>
</head>
<body>
	<%
		int cnt = 0;
		String strCount = request.getParameter("cnt");
		if(strCount != null){
			cnt = Integer.parseInt(strCount);	
		}
	
		for(int i=0; i<cnt; i++) {
			out.println("ėë JSP"+"<br>");
		}
	%>
</body>
</html>