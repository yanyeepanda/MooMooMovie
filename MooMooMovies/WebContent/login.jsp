<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
</head>
<body>
	<form action="admin" method="post">
		<input type="hidden" name="command" value="Admin">
		Username: <input type="text" name="username">
		<br>
		Password: <input type="text" name="password">
		<br> 
		<input type="submit"value="Submit">
	</form>
	<a href="/MooMooMovies/index.html">Back</a>
</body>
</html>