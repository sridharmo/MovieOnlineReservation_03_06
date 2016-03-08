package com.packt.movie.model;

import java.io.File;
import java.util.Date;
import java.util.Set;

import org.springframework.web.multipart.MultipartFile;






public class MovieList {
//	public Date movieDate1;
	public String movieDate;
	public Integer movieID;
	public String movieName;
	public Integer movieDuration;
	
	private MultipartFile  movieImage;
	//private File movieImage;
	private String movieImageFileName;
	
	private Integer show1;
	private Integer show2;
	private Integer show3;
	private Integer PriceID;
	private TimeInfo timeInfo;
	
	
	public TimeInfo getTimeInfo() {
		return timeInfo;
	}

	public void setTimeInfo(TimeInfo timeInfo) {
		this.timeInfo = timeInfo;
	}

	public String getMovieDate() {
		return movieDate;
	}
	
	public void setMovieDate(String movieDate) {
		this.movieDate = movieDate;
	}
	public Integer getMovieID() {
		return movieID;
	}
	public void setMovieID(Integer movieID) {
		this.movieID = movieID;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public Integer getMovieDuration() {
		return movieDuration;
	}
	public void setMovieDuration(Integer movieDuration) {
		this.movieDuration = movieDuration;
	}
	public MultipartFile getMovieImage() {
		return movieImage;
	}
	public void setMovieImage(MultipartFile movieImage) {
		this.movieImage = movieImage;
	}
	public String getMovieImageFileName() {
		return movieImageFileName;
	}
	public void setMovieImageFileName(String movieImageFileName) {
		this.movieImageFileName = movieImageFileName;
	}
	public Integer getShow1() {
		return show1;
	}
	public void setShow1(Integer show1) {
		this.show1 = show1;
	}
	public Integer getShow2() {
		return show2;
	}
	public void setShow2(Integer show2) {
		this.show2 = show2;
	}
	public Integer getShow3() {
		return show3;
	}
	public void setShow3(Integer show3) {
		this.show3 = show3;
	}
	public Integer getPriceID() {
		return PriceID;
	}
	public void setPriceID(Integer priceID) {
		PriceID = priceID;
	}

	
	
	
	
}
