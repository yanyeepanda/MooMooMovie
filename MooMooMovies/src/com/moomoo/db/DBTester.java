package com.moomoo.db;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.moomoo.model.Admin;
import com.moomoo.model.Cinema;
import com.moomoo.model.Movie;
import com.moomoo.model.MovieSession;
import com.moomoo.model.Payment;
import com.moomoo.model.Seat;
import com.moomoo.model.Ticket;

// Setup file for DB.  Run this to seed dummy data in DB
public class DBTester {
	public static void main(String[] args) {

		// Add tables
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(Cinema.class);
		config.addAnnotatedClass(Movie.class);
		config.addAnnotatedClass(MovieSession.class);
		config.addAnnotatedClass(Seat.class);
		config.addAnnotatedClass(Ticket.class);
		config.addAnnotatedClass(Payment.class);
		config.addAnnotatedClass(Admin.class);
		config.configure();

		// Drop old schema and add new one
		new SchemaExport(config).create(true, true);

		SessionFactory factory = config.buildSessionFactory();
		Session sess = factory.getCurrentSession();
		sess.beginTransaction();
		
		// Create Dummy Cinemas
		Cinema test1 = new Cinema();
		test1.setAddress("Melbourne Central");
		test1.setMovieList(new ArrayList<Movie>());
		Cinema test2 = new Cinema();
		test2.setAddress("Doncaster");
		test2.setMovieList(new ArrayList<Movie>());
		
		// Create Dummy Movies
		Movie movie1 = new Movie();
		movie1.setRating("PG");
		movie1.setTitle("Shrek");
		movie1.setTags(new String[0]);
		movie1.addTag("family");
		movie1.addTag("comedy");
		movie1.setSessionList(new ArrayList<MovieSession>());
		Movie movie2 = new Movie();
		movie2.setRating("M");
		movie2.setTitle("Yanyi's Movie");
		movie2.setTags(new String[0]);
		movie2.addTag("comedy");
		movie2.addTag("drama");
		movie2.setSessionList(new ArrayList<MovieSession>());
		Movie movie3 = new Movie();
		movie3.setRating("M");
		movie3.setTitle("Harry Potter");
		movie3.setTags(new String[0]);
		movie3.addTag("family");
		movie3.addTag("fantasy");
		movie3.setSessionList(new ArrayList<MovieSession>());

		test1.addMovie(movie1);
		test1.addMovie(movie2);
		test2.addMovie(movie3);
		
		// Create Dummy Sessions
		Calendar cal = Calendar.getInstance();
		MovieSession sess1 = new MovieSession();
		sess1.setTime(cal.getTime());
		cal.add(Calendar.HOUR, 1);
		MovieSession sess2 = new MovieSession();
		sess2.setTime(cal.getTime());
		MovieSession sess3 = new MovieSession();
		sess3.setTime(cal.getTime());
		MovieSession sess4 = new MovieSession();
		sess4.setTime(cal.getTime());
		
		movie1.addSession(sess1);
		movie1.addSession(sess2);
		movie2.addSession(sess3);
		movie3.addSession(sess4);
		
		// Create list of seats for each session
		List<Seat> seats1 = createSessionSeats(sess1);
		sess1.setSeatList(seats1);
		List<Seat> seats2 = createSessionSeats(sess2);
		sess2.setSeatList(seats2);
		List<Seat> seats3 = createSessionSeats(sess3);
		sess3.setSeatList(seats3);
		List<Seat> seats4 = createSessionSeats(sess4);
		sess4.setSeatList(seats4);
		
		// Create admin user
		Admin admin = new Admin();
		admin.setUsername("admin");
		admin.setPassword("admin");
		
		// Save the data and commit
		sess.save(test1);
		sess.save(test2);
		sess.save(movie1);
		sess.save(movie2);
		sess.save(movie3);
		sess.save(sess1);
		sess.save(sess2);
		sess.save(sess3);
		sess.save(sess4);
		sess.save(admin);
		sess.getTransaction().commit();
	}
	
	// Creates a list of seats for a session
	private static List<Seat> createSessionSeats(MovieSession session) {
		List<Seat> seats = new ArrayList<Seat>();
		
		Seat seat1 = new Seat();
		seat1.setSeatLabel("A1");
		seat1.setSession(session);
		Seat seat2 = new Seat();
		seat2.setSeatLabel("A2");
		seat2.setSession(session);
		Seat seat3 = new Seat();
		seat3.setSeatLabel("B1");
		seat3.setSession(session);
		Seat seat4 = new Seat();
		seat4.setSeatLabel("B2");
		seat4.setSession(session);
		
		seats.add(seat1);
		seats.add(seat2);
		seats.add(seat3);
		seats.add(seat4);
		
		return seats;
	}
}
