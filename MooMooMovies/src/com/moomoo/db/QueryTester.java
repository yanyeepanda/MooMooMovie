package com.moomoo.db;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.moomoo.model.Admin;
import com.moomoo.model.Cinema;
import com.moomoo.model.Movie;
import com.moomoo.model.MovieSession;
import com.moomoo.model.Payment;
import com.moomoo.model.Seat;
import com.moomoo.model.Ticket;

// Dummy file for testing hibernate functions.
// Unused by application
public class QueryTester {
	public static void main(String[] args) {

		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(Cinema.class);
		config.addAnnotatedClass(Movie.class);
		config.addAnnotatedClass(MovieSession.class);
		config.addAnnotatedClass(Seat.class);
		config.addAnnotatedClass(Ticket.class);
		config.addAnnotatedClass(Payment.class);
		config.addAnnotatedClass(Admin.class);
		config.configure();

		SessionFactory factory = config.buildSessionFactory();
		Session sess = factory.getCurrentSession();
		sess.beginTransaction();
		Movie movie = (Movie) sess.get(Movie.class, 32768L);
		sess.getTransaction().commit();
		
		System.out.println(movie.getTags());
		for(String tag : movie.getTags()) {
			System.out.println(tag);
		}

	}
}
