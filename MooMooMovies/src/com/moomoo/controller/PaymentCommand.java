package com.moomoo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import com.moomoo.helper.TicketHelper;
import com.moomoo.model.Payment;
import com.moomoo.model.Seat;
import com.moomoo.model.Ticket;

// Retrieves payment information from form and creates a new ticket
public class PaymentCommand extends FrontCommand{

	@Override
	public void process() throws ServletException, IOException {
		// Retrieve payment details
		String cardNumber = request.getParameter("cardNumber");
		String accountName = request.getParameter("accountName");
		String expiryDate = request.getParameter("expiryDate");
		String securityPin = request.getParameter("securityPin");

		HttpSession session = request.getSession();
		if (Payment.validatePayment(cardNumber, accountName, expiryDate, securityPin)) {
			// If payment is valid make new ticket and display to user
			Seat seat = (Seat) session.getAttribute("seat");
			Ticket ticket = Ticket.buyTicket(seat, cardNumber, accountName, expiryDate, securityPin);
			TicketHelper helper = new TicketHelper(ticket);
			session.setAttribute("helper", helper);
			forward("/ticket.jsp");			
		} else {
			// If invalid payment display error
			session = request.getSession();
			String errorMessage = "Invalid payment details";
			session.setAttribute("error", errorMessage);
			forward("/error.jsp");
		}

	}

}
