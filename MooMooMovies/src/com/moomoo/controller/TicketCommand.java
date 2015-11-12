package com.moomoo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import com.moomoo.helper.TicketHelper;
import com.moomoo.model.Ticket;

// Retrieves ticket and displays to user
public class TicketCommand extends FrontCommand{

	@Override
	public void process() throws ServletException, IOException {
		HttpSession session;
		try {
			// Find ticket in DB
			long ticketId = Long.valueOf(request.getParameter("ticketId").replace(" ", ""));
			Ticket ticket = Ticket.findById(ticketId);

			// Display ticket to user
			TicketHelper helper = new TicketHelper(ticket);
			session = request.getSession();
			session.setAttribute("helper", helper);
			forward("/ticket.jsp");
		} catch(Exception e) {
			// If ticket not found display error
			session = request.getSession();
			String errorMessage = "Invalid ticket Id";
			session.setAttribute("error", errorMessage);
			forward("/error.jsp");
		}
	}

}
