<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie[] cookies = request.getCookies();
	
	out.println("쿠키의 갯수: "+cookies.length+"개<br>");
	
	out.println("한 개 지우기<br>");
	if(cookies.length > 0){
		Cookie cookie = cookies[0];
		out.println("지워질 쿠키의 속성: "+cookie.getName()+", 쿠키의 속성 값: "+cookie.getValue()+"<br>");
		out.println("지워질 쿠키의 유효기간:"+cookie.getMaxAge()+"<br>");
		cookie.setMaxAge(0);
		out.println("변경된 유효기간:"+cookie.getMaxAge()+"<br>");

		
		response.addCookie(cookie);
	}
	
	cookies = request.getCookies();
			
	out.println("<br>쿠키의 갯수: "+cookies.length+"개<br>");
	
	for(Cookie cookie:cookies){
		out.println("쿠키의 속성: "+cookie.getName()+", 쿠키의 속성 값: "+cookie.getValue()+"<br>");
	}
%>