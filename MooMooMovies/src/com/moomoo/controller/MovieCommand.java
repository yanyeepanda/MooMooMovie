package com.moomoo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import com.moomoo.helper.MovieHelper;
import com.moomoo.model.Movie;

// Gets chosen movie and displays that movie's page
public class MovieCommand extends FrontCommand{

	@Override
	public void process() throws ServletException, IOException {
		long id = Long.valueOf(request.getParameter("movie").replace(" ", ""));
		Movie movie = Movie.findById(id);

		MovieHelper helper = new MovieHelper(movie);
		HttpSession session = request.getSession();
		session.setAttribute("helper", helper);
		forward("/movie.jsp");
		
	}

}
