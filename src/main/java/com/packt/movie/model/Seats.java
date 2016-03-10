package com.packt.movie.model;

public class Seats {
	public Integer SeatID;
	public Integer TotalSeats;
	public Integer MovieID;
	public Integer NumberOfAvailableSeats;
	
	public Integer getNumberOfAvailableSeats() {
		return NumberOfAvailableSeats;
	}
	public void setNumberOfAvailableSeats(Integer numberOfAvailableSeats) {
		NumberOfAvailableSeats = numberOfAvailableSeats;
	}
	public Integer getSeatID() {
		return SeatID;
	}
	public void setSeatID(Integer seatID) {
		SeatID = seatID;
	}
	public Integer getTotalSeats() {
		return TotalSeats;
	}
	public void setTotalSeats(Integer totalSeats) {
		TotalSeats = totalSeats;
	}
	public Integer getMovieID() {
		return MovieID;
	}
	public void setMovieID(Integer movieID) {
		MovieID = movieID;
	}

	
}
