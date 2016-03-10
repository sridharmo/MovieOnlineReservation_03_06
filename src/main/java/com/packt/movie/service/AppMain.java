package com.packt.movie.service;

import java.sql.SQLException;

import com.packt.movie.model.PurchaseInfo;

public class AppMain {
public static void main(String[] args) {
	MovieImplService movieImplService = new MovieImplService();
	/*try {
		movieImplService.getMovieList("2016-02-20");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
/*	Integer ticketPrice = movieImplService.getTicketPrice(2, 2);
	System.out.println("TicketPrice="+ticketPrice);*/
	PurchaseInfo purchaseInfo = new PurchaseInfo();
	purchaseInfo.setMovieID(2);
	purchaseInfo.setTicketPrice(10);
	purchaseInfo.setTimeID(2);
	purchaseInfo.setNumberOfMovieTickets(1);
	String purchased = movieImplService.upDatePurchase( purchaseInfo);
			System.out.println("Purchased or not? ="+purchased);
}
}
