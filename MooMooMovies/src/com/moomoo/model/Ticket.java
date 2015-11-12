package com.moomoo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.moomoo.mapper.PaymentMapper;
import com.moomoo.mapper.SeatMapper;
import com.moomoo.mapper.TicketMapper;

// Represents a ticket for a movie
@Entity
public class Ticket {
	private long ticketId;
	private Seat seat;
	private Payment payment;
	private boolean refundRequest = false;
	
	public Ticket() {}

	@Id
	@GeneratedValue
	@Column(name="ticketId_PK")
	public long getTicketId() {
		return ticketId;
	}

	public void setTicketId(long ticketId) {
		this.ticketId = ticketId;
	}

	// Since this is only one-to-one relationship we can use
	// eager loading without it having an impact
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="seat_FK")
	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	// Since this is only one-to-one relationship we can use
	// eager loading without it having an impact
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="payment_FK")
	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	// Creates a new ticket that has been paid for
	public static Ticket buyTicket(Seat seat, String cardNumber, String accountName, String expiryDate, String securityPin) {
		Ticket ticket = new Ticket();
		
		// Create the payment associated with ticket
		Payment payment = new Payment();
		payment.setAccountName(accountName);
		payment.setCardNumber(cardNumber);
		payment.setExpiryDate(expiryDate);
		payment.setSecurityPin(securityPin);
		payment.setTicket(ticket);
		
		ticket.setPayment(payment);
		ticket.setSeat(seat);
		
		seat.setTicket(ticket);
		seat.setTaken(true);
		
		// Thanks to Hibernate updating a ticket in the DB also
		// updates all other objects associated with it
		// Therefore other mappers do not need to be called and
		// in fact can result in duplicate entries and actions
		TicketMapper.insertTicket(ticket);
		return ticket;
	}
	
	// Returns a Ticket object with the given id
	public static Ticket findById(long id){
		return TicketMapper.retrieveTicket(id);
	}
	
	// Removes the ticket from the DB
	public void deleteTicket(){
		// Seat also needs to be updated as well as ticket
		Seat seat = this.getSeat();
		seat.setTaken(false);
		seat.setTicket(null);
		this.setSeat(null);
		
		// As seat is no longer associated with ticket it
		// will not be automatically updated and its mapper
		// needs to be called
		SeatMapper.updateSeat(seat);
		TicketMapper.deleteTicket(this);
	}
	
	// Requests a refund for that ticket
	public void requestRefund(){
		this.refundRequest = true;
		TicketMapper.updateTicket(this);
	}

	// Denies a refund request for that ticket
	public void declineRefund(){
		this.refundRequest = false;
		TicketMapper.updateTicket(this);
	}	
	
	// Change ticket's seat to the new seat passed
	public void changeSeat(Seat newSeat) {
		Seat oldSeat = this.seat;
		oldSeat.setTaken(false);
		oldSeat.setTicket(null);
		this.seat = newSeat;
		newSeat.setTaken(true);
		newSeat.setTicket(this);
		
		// As  old seat is no longer associated with ticket it
		// will not be automatically updated and its mapper
		// needs to be called
		TicketMapper.updateTicket(this);
		SeatMapper.updateSeat(oldSeat);
	}

	public boolean isRefundRequest() {
		return refundRequest;
	}

	public void setRefundRequest(boolean refundRequest) {
		this.refundRequest = refundRequest;
	}

	// Get list of tickets with a refund request
	public static List<Ticket> retrieveRefundList() {
		return TicketMapper.retrieveRefundTickets();
	}
}
