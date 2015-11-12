package com.moomoo.mapper;

import org.hibernate.Session;

import com.moomoo.db.HibernateUtil;
import com.moomoo.model.Payment;

//Performs all DB operations for the Payment object in the DB
public class PaymentMapper {
	// Retrieve a Payment object that matches the id in the DB
	public static Payment retrievePayment(long id) {
		Session sess = HibernateUtil.getSessionFactory().getCurrentSession();
		sess.beginTransaction();
		return (Payment) sess.get(Payment.class, id);	
	}
	
	// Inserts a new Payment object into the DB
	public static void insertPayment(Payment payment) {
		Session sess = HibernateUtil.getSessionFactory().getCurrentSession();
		sess.beginTransaction();
		sess.save(payment);
		sess.getTransaction().commit();
	}
	
	// Delete the Payment object in the DB
	public static void deletePayment(Payment payment) {
		Session sess = HibernateUtil.getSessionFactory().getCurrentSession();
		sess.beginTransaction();
		sess.delete(payment);
		sess.getTransaction().commit();
	}
}
