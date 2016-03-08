package com.packt.movie.model;

import java.sql.Time;

public class TimeInfo {
	public Integer TimeID;
	public Time MovieTime;
	public String RecordStatus;
	public Integer getTimeID() {
		return TimeID;
	}
	public void setTimeID(Integer timeID) {
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
