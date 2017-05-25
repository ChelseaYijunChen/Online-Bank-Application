/**
 * 
 */
package com.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author: Yijun Chen
 * @date: Feb 23, 2017
 * @time: 3:43:39 PM
 */
public class HibernateUtil {
	private static final SessionFactory  sessionFactory = buildSessionFactory();
	private static SessionFactory buildSessionFactory(){
		try{
			return new Configuration().configure().buildSessionFactory();
		} catch(Throwable ex){
			System.err.println("Initial SessionFactory crreation failed"+ex);
			throw new ExceptionInInitializerError(ex);
		}	
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
	public static void shutdown(){
		getSessionFactory().close();
	}

}
