/**
 * 
 */
package com.hibernate.bean;

import java.util.Date;

import org.hibernate.Session;

import com.hibernate.util.HibernateUtil;

/**
 * @author: Yijun Chen
 * @date: Feb 24, 2017
 * @time: 10:31:12 AM
 */
public class MainClass {
	public static void main(String[] args) {
	    System.out.println("Hibernate one to many (Annotation)");
	 	Session session = HibernateUtil.getSessionFactory().openSession();

	 	session.beginTransaction();
	 	
	 	User u1 = new User();
	 		u1.setEmail("yijun@gmail.com");
	 		u1.setGender("Female");
	 		u1.setUserName("jun");
	 		u1.setPassword("123abc");
	 		u1.setPhoneNum("8888888888");
	 		u1.setUserType("customer");
	 		session.save(u1);
	 		
	 		Account a1 = new Account();
	 		a1.setBalance(300);
	 		a1.setUser(u1);
	 		u1.getAccSet().add(a1);
	 		session.save(a1);
	 		
	 			Transaction t1 = new Transaction();
	 			t1.setAmount(200);
	 			t1.setType("debit");
	 			t1.setTransactionDate(new Date());
	 			t1.setAcc(a1);
	 			a1.getTrans().add(t1);
	 			session.save(t1);
	 			
	 			session.getTransaction().commit();
	 			System.out.println("Done");
	}
}
