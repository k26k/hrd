<%@page import="java.io.IOException"%>
<%@page import="java.io.IOError"%>
<%@page import="java.util.function.Function"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.dao.AddrBook" %>
<jsp:useBean id="addrDAO" class="com.dao.AddrBookDAO" scope="application" />
<%
	request.setCharacterEncoding("utf-8");
	Object numObj = request.getParameter("num");
	String text = "";
	if(numObj==null){
		text = "alert('선택해주세요');";
		return;
	}
	int num = Integer.parseInt((String)numObj);
	AddrBook addrBook = addrDAO.getAddress(num);
	String email = (String)session.getAttribute("sessionID");
	if(!addrBook.getEmail().equals(email)){
		text = "alert('목록에 없습니다');";
	}else{
		if(!addrDAO.delete(num)){
			text = "alert('삭제 실패');";
		}else{
			text = "alert('삭제 성공');";
		}
	}
	text += "location.href='addrList.jsp';";
%>