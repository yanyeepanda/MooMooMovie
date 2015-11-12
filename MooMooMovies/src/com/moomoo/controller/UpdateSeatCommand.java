package com.moomoo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import com.moomoo.helper.TicketHelper;
import com.moomoo.model.Seat;
import com.moomoo.model.Ticket;

// Updates ticket with new chosen seat
public class UpdateSeatCommand extends FrontCommand{

	@Override
	public void process() throws ServletException, IOException {
		// Find new selected seat object
		long id = Long.valueOf(request.getParameter("seat").replace(" ", ""));
		Seat newSeat = Seat.findById(id);

		// Get ticket specified in previous command and update ticket
		HttpSession session = request.getSession();
		Ticket ticket = (Ticket) session.getAttribute("ticket");
		ticket.changeSeat(newSeat);
		
		// Display updated ticket to user
		TicketHelper helper = new TicketHelper(ticket);
		session.setAttribute("helper", helper);
		forward("/ticket.jsp");
	}

}
