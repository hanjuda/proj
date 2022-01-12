<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
  src="https://code.jquery.com/jquery-3.6.0.js"
  integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
  crossorigin="anonymous">
 </script>
 <script>
 	$(function(){
 		var regex = /[^0-9]/g;	
 		$(".pr").click(function(){
 			user_point = parseInt($(".poin").text().replace(regex,""));
 			minus_point = parseInt($(this).attr("point"));
 			pr_name = $(this).attr("pr");
 			
 			
 			if(user_point<minus_point){
 				alert("포인트가 부족합니다. 광고를 클릭하세요");
 				return;
 			} 
 			 
 			var param ={
 					"minus_point" : minus_point,
 			}
 			$.ajax({
 				url : "Controller?command=buy",
 				type : "get",
 				dataType : 'json',
 				data : param,
 				success : function(data){
 					alert("컨텐츠("+pr_name+")를 구입하였습니다.")
 					
 					$(".poin").text("포인트 : "+data+"점")
 				},
 				error : function(){
 					
 				}
 			})  
 		})
 		
 		$("#adver").click(function(){
 			alert("1000점이 적립되었습니다");
 			location.href="Controller?command=addPoint"
 		})
 		
 	})
 </script>
<title>Insert title here</title>
</head>

<style>
	body{
		width : 100%;
	}
	#id_box{
		display : flex;
		justify-content : space-around;
	}
	#product_box{
		width : 1200px;
		margin : 100px auto;
		
	}
	#box{
		display :flex;
		justify-content: space-between;
	}
	#box p{
		margin-left : 100px;
	}
	img{
		cursor : pointer;
	}
</style>
<body>
	<div id="id_box">
		<h2>메인페이지</h2>
		<div>
			<span>${userInfo.getName()}님 안녕하세요</span>
			<button onclick="location.href='Controller?command=signOut'">로그아웃</button>
			<p class="poin">포인트 : ${userInfo.getPoint()}점</p>
		</div>
	</div>
	
	<div id ="product_box">
		<h2>구입할 컨텐츠를 선택하세요</h2>
		<div id="box">
			<div class="pr" point="100000" pr="intro">
				<img  src="./img/Intro_350_408.png" />
				<p>100,000포인트</p>		
			</div>
			<div class="pr" point="500000" pr="java">
				<img src="./img/Java_350_408.png" />
				<p>500,000포인트</p>		
			</div>
			<div class="pr" point="300000" pr="C++">
				<img src="./img/Cpp_350_408.png" />
				<p>300,000포인트</p>		
			</div>
		</div>
	</div>
	<img id="adver" style="float : right;" src="./img/korea_it.png"/>	

	
</body>
</html>