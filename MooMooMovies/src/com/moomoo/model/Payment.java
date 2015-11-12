package com.moomoo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

// Represents payment details for a ticket
@Entity
public class Payment {
	private long paymentId;
	private Ticket ticket;
	private String cardNumber;
	private String accountName;
	private String expiryDate;
	private String securityPin;
	
	public Payment() {}

	@Id
	@GeneratedValue
	@Column(name="paymentId_PK")
	public long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}

	// Eager loading can be used here since the relationship is one-to-one
	// and doesn't greatly increase the work required to retrieve this object
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="ticket_FK")
	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getSecurityPin() {
		return securityPin;
	}

	public void setSecurityPin(String securityPin) {
		this.securityPin = securityPin;
	}
	
	// Make shift validation method for payment details
	// May be extended to a module dealing with finances
	public static boolean validatePayment(String cardNumber, String accountName, String expiryDate, String securityPin) {
		if (cardNumber.length() != 0 && accountName.length() != 0 && expiryDate.length() != 0 && securityPin.length() != 0) {
			return true;
		}
		return false;
	}
}
