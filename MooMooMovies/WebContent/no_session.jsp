<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	long movieId = (Long) session.getAttribute("movie");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>No Sessions</title>
</head>
<body>
	<h1>Oh No</h1>
	Sorry, tickets for this movie session have sold old.
	<br>
	<a href="/MooMooMovies/index.html">Cancel Purchase</a>
	<br>
	<a href="/MooMooMovies/movie?command=Movie&movie=<%=movieId%>">Choose
		Different Session</a>
</body>
</html>