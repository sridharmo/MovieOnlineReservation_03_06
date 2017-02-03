package com.packt.movie.model;

import java.sql.Time;

public class PurchaseInfo {
	
	private Integer purchaseId;
	private Integer userID;
	private Integer movieID;
	private Integer numberOfMovieTickets;
	private Integer timeID;
	private Integer transactionStatus;
	private Integer mailSend;
	private Integer ticketPrice;
	public Integer getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(Integer purchaseId) {
		this.purchaseId = purchaseId;
	}
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public Integer getMovieID() {
		return movieID;
	}
	public void setMovieID(Integer movieID) {
		this.movieID = movieID;
	}
	public Integer getNumberOfMovieTickets() {
		return numberOfMovieTickets;
	}
	public void setNumberOfMovieTickets(Integer numberOfMovieTickets) {
		this.numberOfMovieTickets = numberOfMovieTickets;
	}
	
	public Integer getTimeID() {
		return timeID;
	}
	public void setTimeID(Integer timeID) {
		this.timeID = timeID;
	}
	public Integer getTransactionStatus() {
		return transactionStatus;
	}
	public void setTransactionStatus(Integer transactionStatus) {
		this.transactionStatus = transactionStatus;
	}
	public Integer getMailSend() {
		return mailSend;
	}
	public void setMailSend(Integer mailSend) {
		this.mailSend = mailSend;
	}
	public Integer getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(Integer ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	
	
	
	
	
}
