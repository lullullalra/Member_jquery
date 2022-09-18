<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jquery Test</title>
<script type="text/javascript" src="./js/jquery-3.6.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		//alert('ready');
		$('#btn_call').on('click',function(){ //element 객체 찾아가서 on이라는 메소드 호출함. 여기서 두개의 매개변수('click', function(){})이 들어감
			alert('event calling');
		});
		
		$(".test").html("<h1>되나??</h1>");
		
		$('#btn_json').on('click', function(){
			let jsonStr = '{"name": ["kim", "lee", "park"]}';
			let jsonObj = JSON.parse(jsonStr);
			for(let idx in jsonObj.name){
				console.log(jsonObj.name[idx]);	
			}
			
			for(let val of jsonObj.name){
				//console.log(val);
			}
		});
		
		$('#btn_ajax').on('click', function(){
			let jsonStr = '{"name": ["kim", "lee", "park"]}';
			$.ajax({
				type : "post",
				dataType : "text",
				async : false,
				url : "./YourServlet?command=json",
				data : {name:jsonStr},
				success : function(data,status){
					alert('success '+data);
					let array = JSON.parse(data);
					let list = array.members;
					for(const obj of list){
						console.log(obj.name+","+obj.age+","+obj.id);
					}
					//$('#message').append(data);
					
				},
				error : function(data,status){
					alert('fail '+status);
				},
				complete : function(data,status){ //네트워크 에러가 뜨면 complete가 안뜬다.
					
				}
			});
		});
	});
	
	function addHtml(){
		$("#article").html("ㅎㅇ");
	}
	
	
</script>
</head>
<body>
	<h1>JQuery</h1>
	<button id="btn_call">이벤트 호출</button>
	<button id="btn_json">JSON 테스트</button>
	<button id="btn_ajax">ajax 테스트</button>
	<div class="test"></div>
	<h1 id="article"></h1>
	
	<br/>
	<input type="button" value="추가하기" onClick="addHtml()"/>
</body>
</html>