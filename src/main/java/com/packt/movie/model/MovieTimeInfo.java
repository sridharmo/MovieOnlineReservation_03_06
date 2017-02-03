package com.packt.movie.model;

import java.sql.Time;

public class MovieTimeInfo {
	private int timeID;
	private Time movieTime;
	private String recordStatus;
	public int getTimeID() {
		return timeID;
	}
	public void setTimeID(int timeID) {
		this.timeID = timeID;
	}
	public Time getMovieTime() {
		return movieTime;
	}
	public void setMovieTime(Time movieTime) {
		this.movieTime = movieTime;
	}
	public String getRecordStatus() {
		return recordStatus;
	}
	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}
	
}
