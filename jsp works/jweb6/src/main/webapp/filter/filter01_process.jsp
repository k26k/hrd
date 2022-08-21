<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	// 기존의 처리 방식
	// request.setCharacterEncoding("utf-8");
	
	// 필터를 이용시 필요없음
	String name = request.getParameter("name");
%>
입력된 값: <%= name %><br>
입력된 값: ${attri.name}