<%@page import="com.repository.Member"%>
<%@page import="java.util.regex.Pattern"%>
<%@page import="com.repository.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<jsp:useBean id="boardDAO" class="com.repository.BoardDAO" />
<jsp:useBean id="memberDAO" class="com.repository.MemberDAO" />
<%
	String getNum = (String)request.getParameter("num");
	String regNum = "^[0-9]*$" ;
	if(request.getParameter("num")==null || !Pattern.matches(regNum, getNum)){
		out.println("<script>alert('잘못된 접근입니다.');location.href='./boardList.jsp';</script>");
		return;
	}
	
	Board board = boardDAO.getBoard(Integer.parseInt(getNum));
	
	if(board.getbNum() == 0){
		out.println("<script>alert('없는 게시글입니다.');location.href='./boardList.jsp';</script>");
		return;
	}
	
	String name = (String)memberDAO.getMember(board.getMemberID()).getName();
	
	boolean writer = false;
	
	if(session.getAttribute("loginID")!=null && board.getMemberID().equals((String)session.getAttribute("loginID"))){
		writer=true;
		session.setAttribute("bNum", board.getbNum());
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세 보기</title>
<link rel="stylesheet" type="text/css" href="../resources/css/common.css">
</head>
<body>
	<div class="container">
		<jsp:include page="../menu.jsp"/>
		<div class="contents">
			<div class="first_title">
				<h1>게시글 상세 보기</h1>
			</div>
			<form action="" method="post" class="board_view" name="board_view">
				<table>
					<colgroup>
						<col/>
						<col/>
					</colgroup>
					<tr>
						<td>제목</td>
						<td> <input type="text" name="title" value= "<%= board.getTitle() %>" <% if(!writer){out.println("readonly");} %>> </td>
					</tr>
					<tr>
						<td>글쓴이</td>
						<td> <input type="text" value= "<%= name %>" readonly> </td>
					</tr>
					<tr>
						<td>내용</td>
						<td> <textarea name="content" <% if(!writer){out.println("readonly");} %> ><%= board.getContent() %></textarea> </td>
					</tr>
					<tr>
						<td colspan="2">
						<c:choose>
						<c:when test="<%= writer %>">
							<input type="button" value="수정" onclick="board_view.action='./updateBoard.jsp';board_view.submit();">
							<input type="button" value="삭제" onclick="board_view.action='./deleteBoard.jsp';board_view.submit();">
							<input type="button" value="목록" onclick="location.href='./boardList.jsp'">
						</c:when>
						<c:otherwise>
							<input type="button" value="목록" onclick="location.href='./boardList.jsp'">
						</c:otherwise>
						</c:choose>
						</td>
					</tr>
				</table>
			</form>
		</div>
		<jsp:include page="../footer.jsp"/>
	</div>
</body>
</html>