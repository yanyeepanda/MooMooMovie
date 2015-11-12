package com.moomoo.mapper;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.moomoo.db.HibernateUtil;
import com.moomoo.model.Cinema;

// Performs DB operations for the Cinema class
public class CinemaMapper {
	// Retrieves a list of all Cinema objects in the DB
	public static ArrayList<Cinema> retrieveCinemaList(){
		Session sess = HibernateUtil.getSessionFactory().getCurrentSession();
		sess.beginTransaction();
		Query query = sess.createQuery("from Cinema");
		List<Cinema> cinemas = query.list();
		return (ArrayList<Cinema>) cinemas;
	}
	
	// Retreives a single Cinema object matching the id in the DB
	public static Cinema retrieveCinema(long id) {
		Session sess = HibernateUtil.getSessionFactory().getCurrentSession();
		sess.beginTransaction();
		return (Cinema) sess.get(Cinema.class, id);
	}
}
