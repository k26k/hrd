<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2>세션 타임아웃 설정</h2>
<h3>=== 세션 타임아웃 변경 전 ===</h3>
<%
	int timeSec = session.getMaxInactiveInterval();
	int timeMin = timeSec/60;

	out.println("<p>유효시간: "+timeSec+"초, "+timeMin+"분</p>");
%>
<h3>=== 세션 타임아웃 변경 후 ===</h3>
<%
	session.setMaxInactiveInterval(3*60); // 3분(180초) 설정	

	timeSec = session.getMaxInactiveInterval();
	timeMin = timeSec/60;

	out.println("<p>유효시간: "+timeSec+"초, "+timeMin+"분</p>");
%>