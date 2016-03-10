package com.packt.movie.model;

public class MovieCart {
	
	public int MovieID;
	public String movieName;
	public int timeID;
	public int numberOfTickets;
	public int tiketPrice;
	public int UserID;
	public int PurhaseID;
	public int getMovieID() {
		return MovieID;
	}
	public void setMovieID(int movieID) {
		MovieID = movieID;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public int getTimeID() {
		return timeID;
	}
	public void setTimeID(int timeID) {
		this.timeID = timeID;
	}
	public int getNumberOfTickets() {
		return numberOfTickets;
	}
	public void setNumberOfTickets(int numberOfTickets) {
		this.numberOfTickets = numberOfTickets;
	}
	public int getTiketPrice() {
		return tiketPrice;
	}
	public void setTiketPrice(int tiketPrice) {
		this.tiketPrice = tiketPrice;
	}
	public int getUserID() {
		return UserID;
	}
	public void setUserID(int userID) {
		UserID = userID;
	}
	public int getPurhaseID() {
		return PurhaseID;
	}
	public void setPurhaseID(int purhaseID) {
		PurhaseID = purhaseID;
	}
	
}
