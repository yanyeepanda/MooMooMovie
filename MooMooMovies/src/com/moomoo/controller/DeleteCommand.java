package com.moomoo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import com.moomoo.helper.AdminHelper;
import com.moomoo.helper.TicketHelper;
import com.moomoo.model.Admin;
import com.moomoo.model.AuthenticationEnforcer;
import com.moomoo.model.RequestContext;
import com.moomoo.model.Ticket;

// Command to delete ticket
public class DeleteCommand extends FrontCommand{

	@Override
	public void process() throws ServletException, IOException {
		// Process refund based on refund parameter
		boolean refund = Boolean.parseBoolean(request.getParameter("refund"));
		long id = Long.valueOf(request.getParameter("ticketID").replace(" ", ""));
		Ticket ticket = Ticket.findById(id);
		if (refund) {
			ticket.deleteTicket();
		} else {
			ticket.declineRefund();
		}
		forward("/refund_success.jsp");
	}

}
