package com.moomoo.mapper;

import org.hibernate.Session;

import com.moomoo.db.HibernateUtil;
import com.moomoo.model.MovieSession;

//Performs all DB operations for the MovieSession object in the DB
public class MovieSessionMapper {
	// Retrieve a MovieSession object that matches the id in the DB
	public static MovieSession retrieveMovieSession(long id) {
		Session sess = HibernateUtil.getSessionFactory().getCurrentSession();
		sess.beginTransaction();
		return (MovieSession) sess.get(MovieSession.class, id);	
	}
}
