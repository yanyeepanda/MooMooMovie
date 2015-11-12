<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.moomoo.helper.AdminHelper"%>
<%@ page import="com.moomoo.helper.TicketHelper"%>
<%@ page import="java.util.List"%>
<%
	AdminHelper helper = (AdminHelper) session.getAttribute("admin");
	List<TicketHelper> refunds = (List<TicketHelper>) session.getAttribute("refunds");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin</title>
</head>
<body>
	Logged in as <%= helper.getUsername() %>
	<h1>Refunds</h1>
	
	<%
		/* Iterate through refund tickets and display each with options to process */
		for(TicketHelper refund : refunds) {
	%>
		<form action='/MooMooMovies/delete' method="post">
			<input type="hidden" name="command" value="Delete">
			<input type="hidden" name="ticketID" value=<%= refund.getTicketId() %>>
			<%= refund.getTicketId() %>
			<input type="radio" name="refund" value="true" checked>Refund
			<input type="radio" name="refund" value="false" checked>Decline
			<input type="submit" value="Submit">
		</form>
	<%
		}
	%>
	<a href="/MooMooMovies/logout?command=Logout">Logout</a>
</body>
</html>