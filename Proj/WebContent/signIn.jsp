<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	result='${fail}'
	console.log(result + "dd")
	if(result!=""){
		alert(result);
	}
</script>
<style>

</style>
</head>
<body>
	<h1>로그인</h1>
	<form action="Controller?command=signInAction" method="post">
		id: <input type="text" name="id"/><br/>
		pw: <input type="password" name="pw"/><br/>
			<input type="submit" value="로그인"/><br/>
	</form>
	<button onclick="location.href='Controller?command=signUp'">회원가입</button>
</body>
</html>