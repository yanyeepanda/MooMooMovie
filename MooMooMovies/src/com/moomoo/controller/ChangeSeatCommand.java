package com.moomoo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import com.moomoo.helper.MovieSessionHelper;
import com.moomoo.model.MovieSession;
import com.moomoo.model.Ticket;

//Opens to screen to select new seat for ticket
public class ChangeSeatCommand extends FrontCommand{

	@Override
	public void process() throws ServletException, IOException {
		// Retrieve ticket to change seat for
		long id = Long.valueOf(request.getParameter("ticketId").replace(" ", ""));
		Ticket ticket = Ticket.findById(id);
		
		// Treat same as selecting seat when purchasing ticket
		MovieSessionHelper helper = new MovieSessionHelper(ticket.getSeat().getSession());
		HttpSession session = request.getSession();
		
		// Save ticket so UpdateSeat command knows which ticket to change
		session.setAttribute("ticket", ticket);
		session.setAttribute("command", "UpdateSeat");
		session.setAttribute("helper", helper);
		forward("/movie_session.jsp");
	}

}
