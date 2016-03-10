package com.packt.movie.model;

public class PurchaseInfo {
	
	private Integer PurchaseId;
	private Integer UserID;
	private Integer MovieID;
	private Integer NumberOfMovieTickets;
	private Integer TimeID;
	private Integer TransactionStatus;
	private Integer MailSend;
	private Integer TicketPrice;
	
	public Integer getTicketPrice() {
		return TicketPrice;
	}
	public void setTicketPrice(Integer ticketPrice) {
		TicketPrice = ticketPrice;
	}
	public Integer getPurchaseId() {
		return PurchaseId;
	}
	public void setPurchaseId(Integer purchaseId) {
		PurchaseId = purchaseId;
	}
	public Integer getUserID() {
		return UserID;
	}
	public void setUserID(Integer userID) {
		UserID = userID;
	}
	public Integer getMovieID() {
		return MovieID;
	}
	public void setMovieID(Integer movieID) {
		MovieID = movieID;
	}
	public Integer getNumberOfMovieTickets() {
		return NumberOfMovieTickets;
	}
	public void setNumberOfMovieTickets(Integer numberOfMovieTickets) {
		NumberOfMovieTickets = numberOfMovieTickets;
	}
	public Integer getTimeID() {
		return TimeID;
	}
	public void setTimeID(Integer timeID) {
		TimeID = timeID;
	}
	public Integer getTransactionStatus() {
		return TransactionStatus;
	}
	public void setTransactionStatus(Integer transactionStatus) {
		TransactionStatus = transactionStatus;
	}
	public Integer getMailSend() {
		return MailSend;
	}
	public void setMailSend(Integer mailSend) {
		MailSend = mailSend;
	}
	
}
