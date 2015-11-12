package com.moomoo.helper;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.eclipse.jdt.internal.compiler.util.Sorting;
import org.hibernate.type.CustomCollectionType;

import com.moomoo.model.Cinema;
import com.moomoo.model.Movie;
import com.moomoo.model.MovieSession;

// Helper for Cinema class for JSP pages
public class CinemaHelper {
	Cinema cinema;
	
	public CinemaHelper(Cinema cinema) {
		this.cinema = cinema; 
	}
	
	// Retrieves the list of movies as a id-title key-pair
	public HashMap<Long, String> getMovieList() {
		HashMap<Long, String> movies = new HashMap<>();
		for (int i = 0; i < cinema.getMovieList().size(); i++) {
			Movie movie = cinema.getMovieList().get(i);
			movies.put(movie.getMovieId(), movie.getTitle());
		}
		return movies;
	}
	
	public HashMap<Long, String> getMatchedMovieList(String searchString) {
		HashMap<Long, String> matchedMovies = new HashMap<>();
		for (int i = 0; i < cinema.searchMovies(searchString).size(); i++) {
			Movie matchedMovie = cinema.searchMovies(searchString).get(i);
			matchedMovies.put(matchedMovie.getMovieId(), matchedMovie.getTitle());
		}
		return matchedMovies;
	}
	
	public Long getCinemaId() {
		return cinema.getCinemaId();
	}
}
