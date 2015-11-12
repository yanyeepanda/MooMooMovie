package com.moomoo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.moomoo.mapper.SeatMapper;

// Represents a seat in a movie
@Entity
public class Seat {
	private long seatId;
	private MovieSession session;
	private Ticket ticket = null;
	private boolean taken = false;
	private String seatLabel;
	
	public Seat() {}

	@Id
	@GeneratedValue
	@Column(name="seatId_PK")
	public long getSeatId() {
		return seatId;
	}

	public void setSeatId(long seatId) {
		this.seatId = seatId;
	}

	@ManyToOne
	@JoinColumn(name="session_id")
	public MovieSession getSession() {
		return session;
	}

	public void setSession(MovieSession session) {
		this.session = session;
	}

	// Since this is only one-to-one relationship we can use
	// eager loading without it having an impact
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="ticket_FK")
	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public boolean isTaken() {
		return taken;
	}

	public void setTaken(boolean taken) {
		this.taken = taken;
	}

	public String getSeatLabel() {
		return seatLabel;
	}

	public void setSeatLabel(String seatLabel) {
		this.seatLabel = seatLabel;
	}
	
	// Returns a Seat object with the given id
	public static Seat findById(long seatId) {
		return SeatMapper.retrieveSeat(seatId);
	}
	
	
}
