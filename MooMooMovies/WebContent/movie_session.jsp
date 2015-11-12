<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.Map"%>
<%@ page import="com.moomoo.helper.MovieSessionHelper"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	MovieSessionHelper helper = (MovieSessionHelper) session.getAttribute("helper");
%>
<%
	String command = (String) session.getAttribute("command");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Movie Session</title>
</head>
<body>
	<h1>Please select a seat</h1>
	<form action='/MooMooMovies/payment' method="post">
		<!-- Set name of comand to execute -->
		<input type="hidden" name="command" value="<%=command%>">
		
		<!-- Iterate through seat list from helper and display options as radio buttons -->
		<%
			Iterator it = helper.getSeatList().entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry seat = (Map.Entry) it.next();
		%>
		<input type="radio" name="seat" value="<%=seat.getKey()%>" checked>
		<%=seat.getValue()%>
		<br>
		<%
			}
		%>
		<input type="submit" value="Next">
	</form>

</body>
</html>