<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="member" class="com.repository.Member"/>
<jsp:setProperty property="memberID" name="member"/>
<jsp:setProperty property="passwd" name="member"/>
<jsp:setProperty property="name" name="member"/>
<jsp:setProperty property="gender" name="member"/>
<jsp:useBean id="MemberDAO" class="com.repository.MemberDAO" scope="application" />
<% 
	if(session.getAttribute("loginID")==null){
		response.sendRedirect("./login.jsp");
	}
	boolean check = MemberDAO.updateMember(member, (String)session.getAttribute("loginID")); 
	if(check){
		session.invalidate();
	}
%>
<c:choose>
	<c:when test="<%= check %>">
		<c:set var="text1" value="회원정보 수정 성공"/>
		<c:set var="text2" value="로그인"/>
		<c:set var="link1" value="'./loginMemberForm.jsp'"/>
	</c:when>
	<c:otherwise>
		<c:set var="text1" value="회원정보 수정 실패"/>
		<c:set var="text2" value="나의 정보"/>
		<c:set var="link1" value="'./memberView.jsp'"/>
	</c:otherwise>
</c:choose>
<h1 style="margin: 100px 0 0 0; text-align: center;"><c:out value="${text1}"/></h1>
<h2 style="margin: 30px 0 0 0; text-align: center;">3초후 <c:out value="${text2}"/> 페이지로 갑니다.</h2>
<p>${check}</p>
<script type="text/javascript">
	setTimeout(function() {location.href=${link1};}, 3000);
</script>