package com.moomoo.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.moomoo.mapper.MovieMapper;
import com.moomoo.mapper.MovieSessionMapper;

// Represents a movie been shown at a cinema
@Entity
public class Movie {
	private long movieId;
	private String title;
	private String rating;
	private Cinema cinema;
	private List<MovieSession> sessionList;
	private String[] tags;
	
	public Movie(long movieId, String title, String rating) {
		this.movieId = movieId;
		this.title = title;
		this.rating = rating;
	}
	
	public Movie() {}

	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	@Id
	@GeneratedValue
	public long getMovieId() {
		return movieId;
	}

	public String getTitle() {
		return title;
	}

	public String getRating() {
		return rating;
	}

	@ManyToOne
	@JoinColumn(name="cinema_id")
	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

	// By not setting fetch type Hibernate defaults to lazy loading
	@OneToMany(targetEntity=MovieSession.class, mappedBy="movie", cascade=CascadeType.ALL)
	public List<MovieSession> getSessionList() {
		return sessionList;
	}

	public void setSessionList(List<MovieSession> sessionList) {
		this.sessionList = sessionList;
	}
	
	// Adds a session for a movie
	public void addSession(MovieSession session) {
		this.sessionList.add(session);
		session.setMovie(this);
	}
	
	// Returns a Movie object with the given id
	public static Movie findById(long movieId) {
		return MovieMapper.retrieveMovie(movieId);
	}

	public String[] getTags() {
		return tags;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}
	
	// Add a tag for the movie
	public void addTag(String tag) {
		int N = this.tags.length;
	    this.tags = Arrays.copyOf(this.tags, N + 1);
	    this.tags[N] = tag;
	}
}
