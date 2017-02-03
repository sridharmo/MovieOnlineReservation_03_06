package com.packt.movie.service;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {
	public static SessionFactory sessionFactory;
	static{
	try{
		System.out.println("HibernateConfig");
		sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		}catch(HibernateException e){
			e.printStackTrace();
		}
	}
}
