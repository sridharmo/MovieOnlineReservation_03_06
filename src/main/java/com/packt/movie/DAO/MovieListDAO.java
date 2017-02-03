package com.packt.movie.DAO;

import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

import org.hibernate.HibernateException;


import org.hibernate.Transaction;
import org.hibernate.Session;

import com.packt.movie.model.MovieList;
import com.packt.movie.model.NewUser;
import com.packt.movie.model.PurchaseInfo;
import com.packt.movie.model.Seats;
import com.packt.movie.model.TicketPrice;
import com.packt.movie.service.HibernateConfig;

public class MovieListDAO {
	static Session session = null;
	Transaction transaction = null;
	
	public MovieList getMovieListByMovieID(Integer movieID){
		MovieList movieList = null;
		try{
			String hql = "FROM MovieList M WHERE M.movieID ='" + movieID + "'";
		
			session = HibernateConfig.sessionFactory.openSession();
			List results = (List) session.createQuery(hql).list();
			// if(results.size()>0)
			Iterator<MovieList> iterator = results.iterator();
			iterator.hasNext();
			movieList = (MovieList) iterator.next();
		}catch(HibernateException e){
				e.printStackTrace();
		}finally{
				session.close();
		}
		return movieList;	
	}
	
	@SuppressWarnings("unchecked")
	public List<MovieList> getMovieList(String sqlDate) throws SQLException {
		List<MovieList> results = new ArrayList<MovieList>();

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		
		
		System.out.println("sqlDate=" + sqlDate);
		try{
		String hql = "FROM MovieList M WHERE M.movieDate ='" + sqlDate + "'";
		session = HibernateConfig.sessionFactory.openSession();
		
		results = (List<MovieList>) session.createQuery(hql).list();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			System.out.println("Cache statstics hit count= "+HibernateConfig.sessionFactory.getStatistics().getSecondLevelCacheHitCount());
			System.out.println("Cache statstics miss count= "+HibernateConfig.sessionFactory.getStatistics().getSecondLevelCacheMissCount());
			//System.out.println("second level statstics = "+HibernateConfig.sessionFactory.getStatistics().getSecondLevelCacheStatistics("movieList").getHitCount());
			//System.out.println("second level statstics = "+HibernateConfig.sessionFactory.getStatistics().getSecondLevelCacheStatistics("movieList").getPutCount());
			//System.out.println("second level statstics = "+HibernateConfig.sessionFactory.getStatistics().getSecondLevelCacheStatistics("movieList").getElementCountInMemory());

			if(session != null)
				session.close();
		}
		return results;

	}
	
	public Integer getTicketPrice(Integer movieID, Integer timeID ){
		Integer ticketPrice = null;
		try{
		session = HibernateConfig.sessionFactory.openSession();
		String hql = "FROM TicketPrice T WHERE T.movieID='"+movieID+"'"+"AND T.timeID='"+timeID+"'";
		List results = (List) session.createQuery(hql).list();
		if(results.size() >0){
			Iterator itr = results.iterator();
			
			TicketPrice Price = (TicketPrice) itr.next();
			ticketPrice =Price.getTicketPrice();
		}
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return ticketPrice;
	}

	public String upDatePurchase(PurchaseInfo purchaseInfo) {
		String purchased = null;
		 final ReentrantLock lock = new ReentrantLock();
		try{
			lock.lock();//TODO test locking condition, and is thisright place to put lock.
			System.out.println("upDatePurchase method NumberOfMovieTickets="+purchaseInfo.getNumberOfMovieTickets());
			System.out.println("TicketPrice ="+purchaseInfo.getTicketPrice());
			System.out.println("TransactionStatus =" +purchaseInfo.getTransactionStatus());
			System.out.println("MovieID= "+purchaseInfo.getMovieID());
			session = HibernateConfig.sessionFactory.openSession();
			int movieID = purchaseInfo.getMovieID();
			String hql = "FROM Seats S WHERE S.movieID='"+movieID+"'";
			List results = (List) session.createQuery(hql).list();
			//Transaction transaction = session.beginTransaction();
			if(results.size() >0){
				Iterator itr = results.iterator();				
				Seats seats = (Seats) itr.next();
				System.out.println("Number of Seats available = "+ seats.getNumberOfAvailableSeats());
				if(purchaseInfo.getNumberOfMovieTickets()<= seats.getNumberOfAvailableSeats()){
					Transaction transaction = session.beginTransaction();
					int remainingSeats = seats.getNumberOfAvailableSeats()-purchaseInfo.getNumberOfMovieTickets();
					System.out.println("remainingSeats ="+remainingSeats);
					String hql1 = "Update Seats S set NumberOfAvailableSeats='"+remainingSeats+"'where S.movieID='"+movieID+"'";
					int result = session.createQuery(hql1).executeUpdate();
					System.out.println("purchased Tickets got updated in Seats table ");
					session.save(purchaseInfo);
					transaction.commit();					
					purchased ="Yes";
				}
				else
					purchased ="No";
			}
		}
	catch(HibernateException e){
		transaction.rollback();
		e.printStackTrace();
	}finally{
		session.close();
		lock.unlock();
	}
		System.out.println("purchased staus ="+purchased);
		return purchased;
	}
	public NewUser getUserInfo(String email) {
		NewUser userInfo = null;
		try {
			session = HibernateConfig.sessionFactory.openSession();

			String hql = "FROM NewUser U WHERE U.email='" + email + "'";
			List results = (List) session.createQuery(hql).list();
			if (results.size() > 0) {
				Iterator iterator = results.iterator();
				userInfo = (NewUser) iterator.next();
				System.out.println("email = " + email + "exist in database and password is correct.");

			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return userInfo;
	}
	
	public String getEmailForUserID(Integer userID){
		List<NewUser> newUserList = null ;
		try{
			String email ;
			//String query = "select Email from userinfo where UserID ="+userID+";";
			String hql = "FROM NewUser U WHERE U.userID =" + userID + "";
			
			session = HibernateConfig.sessionFactory.openSession();
			newUserList = (List) session.createQuery(hql).list();
			// if(results.size()>0)
			
		}catch(HibernateException he){
			he.printStackTrace();
		}
		if(newUserList.get(0)!=null)
			return newUserList.get(0).getEmail();
		else
			return "No Email";
	}
	public String RetrievePassWord(String email){
		
		NewUser userInfo = null;
		try {
			session = HibernateConfig.sessionFactory.openSession();

			String hql = "FROM NewUser U WHERE U.email='" + email + "'";
			List results = (List) session.createQuery(hql).list();
			if (results.size() > 0) {
				Iterator iterator = results.iterator();
				userInfo = (NewUser) iterator.next();
				System.out.println("email = " + email + "exist in database and password is correct.");

			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return userInfo.getPassWord();
	}
	
}
