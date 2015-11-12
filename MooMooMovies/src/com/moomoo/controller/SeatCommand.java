package com.moomoo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.moomoo.model.Seat;

// Get selected seat and go to payment form
public class SeatCommand extends FrontCommand{

	@Override
	public void process() throws ServletException, IOException {
		// Find seat object
		long id = Long.valueOf(request.getParameter("seat").replace(" ", ""));
		Seat seat = Seat.findById(id);

		// Save seat to session to save for ticket in next command
		HttpSession session = request.getSession();
		session.setAttribute("seat", seat);
		forward("/payment.jsp");	
	}

}
