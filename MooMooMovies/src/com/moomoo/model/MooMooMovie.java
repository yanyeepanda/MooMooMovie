package com.moomoo.model;

import java.util.ArrayList;

import com.moomoo.mapper.CinemaMapper;

// Singleton object that represents an entry point for all MooMooMovie data
public class MooMooMovie {
	private static MooMooMovie instance = null;
		
	private ArrayList<Cinema> cinemaList;
	
	private MooMooMovie() {
		cinemaList = CinemaMapper.retrieveCinemaList();
	}
	
	// Gets the MooMooMovie object according to singleton pattern
	public static MooMooMovie getMooMooMovie() {
		if (instance == null) {
			instance = new MooMooMovie();
		}
		return instance;
	}

	public ArrayList<Cinema> getCinemaList() {
		return cinemaList;
	}
	
}
