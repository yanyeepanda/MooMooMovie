package com.moomoo.db;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.moomoo.model.Admin;
import com.moomoo.model.Cinema;
import com.moomoo.model.Movie;
import com.moomoo.model.MovieSession;
import com.moomoo.model.Payment;
import com.moomoo.model.Seat;
import com.moomoo.model.Ticket;

/**
 * Utilities to use hibernate functions.
 * Application uses this to integrate hibernate
 * Based on code from https://dev.vaadin.com/svn/incubator/features/src/com/vaadin/compare/HibernateUtil.java
 */
public class HibernateUtil {

	private static final SessionFactory sessionFactory;

	static {
		try {
			AnnotationConfiguration config = new AnnotationConfiguration();
			config.addAnnotatedClass(Cinema.class);
			config.addAnnotatedClass(Movie.class);
			config.addAnnotatedClass(MovieSession.class);
			config.addAnnotatedClass(Seat.class);
			config.addAnnotatedClass(Ticket.class);
			config.addAnnotatedClass(Payment.class);
			config.addAnnotatedClass(Admin.class);
			config.configure();
			
			// CreateSessionFactory
			sessionFactory = config.buildSessionFactory();
			
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}

	/**
	 * Get our sessionfactory.
	 * 
	 * @return SessionFactory
	 */
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}