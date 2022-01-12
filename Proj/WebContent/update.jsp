<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원 관리 - 수정 관리자</h1>
<form action="Controller?command=updateAction" method="post">
	ID : <input type="text" name="id" value="${user.getId()}" readonly/><br/>
	PW : <input type="text" name="pw" value="${user.getPw()}" /><br/>
	Name : <input type="text" name="name" value="${user.getName()}" /><br/>
	Point : <input type="text" name="point" value="${user.getPoint()}" /><br/>
	<input type="submit" value="제출"/>
</form>

</body>
</html>