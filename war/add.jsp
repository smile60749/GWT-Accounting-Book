<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>註冊頁面</title>
</head>
<body  background="../2.jpg">
<form action="add">
<style>
p{
	position:relative;
	top:50px; 
	left:50px; 
}
</style>
<p>帳號:<input type="text" name="userid"/></p>
<p>密碼:<input type="password" name="password"/></p>
<p><input type="submit" value="送出"/></p>
<p><a href="<%= ("/login.jsp")%>">按此返回登入帳號</a></p>
</body>
</html>