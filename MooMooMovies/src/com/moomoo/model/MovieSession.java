package com.moomoo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.moomoo.mapper.MovieSessionMapper;

// Represents a session for particular movie
@Entity
public class MovieSession {
	private long sessionId;
	private Movie movie;
	private List<Seat> seatList;
	private Date time;
	
	public MovieSession() {}

	@Id
	@GeneratedValue
	public long getSessionId() {
		return sessionId;
	}

	public void setSessionId(long sessionId) {
		this.sessionId = sessionId;
	}

	@ManyToOne
	@JoinColumn(name="movie_id")
	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	// By not setting fetch type Hibernate defaults to lazy loading
	@OneToMany(targetEntity=Seat.class, mappedBy="session", cascade=CascadeType.ALL)
	public List<Seat> getSeatList() {
		return seatList;
	}

	public void setSeatList(List<Seat> seatList) {
		this.seatList = seatList;
	}
	
	public void addSeat(Seat seat) {
		this.seatList.add(seat);
		seat.setSession(this);
	}
	
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
	// Returns a MovieSession object with the given id
	public static MovieSession findById(long movieSessionId) {
		return MovieSessionMapper.retrieveMovieSession(movieSessionId);
	}
	
	// Filters the list of seats to only available seats
	public List<Seat> findAvailableSeats() {
		List<Seat> sL = new ArrayList<Seat>();
		for (int i = 0; i < seatList.size(); i++) {
			Seat seat = seatList.get(i);
			if (!seat.isTaken()) sL.add(seat);
		}
		return sL;
	}
	
	// Checks if the session has already started
	public boolean hasStarted(){
		Date presentTime = new Date();
		if(presentTime.compareTo(this.getTime()) > 0) {
			return true;
		}
		return false;
	}
	
}
