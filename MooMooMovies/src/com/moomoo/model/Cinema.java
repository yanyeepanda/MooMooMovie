package com.moomoo.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.moomoo.mapper.CinemaMapper;

// Cinema object represents a MooMooMovie movie cinema location
@Entity
public class Cinema {
	private long cinemaId;
	private List<Movie> movieList;
	private String address;
	
	public Cinema(long cinemaId, String address) {
		this.cinemaId = cinemaId;
		this.address = address;
	}
	
	public Cinema() {}

	@Id
	@GeneratedValue
	public long getCinemaId() {
		return cinemaId;
	}

	public void setCinemaId(long cinemaId) {
		this.cinemaId = cinemaId;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	// By not setting fetch type Hibernate defaults to lazy loading
	@OneToMany(targetEntity=Movie.class, mappedBy="cinema", cascade=CascadeType.ALL)
	public List<Movie> getMovieList() {
		return movieList;
	}

	public void setMovieList(List<Movie> movieList) {
		this.movieList = movieList;
	}
	
	// Adds a movie to shown at the cinema
	public void addMovie(Movie movie) {
		this.movieList.add(movie);
		movie.setCinema(this);
	}
	
	// Returns a Cinema object with the given id
	public static Cinema findById(long cinemaId) {
		return CinemaMapper.retrieveCinema(cinemaId);
	}
	
	// Filter movie list based on search string
	public List<Movie> searchMovies(String searchString) {
		ArrayList<Movie> mathcedMovie = new ArrayList<Movie>();
		
		// For each movie add to results if title or tags contain search string
		for (int i = 0; i < movieList.size(); i++){
			List<String> tags = Arrays.asList(movieList.get(i).getTags());
			if (movieList.get(i).getTitle().toLowerCase().contains(searchString.toLowerCase()) || tags.contains(searchString.toLowerCase())){
				mathcedMovie.add(movieList.get(i));
			}
		}
		
		return mathcedMovie;
	}
}
