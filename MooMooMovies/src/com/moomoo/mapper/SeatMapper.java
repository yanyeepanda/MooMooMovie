package com.moomoo.mapper;

import org.hibernate.Session;

import com.moomoo.db.HibernateUtil;
import com.moomoo.model.Seat;
import com.moomoo.model.Ticket;

//Performs all DB operations for the Seat object in the DB
public class SeatMapper {
	// Retrieve a Payment object that matches the id in the DB
	public static Seat retrieveSeat(long id) {
		Session sess = HibernateUtil.getSessionFactory().getCurrentSession();
		sess.beginTransaction();
		return (Seat) sess.get(Seat.class, id);	
	}
	
	// Updates the Payment object in the DB
	public static void updateSeat(Seat seat) {
		Session sess = HibernateUtil.getSessionFactory().getCurrentSession();
		sess.beginTransaction();
		sess.saveOrUpdate(seat);
		sess.getTransaction().commit();
	}
}
