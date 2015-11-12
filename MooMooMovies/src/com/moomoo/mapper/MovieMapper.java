package com.moomoo.mapper;

import org.hibernate.Session;

import com.moomoo.db.HibernateUtil;
import com.moomoo.model.Movie;

// Performs all DB operations for the Movie object in the DB
public class MovieMapper {
	// Retrieve a Movie object that matches the id in the DB
	public static Movie retrieveMovie(long id) {
		Session sess = HibernateUtil.getSessionFactory().getCurrentSession();
		sess.beginTransaction();
		return (Movie) sess.get(Movie.class, id);	
	}
}
