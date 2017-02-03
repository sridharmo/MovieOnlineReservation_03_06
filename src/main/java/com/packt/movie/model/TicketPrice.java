package com.packt.movie.model;

public class TicketPrice {
	public Integer ticketPriceID;
	public Integer ticketPrice;
	public Integer movieID;
	public Integer timeID;
	public Integer getTicketPriceID() {
		return ticketPriceID;
	}
	public void setTicketPriceID(Integer ticketPriceID) {
		this.ticketPriceID = ticketPriceID;
	}
	public Integer getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(Integer ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	
	public Integer getMovieID() {
		return movieID;
	}
	public void setMovieID(Integer movieID) {
		this.movieID = movieID;
	}
	public Integer getTimeID() {
		return timeID;
	}
	public void setTimeID(Integer timeID) {
		this.timeID = timeID;
	}
	
}
