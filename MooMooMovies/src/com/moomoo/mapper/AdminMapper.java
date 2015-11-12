package com.moomoo.mapper;

import org.hibernate.Session;

import com.moomoo.db.HibernateUtil;
import com.moomoo.model.Admin;

// Mapper for the Admin class
public class AdminMapper {
	// Retreives an admin from the DB by username
	public static Admin retrieveAdmin(String username) {
		Session sess = HibernateUtil.getSessionFactory().getCurrentSession();
		sess.beginTransaction();
		return (Admin) sess.get(Admin.class, username);
	}
}
