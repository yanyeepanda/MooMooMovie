<%@page import="com.moomoo.helper.TicketHelper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% TicketHelper helper = (TicketHelper) session.getAttribute("helper"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ticket Information</title>
</head>
<body>
	<h1>Ticket Information</h1>
	TicketID: <%= helper.getTicketId() %>
	<br>
	Location: <%= helper.getLocation() %>
	<br>
	Movie: <%= helper.getMovieTitle() %>
	<br>
	Time: <%= helper.getMovieTime() %>
	<br>
	Seat: <%= helper.getSeatLabel() %>
	<br>
	<a href="/MooMooMovies/index.html">Home</a>
	<a href="/MooMooMovies/refund?command=Refund&ticketId= <%= helper.getTicketId() %>">Refund</a>
	<a href="/MooMooMovies/MooMooMovie?command=ChangeSeat&ticketId= <%= helper.getTicketId() %>">Change Seats</a>
</body>
</html>