<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Final Project</title>
</head>
<body  background="../1.jpg">
<form action="login">
<style>
p{
	position:relative;
	top:90px; 
	left:50px; 
}
</style>
<p>帳號:<input type="text" name="userid"/></p>
<p>密碼:<input type="password" name="password"/></p>
<p><input type="submit" value="登入"/></p>
<p><a href="<%= ("/add.jsp")%>">按此創建新帳號</a></p>
</body>
</html>