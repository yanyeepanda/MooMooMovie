package com.moomoo.mapper;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.moomoo.db.HibernateUtil;
import com.moomoo.model.Cinema;
import com.moomoo.model.Ticket;

//Performs all DB operations for the Ticket object in the DB
public class TicketMapper {
	// Retrieve a Ticket object that matches the id in the DB
	public static Ticket retrieveTicket(long id) {
		Session sess = HibernateUtil.getSessionFactory().getCurrentSession();
		sess.beginTransaction();
		return (Ticket) sess.get(Ticket.class, id);	
	}
	
	// Updates the Ticket object in the DB
	public static void updateTicket(Ticket ticket) {
		Session sess = HibernateUtil.getSessionFactory().getCurrentSession();
		sess.beginTransaction();
		sess.saveOrUpdate(ticket);
		sess.getTransaction().commit();
	}
	
	// Delete the Ticket object in the DB
	public static void deleteTicket(Ticket ticket) {
		Session sess = HibernateUtil.getSessionFactory().getCurrentSession();
		sess.beginTransaction();
		sess.delete(ticket);
		sess.getTransaction().commit();
	}
	
	// Inserts a new Ticket object into the DB
	public static void insertTicket(Ticket ticket) {
		Session sess = HibernateUtil.getSessionFactory().getCurrentSession();
		sess.beginTransaction();
		sess.save(ticket);
		sess.getTransaction().commit();
	}
	
	// Retrive all tickets with requested refunds
	public static ArrayList<Ticket> retrieveRefundTickets(){
		Session sess = HibernateUtil.getSessionFactory().getCurrentSession();
		sess.beginTransaction();
		Criteria crit = sess.createCriteria(Ticket.class);
		crit.add( Restrictions.eq("refundRequest", true));
		List<Ticket> tickets = crit.list();
		return (ArrayList<Ticket>) tickets;
	}
}
