<%@page import="java.util.Iterator"%>
<%@page import="java.util.Map"%>
<%@ page import="com.moomoo.helper.MooMooMovieHelper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	MooMooMovieHelper helper = (MooMooMovieHelper) session.getAttribute("helper");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Moo Moo Movies</title>
</head>
<body>
	<h1>Please select a Cinema</h1>
	<form action="/MooMooMovies/cinema" method="post">
		<!-- Set name of comand to execute -->
		<input type="hidden" name="command" value="Cinema">

		<!-- Iterate through cinema list from helper and display options as radio buttons -->
		<%
			Iterator it = helper.getCinemaList().entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry cinema = (Map.Entry) it.next();
		%>
		<input type="radio" name="cinema" value=" <%=cinema.getKey()%> "
			checked>
		<%=cinema.getValue()%>
		<br>
		<%
			}
		%>
		<input type="submit" value="Next">
	</form>

</body>
</html>