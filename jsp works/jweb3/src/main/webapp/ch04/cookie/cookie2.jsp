<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie[] cookies = request.getCookies();
	
	out.println("쿠키의 갯수: "+cookies.length+"개<br>");
	
	for(Cookie cookie:cookies){
		out.println("쿠키의 속성: "+cookie.getName()+", 쿠키의 속성 값: "+cookie.getValue()+", 쿠키의 유효 기간: "+cookie.getMaxAge()+"<br>");
	}
%>