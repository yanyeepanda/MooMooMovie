<%@page import="java.util.Iterator"%>
<%@page import="java.util.Map"%>
<%@ page import="com.moomoo.helper.MovieHelper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	MovieHelper helper = (MovieHelper) session.getAttribute("helper");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Movie</title>
</head>
<body>
	<h1>Please select a movie session</h1>
	<form action='/MooMooMovies/MovieSession' method="post">
		<!-- Set name of comand to execute -->
		<input type="hidden" name="command" value="MovieSession">

		<!-- Iterate through session list from helper and display options as radio buttons -->
		<%
			Iterator it = helper.getMovieSessionList().entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry movieTime = (Map.Entry) it.next();
		%>
		<input type="radio" name="movieSession"
			value="<%=movieTime.getKey()%>" checked>
		<%=movieTime.getValue()%>
		<br>
		<%
			}
		%>
		<input type="submit" value="Next">
	</form>

</body>
</html>