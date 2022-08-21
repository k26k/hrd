<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	String phone = 	request.getParameter("phone1")
					+"-"+request.getParameter("phone2")
					+"-"+request.getParameter("phone3");
	String email = request.getParameter("email");
%>

<p>아이디: <%= id %></p>
<p>비밀번호: <%= pw %></p>
<p>이름: <%= name %></p>
<p>연락처: <%= phone %></p>
<p>이메일: <%= email %></p>