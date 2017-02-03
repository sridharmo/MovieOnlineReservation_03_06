package com.packt.movie.model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import javax.persistence.JoinColumn;
public class TimeInfo {
	public Integer timeID;
	public Time movieTime;
	public String recordStatus;
	
	public List<MovieList> movieList = new ArrayList<MovieList>();
	public Integer getTimeID() {
		return timeID;
	}
	public void setTimeID(Integer timeID) {
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
	
	
	
	public List<MovieList> getMovieList() {
		return movieList;
	}
	public void setMovieList(List<MovieList> movieList) {
		this.movieList = movieList;
	}
	
	
	
	
}
