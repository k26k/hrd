<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 로그인 체크</title>
</head>
<body>
	<h2>로그인 시도중</h2>
	<%
		request.setCharacterEncoding("utf-8");
		String userid = request.getParameter("userid");
		String userpw = request.getParameter("userpw");
		
		if(userid.equals("qwer") && userpw.equals("1234")){
			session.setAttribute("userID", userid); // ("세션 속성 이름", 세션 속성값)
			session.setAttribute("userPW", userpw);
			response.sendRedirect("loginData.jsp");
		}else{
			out.println("<script>");
			out.println("alert('아이디, 비번 불일치')");
			out.println("history.go(-1)"); // 뒤로가기			
			out.println("</script>");
		}
 	%>
</body>
</html>