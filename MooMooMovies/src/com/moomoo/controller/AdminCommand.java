package com.moomoo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import com.moomoo.helper.AdminHelper;
import com.moomoo.helper.MovieSessionHelper;
import com.moomoo.helper.TicketHelper;
import com.moomoo.model.Admin;
import com.moomoo.model.AuthenticationEnforcer;
import com.moomoo.model.RequestContext;
import com.moomoo.model.Ticket;

// Command to go to admin page
public class AdminCommand extends FrontCommand{

	@Override
	public void process() throws ServletException, IOException {
		// If admin already in session, user is logged in
		HttpSession session = request.getSession();
		AdminHelper helper = (AdminHelper) session.getAttribute("admin");
		
		// If looged in, update refundList and display admin page
		if (helper != null) {
			List<TicketHelper> refundList = TicketHelper.createRefundList();
			session.setAttribute("refunds", refundList);
			forward("/admin.jsp");
			
		// If not yet logged in process login form
		}else {
			// Process login
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			RequestContext loginRequest = new RequestContext(username, password);
			Admin admin = AuthenticationEnforcer.validateCredentials(loginRequest);

			if (admin!=null) {
				// Save admin to session
				helper = new AdminHelper(admin);
				List<TicketHelper> refundList = TicketHelper.createRefundList();
				session.setAttribute("refunds", refundList);
				session.setAttribute("admin", helper);
				forward("/admin.jsp");
			} else {
				// Login failed
				String errorMessage = "Login credentials are not valid";
				session.setAttribute("error", errorMessage);
				forward("/error.jsp");
			}
		}
	}

}
