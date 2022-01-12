<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
 		$(".delete").click(function(){
 			
 			id = $(this).parent().siblings(".id").text();
 			var param = {"id" : id};
 			$.ajax({
 				url : "Controller?command=delete",
 				type : "get",
 				dataType : 'json',
 				data : param,
 				success : function(data){
 						jar = data;
						alert("삭제되었습니다");
						str="";
						$(".sub").remove();
						for(var i=0;i<jar.length;i++){
							str +='<tr>'
								+	'<td class="id" user_id="'+jar[i].id+'">'+jar[i].id+'</td>'
								+		'<td >'+jar[i].pw+'</td>'
								+		'<td>'+jar[i].name+'</td>'
								+		'<td>'+jar[i].point+'</td>'
								+		'<td><button class="update">수정</button></td>'
								+		'<td><button class="delete">삭제</button></td>'
								+	'</tr>'
						}
						$("#title").append(str);
 				},
 				error : function(){
 				}
 			})  
 		})
 		
 		$(".update").click(function(){
 			id = $(this).parent().siblings(".id").text();
 			location.href="Controller?command=update&id="+id;
 		})
 		
 		
 	})
 </script>
<title>Insert title here</title>
</head>
<style>
	table{
		border-collapse:collapse;
	}
	table, th, td {
  		border: 1px solid black;
	}
	th {
		padding : 10px 30px;
	}
	td {
		padding : 10px 30px;
	}
</style>
<body>
	<button style="margin-left : 550px;" onclick="location.href='Controller?command=signOut'">로그인</button>
	<h1>회원관리</h1>
		<table id="title">
			<tr>
				<th>ID</th>
				<th>PW</th>
				<th>Name</th>
				<th>Point</th>
				<th>수정</th>
				<th>삭제</th>
			</tr>
			<c:forEach var="item" items="${list}">
			<tr class="sub">
				<td class="id" user_id="${item.getId()}">${item.getId()}</td>
				<td >${item.getPw()}</td>
				<td>${item.getName()}</td>
				<td>${item.getPoint()}</td>
				<td><button class="update">수정</button></td>
				<td><button class="delete">삭제</button></td>
			</tr>
			</c:forEach>
		</table>
</body>
</html>