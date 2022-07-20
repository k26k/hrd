<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>
		<%
			request.setCharacterEncoding("UTF-8");
			String[] fruits = request.getParameterValues("fruit");
			
			if(fruits == null){
				out.println("선택한 과일이 없습니다");
			}else{
				out.println("선택한 과일은<br>");
				for(String fruit:fruits){out.println(fruit+" ");}
				out.println("입니다.");
			}
		%>
	</p>
</body>
</html>