package com.packt.movie.service;

import java.sql.SQLException;

public class AppMain {
public static void main(String[] args) {
	MovieImplService movieImplService = new MovieImplService();
	try {
		movieImplService.getMovieList("2016-02-20");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
