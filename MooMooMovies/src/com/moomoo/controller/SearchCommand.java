package com.moomoo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import com.moomoo.helper.CinemaHelper;
import com.moomoo.helper.MovieHelper;
import com.moomoo.model.Cinema;
import com.moomoo.model.Movie;

// Command for performing movie search
public class SearchCommand extends FrontCommand{

	@Override
	public void process() throws ServletException, IOException {
		// Retrieve parameters
		Long id = Long.valueOf(request.getParameter("cinemaId").replace(" ", ""));
		Cinema cinema = Cinema.findById(id);
		String searchString = request.getParameter("searchText");
		
		// Perform search and create helper list
		List<Movie> matchedMoviesList = cinema.searchMovies(searchString);
		List<MovieHelper> matchedMovieHelpers = MovieHelper.createHelperList(matchedMoviesList); 
		HttpSession session = request.getSession();
	
		// Put results in session
		session.setAttribute("searchResults", true);
		session.setAttribute("matchedMoviesHelpers", matchedMovieHelpers);
		
		forward("/cinema.jsp");
	}

}
