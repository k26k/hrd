<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
  src="https://code.jquery.com/jquery-3.6.1.js"
  integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI="
  crossorigin="anonymous"></script>
</head>
<script type="text/javascript">
	$(document).ready(function(){
		
		//$("#button").click(function(){$("#h2").append("ㅎㅇ")});
		
	});
	
	function calc(){
		console.log($("#num1"));
		let num1v = $("#num1").val();
		let num2v = $("#num2").val();
		console.log(num1v, num2v)
		$.ajax({
			type:"get",
			url:"http://112.222.187.243/ajax/doPlus",
			dataType:"json",
			data:{
				"num1": num1v,
				"num2": num2v
			},
			success:function(data){
				console.log(data);
				let json = data;//JSON.parse(data);
				console.log(json.result, json.result_msg);
				$("#result").val(json.result);
				$("#result_msg").val(json.result_msg);
			},
			error:function(error){
				console.error(error);
			}
		});
	}

</script>
</head>
<body>
	<div>
		<h2 id="h2">###</h2>
	</div>
	<div>
		<p><input type="text" id="num1"></p>
		<p><input type="text" id="num2"></p>
		<p><input type="button" value="더하기" id="button" onclick="calc()" ></p>
	</div>
	<hr>
	<div>
		<p>
			<label>결과창</label>
			<input type="text" id="result">
			<input type="text" id="result_msg">
		</p>
	</div>
</body>
</html>