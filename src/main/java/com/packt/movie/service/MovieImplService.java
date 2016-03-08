package com.packt.movie.service;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import com.mysql.jdbc.Connection;
import com.packt.movie.model.MovieList;

//@Repository
public class MovieImplService  {
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
//	static SessionFactory sessionFactory;
	static Session session = null;
	Transaction transaction = null;

	
	public List<MovieList> getMovieList(String sqlDate) throws SQLException {
		List<MovieList> movieList = new ArrayList<MovieList>();

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");

		
		System.out.println("sqlDate=" + sqlDate);
		
		String hql = "FROM MovieList M WHERE M.movieDate ='" + sqlDate + "'";
		/*try{
			sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			
		}catch(HibernateException e){
				e.printStackTrace();
		}*/
		session = HibernateConfig.sessionFactory.openSession();
		List results = (List) session.createQuery(hql).list();
		// if(results.size()>0)
		Iterator<MovieList> iterator = results.iterator();
		while (iterator.hasNext()) {
			MovieList movieIterator = (MovieList) iterator.next();
			MovieList movie = new MovieList();
			System.out.println(movieIterator.getMovieDate());
			movie.setMovieDate(movieIterator.getMovieDate());
			System.out.println(movieIterator.getMovieName());
			movie.setMovieName(movieIterator.getMovieName());		
			movie.setTimeInfo(movieIterator.getTimeInfo());
			System.out.println("movie time "+movie.getTimeInfo().getMovieTime());
			String time = movie.getTimeInfo().getMovieTime().toString();
			String []hrMin = time.split(":");
		//	movie.setShow1(Integer.parseInt(time));
			movie.setShow1(Integer.valueOf(hrMin[0]));
			System.out.println("movie time ="+movie.getShow1());
			movie.setMovieDuration(movieIterator.getMovieDuration());
			movieList.add(movie);
		}
		session.close();
		return movieList;

	}

}
