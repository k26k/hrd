<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>숫자를 다양한 형식으로 출력</h2>
	<p>숫자: <fmt:formatNumber value="3200100"/></p>
	<p><fmt:formatNumber value="3200100" type="number"/></p>
	<p><fmt:formatNumber value="3200100" groupingUsed="false"/></p>
	<p><fmt:formatNumber value="3200100" groupingUsed="true"/></p>
	<p><fmt:formatNumber value="3200100" type="currency" currencySymbol="$"/></p>
	<p><fmt:formatNumber value="3200100" type="currency" currencySymbol="\\"/></p>
	<p><fmt:formatNumber value="0.25" type="percent"/></p>
	<p><fmt:formatNumber value="3200100.25" pattern="#,##0.0"/></p>
	<p><fmt:formatNumber value="3200100.25" pattern="#,##0.00000"/></p>
	<p><fmt:formatNumber value="100.25" pattern="00,000.#####"/></p>
</body>
</html>