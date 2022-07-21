<%@page import="javax.websocket.SessionException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h3>=== 세션 추가 전 ===</h3>

<%	
	String id = (String)session.getAttribute("userID");
	String pw = (String)session.getAttribute("userPW");
	out.print("id: "+id+"<br>pw: "+pw);
%>

<h3>=== 세션 추가 후===</h3>

<%
	session.setAttribute("userID", "qwer");
	session.setAttribute("userPW", "1234");
	id = (String)session.getAttribute("userID");
	pw = (String)session.getAttribute("userPW");
	out.print("id: "+id+"<br>pw: "+pw);
%>

<h3>=== 세션 삭제 전 ===</h3>

<%
	id = (String)session.getAttribute("userID");
	pw = (String)session.getAttribute("userPW");
	out.print("id: "+id+"<br>pw: "+pw);
%>

<h3>=== 세션 삭제 후 ===</h3>

<%	
	session.removeAttribute("userID");

	id = (String)session.getAttribute("userID");
	pw = (String)session.getAttribute("userPW");
	out.print("id: "+id+"<br>pw: "+pw);
%>

<h3>=== 모든 세션 삭제 후 ===</h3>

<%
	session.invalidate();
	String[] valueNames = session.getValueNames();
	if(valueNames.length>0){
		for(String velueName:valueNames){
			out.println(velueName+": "+(String)session.getAttribute(velueName));
		}
	}else{
		out.print("session: null");
	}

%>