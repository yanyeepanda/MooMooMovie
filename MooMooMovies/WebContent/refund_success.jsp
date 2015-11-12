<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%String refund = (String)session.getAttribute("refund"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Refund Success</title>
</head>
<body>
	<h2>Refund decision has been processed</h2>
	<form action='/MooMooMovies/admin' method="post">
		<input type="hidden" name="command" value="Admin">
		<input type="submit" value="Continue">
	</form>
</body>
</html>