<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Scripting Tag</h2>
	<!-- 선언문 태그 -->
	<%! 
		int num1 = 10, num2 = 20;
		int sum = 0;
	%>
	<!-- 스트립틀릿 태그 -->
	<%
		// 더하기
		sum = num1+num2;
		out.println(sum);
		
		//짝수출력
		/* for(int i=1; i<=10; i++){
			if(i%2 == 0){
				out.println(i);
			}
		} */
		for(int i=1; i<=10; i++)if(i%2 == 0)out.println(i);
	%>
</body>
</html>