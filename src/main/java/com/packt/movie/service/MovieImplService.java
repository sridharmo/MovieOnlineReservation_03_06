package com.packt.movie.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.packt.movie.DAO.MovieListDAO;
import com.packt.movie.model.MovieList;
import com.packt.movie.model.NewUser;
import com.packt.movie.model.PurchaseInfo;

//@Repository
public class MovieImplService {
	/*
	 * @Autowired
	 * 
	 * @Qualifier("dataSource") DataSource dataSource;
	 * 
	 * JdbcTemplate jdbcTemplate;
	 * 
	 * @PostConstruct private void initialize() { setDataSource(dataSource);
	 * //jdbcTemplate = new JdbcTemplate(dataSource); }
	 */
	// static SessionFactory sessionFactory;

	MovieListDAO movieListDAO = null;
	MovieImplService movieImplService =null;
	public MovieImplService() {
		movieListDAO = new MovieListDAO();
		
	}

	public List<MovieList> getMovieList(String sqlDate) throws SQLException {
		return movieListDAO.getMovieList(sqlDate);
	}

	public MovieList getMovieListByMovieID(Integer movieID){
		return movieListDAO.getMovieListByMovieID(movieID);
	}
	public Integer getTicketPrice(Integer movieID, Integer timeID) {
		return movieListDAO.getTicketPrice(movieID, timeID);
	}
	
	public String upDatePurchase(PurchaseInfo purchaseInfo) {
		String purchased = movieListDAO.upDatePurchase(purchaseInfo);
		String isPurchased = "No";
		if(purchased!=null && purchased.equalsIgnoreCase("Yes")){
			String toEmail = movieListDAO.getEmailForUserID(purchaseInfo.getUserID());
			String message = "Purchased ticket for movie ="+purchaseInfo.getMovieID()+"For date ="+purchaseInfo.getTimeID();
			String subject = "Number of Tickets ="+purchaseInfo.getNumberOfMovieTickets();
					
			boolean isEmailSend = SendHTMLEmail(toEmail,  message,subject);
			if(isEmailSend == true)
				isPurchased = "Yes";
			
		}
		return isPurchased;
	}

	public NewUser getUserInfo(String email) {
		return movieListDAO.getUserInfo(email);
	}

	public String getTimeInfo(Integer showId) {
		// movieListDAO.getTimeInfo(showId);
		return null;

	}

	public boolean RetrievePassWord(String email) {
		boolean sentEmail = false;
		String passWord = movieListDAO.RetrievePassWord(email);
		if (passWord != null) {
			sentEmail = SendHTMLEmail(email, passWord);
		}
		return sentEmail;
	}

	public boolean SendHTMLEmail(String email, String passWord) {
		String to = "mo.sridhar98@gmail.com";
		String from = "mo.sridhar94@gmail.com";
		String host = "127.0.0.1";
		Properties properties = System.getProperties();
		//properties.setProperty("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.starttls.enable", "true"); 
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.user", "mo.sridhar94@gmail.com"); // User name
		properties.put("mail.smtp.password", "Shreyas123"); // password
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");
		//Session session = Session.getDefaultInstance(properties);
		Session session = Session.getInstance(properties,
				  new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication("mo.sridhar94@gmail.com", "Shreyas123");
					}
				  });
		try{
			MimeMessage  mimeMessage = new MimeMessage(session);
			mimeMessage.setFrom(new InternetAddress(from));
			mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			mimeMessage.setSubject("MovieOnlineReservation password reset");
			mimeMessage.setContent("<h1> Reset password is "+passWord+"</h1>","text/html");
			Transport.send(mimeMessage);
		}catch(MessagingException me){
			me.printStackTrace();
			return false;
		}
		return true;

	}
	
	public boolean SendHTMLEmail(String toemail, String message,String subject) {
		
		String from = "mo.sridhar94@gmail.com";
		String host = "127.0.0.1";
		Properties properties = System.getProperties();
		//properties.setProperty("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.starttls.enable", "true"); 
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.user", "mo.sridhar94@gmail.com"); // User name
		properties.put("mail.smtp.password", "Shreyas123"); // password
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");
		//Session session = Session.getDefaultInstance(properties);
		Session session = Session.getInstance(properties,
				  new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication("mo.sridhar94@gmail.com", "Shreyas123");
					}
				  });
		try{
			MimeMessage  mimeMessage = new MimeMessage(session);
			mimeMessage.setFrom(new InternetAddress(from));
			mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toemail));
			mimeMessage.setSubject(subject);
			mimeMessage.setContent("<h1>"+message+"</h1>","text/html");
			Transport.send(mimeMessage);
		}catch(MessagingException me){
			me.printStackTrace();
			return false;
		}
		return true;

	}
	
	public boolean checkCookie(HttpServletRequest req){
		//req.getSession().g
		Cookie [] cookies = req.getCookies();
		if(cookies!=null){
			for(Cookie cookie:cookies){
				
				if(cookie.getName().equals("UserID") && cookie.getMaxAge()>0)
					return true;
			}
		}
		return false;		
	}
}
