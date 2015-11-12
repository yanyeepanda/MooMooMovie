package com.moomoo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import com.moomoo.helper.MovieSessionHelper;
import com.moomoo.model.MovieSession;

// Retrieves a chosen movie session and goes to seat selection page
public class MovieSessionCommand extends FrontCommand{

	@Override
	public void process() throws ServletException, IOException {
		long id = Long.valueOf(request.getParameter("movieSession").replace(" ", ""));
		MovieSession movieSession = MovieSession.findById(id);

		HttpSession session = request.getSession();
		if (movieSession.findAvailableSeats().size() == 0) {
			// If no seats available display an error page
			session.setAttribute("movie", movieSession.getMovie().getMovieId());
			forward("/no_session.jsp");
		} else {
			// If available seats display seat selection page
			MovieSessionHelper helper = new MovieSessionHelper(movieSession);
			session.setAttribute("helper", helper);
			session.setAttribute("command", "Seat");
			forward("/movie_session.jsp");	
		}
	}

}
