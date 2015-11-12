package com.moomoo.helper;

import java.util.Date;
import java.util.HashMap;

import com.moomoo.model.Movie;
import com.moomoo.model.MovieSession;
import com.moomoo.model.Seat;

// Helper for MovieSession class for JSP pages
public class MovieSessionHelper {
    MovieSession movieSession;
	
	public MovieSessionHelper(MovieSession movieSession){
		this.movieSession = movieSession;
	}
	
	// Retrieve available seat list as id-seatLabel key-value pair
	public HashMap<Long, String> getSeatList() {
		HashMap<Long, String> seats = new HashMap<>();
		for (int i = 0; i < movieSession.findAvailableSeats().size(); i++) {
			Seat seat = movieSession.findAvailableSeats().get(i);
			seats.put(seat.getSeatId(), seat.getSeatLabel());
		}
		return seats;
	}
}
