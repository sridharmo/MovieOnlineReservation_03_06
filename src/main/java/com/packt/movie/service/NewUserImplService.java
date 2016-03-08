package com.packt.movie.service;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mysql.jdbc.Connection;
import com.packt.movie.model.ExistingUser;
import com.packt.movie.model.NewUser;


public class NewUserImplService {
	
//	static SessionFactory sessionFactory;
	static Session session = null;
	Transaction transaction = null;
	/*public NewUserImplService() {
		try{
		sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		}catch(HibernateException e){
			e.printStackTrace();
		}
	}*/
	
	public String updateUserInfo(NewUser newUser){
		
		System.out.println("NewUser");		
		System.out.println("Email="+newUser.getEmail());
		System.out.println("PassWord="+newUser.getPassWord());
		System.out.println("Credit Card Number="+newUser.getCreditCardNumber());
		System.out.println("Expiration Month="+newUser.getExpirationMonth());
		System.out.println("FirstName="+newUser.getFirstName());
		System.out.println("LastName = "+newUser.getLastName());
		//check whether the email is existing if so then redirect to login page other wise show
		// that the purchase has been done.
		String sql = "FROM NewUser U WHERE U.email='"+newUser.getEmail()+"'";
		session = HibernateConfig.sessionFactory.openSession();
		List results = (List) session.createQuery(sql).list();
		if(results.size()>0)
			return "NewUser";
		try{
			transaction = session.beginTransaction();
			session.save(newUser);
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
				e.printStackTrace();
		}
		finally {
			session.close();
		}		
		
		return "purchased";
	}
	public String signInExistingUser(NewUser User){
		session = HibernateConfig.sessionFactory.openSession();
		String sql = "FROM NewUser U WHERE U.email='"+User.getEmail()+"'"+"AND U.passWord='"+User.getPassWord()+"'";
		List results = (List) session.createQuery(sql).list();
		if(results.size() >=0)
			return "Success";
		else
			return "Failure";
		
	}
}
