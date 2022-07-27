<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	Enumeration<String> valueNames = request.getAttributeNames();
	while(valueNames.hasMoreElements()){
		String valueName = valueNames.nextElement();
		//out.println(valueName+": ");
		if(!valueName.substring(0,5).equals("javax")){
			out.println(valueName+": ");
			Object valueObj = request.getAttribute(valueName);
			//out.println(" . . . "+valueObj);
			if(valueObj instanceof String[]){
				for(String value:(String[])valueObj){
					out.println(value+" ");
				}
				
			}else if(valueObj instanceof ArrayList){
				for(Object value:(ArrayList)valueObj){
					if(value instanceof Integer){
						value = (Integer)value;
					}
					out.println(value+" ");
				}
				
			}else if(valueObj instanceof String[]){
				
			}
			
		out.println("<br>");
		}
	}

%>
	<c:forEach var="name" items="${names}">
		${name}<span> </span>
	</c:forEach>
</body>
</html>