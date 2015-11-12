<%@page import="com.moomoo.helper.MovieHelper"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Map"%>
<%@ page import="com.moomoo.helper.CinemaHelper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	CinemaHelper helper = (CinemaHelper) session.getAttribute("helper");
	boolean searchResults = (Boolean) session.getAttribute("searchResults");
	List<MovieHelper> matchedMoviesHelpers =(List<MovieHelper>) session.getAttribute("matchedMoviesHelpers");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cinema</title>
</head>
<body>
	<h1>Please select a Movie</h1>
	<form action='/MooMooMovies/cinema' method='post'>
		<input type="hidden" name="command" value="Search">
		<input type="hidden" name="cinemaId" value=<%= helper.getCinemaId() %>>
		<input type="text" name="searchText">
		<input type="submit" value="search">
		
	</form>
	<form action='/MooMooMovies/movie' method="post">
		<!-- Set name of comand to execute -->
		<input type="hidden" name="command" value="Movie">

		<%
		/* Iterate through movie list from helper and display options as radio buttons */
		if (!searchResults){
			HashMap<Long,String> listOfMovies;
			listOfMovies = helper.getMovieList();
			Iterator it = helper.getMovieList().entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry movie = (Map.Entry) it.next();
		%>
			<input type="radio" name="movie" value=" <%=movie.getKey()%> " checked>
			<%=movie.getValue()%>
			<br>
			<%
				}
		}
		
		/* If displaying search results, iterate through matchedMovieHelpers */
		else{
			for(MovieHelper movie : matchedMoviesHelpers) {			
		%>
			<input type="radio" name="movie" value=" <%= movie.getMovieId() %> " checked>
			<%=movie.getTitle()%>
			<br>
		<%
			}
		}
		%>

		<input type="submit" value="Next">
	</form>
</body>
</html>