<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%String error = (String)session.getAttribute("error"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error</title>
</head>
<body>
	<h1>Error</h1>
	<!-- Display error message passed in command -->
	<h2><%=error %></h2>
	<a href="/MooMooMovies/index.html">Home</a>
</body>
</html>