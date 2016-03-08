package com.packt.movie.model;

import java.sql.Time;

public class MovieTimeInfo {
	private int TimeID;
	private Time MovieTime;
	private String RecordStatus;
	public int getTimeID() {
		return TimeID;
	}
	public void setTimeID(int timeID) {
		TimeID = timeID;
	}
	
	public Time getMovieTime() {
		return MovieTime;
	}
	public void setMovieTime(Time movieTime) {
		MovieTime = movieTime;
	}
	public String getRecordStatus() {
		return RecordStatus;
	}
	public void setRecordStatus(String recordStatus) {
		RecordStatus = recordStatus;
	}
	
	
}
