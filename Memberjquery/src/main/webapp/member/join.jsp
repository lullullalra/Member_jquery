<%@page import="gntp.model2.dao.MemberDAO"%>
<%@page import="gntp.model2.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script> -->
<script type="text/javascript" src="./js/jquery-3.6.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#btn_idcheck').on('click', function(){
			let value = $('#userid').val();
			//alert(value);
			$.ajax({
				type : "get",
				dataType : "text",
				asynce : false,
				url : "./YourServlet?command=ajax",
				data : {userid:value},
				success : function(data,status){
					alert('success '+data);
					//$('#message').append(data);
					if(data=="true"){
						data = "사용할 수 없는 아이디입니다.";
					}else{
						data = "사용가능한 아이디입니다.";
					}
					$('#message').html("<h3 style='display:inline; color:red;'>"+data+"</h3>");
				},
				error : function(data,status){
					alert('fail'+status);
				},
				complete : function(data,status){ //네트워크 에러가 뜨면 complete가 안뜬다.
					
				}
			});
		});
	})
	
</script>
</head>
<body>
	<form action="./YourServlet?command=join" method="post">
		ID: <input type="text" name="id" id="userid"/> <input type="button" id="btn_idcheck" value="id check" ><br>
		<hr/>
		result: <div id="message" style="display:inline;"></div>
		<hr/>
		PWD: <input type="password" name="pwd"/>
		<hr/>
		NAME: <input type="text" name="name"/>
		<hr/>
		EMAIL: <input type="text" name="email"/>
		<hr/>
		<input type="submit" value="회원 가입">
	</form>
</body>
</html>