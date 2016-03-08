package com.packt.movie.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value =HttpStatus.NOT_FOUND, reason = "No movie found for this date")
public class NoMovieFoundException extends RuntimeException {
	private String movieDate;
	private static final long serialVersionUID =3935230281455340039L;
	public NoMovieFoundException(String movieDate){
		this.movieDate = movieDate;
	}
	public String getMovieDate(){
		return movieDate;
	}
}
