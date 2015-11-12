package com.moomoo.helper;

import java.util.ArrayList;
import java.util.List;

import com.moomoo.model.Ticket;

// Helper for Ticket class for JSP pages
public class TicketHelper {
	private Ticket ticket;
	
	public TicketHelper(Ticket ticket) {
		this.ticket = ticket;
	}
	
	// Get ticket id
	public long getTicketId() {
		return ticket.getTicketId();
	}
	
	// Get cinema location of ticket
	public String getLocation() {
		return ticket.getSeat().getSession().getMovie().getCinema().getAddress();
	}
	
	// Get movie title for ticket
	public String getMovieTitle() {
		return ticket.getSeat().getSession().getMovie().getTitle();
	}
	
	// Get time for ticket
	public String getMovieTime() {
		return ticket.getSeat().getSession().getTime().toString();
	}
	
	// Get seat label for ticket
	public String getSeatLabel() {
		return ticket.getSeat().getSeatLabel();
	}

	// Get list of TicketHelper with refund requests
	public static List<TicketHelper> createRefundList() {
		List<Ticket> refunds = Ticket.retrieveRefundList();
		List<TicketHelper> helperList = new ArrayList<TicketHelper>();
		for(Ticket refund : refunds) {
			helperList.add(new TicketHelper(refund));
		}
		return helperList;
	}
}
