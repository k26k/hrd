<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<ol class="left">
	<c:forEach var="reply" items="${ replyList }">
		<li>
			<br>
			<p>
				작성자: <c:out value="${ reply.replyer }"/>
				&nbsp;&nbsp;
				(작성일: <fmt:formatDate value="${ reply.updateDate }" pattern="yyyy-MM-dd HH:mm:ss"/>)
			</p>
			<p><c:out value="${ reply.reply }"/></p>
		</li>	
	</c:forEach>
</ol>