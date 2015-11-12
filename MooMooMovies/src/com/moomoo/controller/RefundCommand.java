package com.moomoo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import com.moomoo.model.Ticket;

// Refunds ticket for customer
public class RefundCommand extends FrontCommand{

	@Override
	public void process() throws ServletException, IOException {
		// Retrieve ticket from DB
		long ticketId = Long.valueOf(request.getParameter("ticketId").replace(" ", ""));
		Ticket ticket = Ticket.findById(ticketId);

		HttpSession session = request.getSession();
		ticket.requestRefund();
		// Display success page to user
		forward("/refund_request.jsp");
	}

}
