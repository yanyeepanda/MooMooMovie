package com.moomoo.helper;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.moomoo.model.Movie;
import com.moomoo.model.MovieSession;

// Helper for Movie class for JSP pages
public class MovieHelper {
	Movie movie;
	
	public MovieHelper(Movie movie){
		this.movie = movie;
	}
	
	// Retrieves session list as id-time key-pair
	public HashMap<Long, Date> getMovieSessionList() {
		HashMap<Long, Date> movieTimes = new HashMap<>();
		for (int i = 0; i < movie.getSessionList().size(); i++) {
			MovieSession movieSession = movie.getSessionList().get(i);
			movieTimes.put(movieSession.getSessionId(), movieSession.getTime());
		}
		return movieTimes;
	}

	// Convert list of Movies to MovieHelpers
	public static List<MovieHelper> createHelperList(List<Movie> matchedMoviesList) {
		List<MovieHelper> matchedMoviesHelper = new ArrayList<MovieHelper>();
		for(int i = 0; i < matchedMoviesList.size(); i++){
			matchedMoviesHelper.add(new MovieHelper(matchedMoviesList.get(i)));
		}
		return matchedMoviesHelper;
	}
	
	// Get movie title
	public String getTitle(){
		return movie.getTitle();
	}
	
	// Get movie ID
	public long getMovieId() {
		return movie.getMovieId();
	}
}
