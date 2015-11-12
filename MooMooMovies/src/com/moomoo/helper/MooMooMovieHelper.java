package com.moomoo.helper;

import java.util.ArrayList;
import java.util.HashMap;

import com.moomoo.model.Cinema;
import com.moomoo.model.MooMooMovie;
import com.moomoo.model.Movie;

// Helper for MooMooMovie class for JSP pages
public class MooMooMovieHelper {
	MooMooMovie mooMooMovie;
	
	public MooMooMovieHelper() {
		mooMooMovie = MooMooMovie.getMooMooMovie();
	}
	
	// Retrieves list of cinemas as id-location key-pair
	public HashMap<Long, String> getCinemaList() {
		HashMap<Long, String> cinemas = new HashMap<>();
		for (int i = 0; i < mooMooMovie.getCinemaList().size(); i++) {
			Cinema cinema = mooMooMovie.getCinemaList().get(i);
			cinemas.put(cinema.getCinemaId(), cinema.getAddress());
		}
		return cinemas;
	}
	
}
