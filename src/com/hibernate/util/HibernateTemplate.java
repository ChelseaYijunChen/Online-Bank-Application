/**
 * 
 */
package com.hibernate.util;

import java.io.Serializable;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



/**
 * @author: Yijun Chen
 * @date: Feb 23, 2017
 * @time: 3:44:00 PM
 */
public class HibernateTemplate {
	public static Object save(Object obj){
		Transaction tx = null;
		Object ob = null;
		try{		
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			ob = session.save(obj);
			tx.commit();
			session.close();
		} catch(Exception e){
			if(tx!=null){
				tx.rollback();
			}
			e.printStackTrace();
		}
		return ob;
	}
	public static Object load(Class cls, Serializable id){
		Transaction tx = null;
		Object obj = null;
		try{
			SessionFactory sf =  HibernateUtil.getSessionFactory();			
			Session session = sf.openSession();
			tx = session.beginTransaction();
			obj = session.load(cls, id);
			
			tx.commit();
			session.close();
		}catch(Exception e){
			if(tx!=null){
				tx.rollback();
			}
			e.printStackTrace();
		}
		return obj;
	}

	public static void delete(Class cls, Serializable id){
		Transaction tx = null;
		Object obj = null;
		try{
			SessionFactory sf = HibernateUtil.getSessionFactory();		
			Session session = sf.openSession();
			
			tx = session.beginTransaction();
			obj = session.load(cls, id);
			session.delete(obj);
			tx.commit();
			session.close();
		} catch(Exception e){
			if(tx!=null){
				tx.rollback();
			}
			e.printStackTrace();
		}
	}
	
	public static void update(Object obj) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			
			tx = session.beginTransaction();
			session.update(obj);
			tx.commit();
			session.close();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}
	
	public static Object find(String queryString) {
		Transaction tx = null;
		Object obj = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			
			tx = session.beginTransaction();
			Query query = session.createQuery(queryString);
			obj = query.list();
			tx.commit();
			session.close();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return obj;
	}
	
	public static Object findByNamedParam(String queryString, String paramName,Object value) {
		Transaction tx = null;
		Object obj = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			
			tx = session.beginTransaction();
			Query query = session.createQuery(queryString);
			query.setParameter(paramName, value);
			obj = query.list();
			tx.commit();
			session.close();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return obj;
	}
}
