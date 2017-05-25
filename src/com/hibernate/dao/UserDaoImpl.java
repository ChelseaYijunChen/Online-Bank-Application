/**
 * 
 */
package com.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import com.hibernate.bean.Account;
import com.hibernate.bean.User;
import com.hibernate.util.HibernateTemplate;

/**
 * @author: Yijun Chen
 * @date: Feb 23, 2017
 * @time: 5:02:20 PM
 */
public class UserDaoImpl implements UserDao{

	@Override
	public int addUser(User c) {
		Integer i = (Integer)HibernateTemplate.save(c);
		return i;
	}

	@Override
	public void updateUser(User c) {
		HibernateTemplate.update(c);
	}

	@Override
	public User viewUserByEmail(String email) {
		List<User> c = (List<User>)HibernateTemplate.find("From User where email= '"+email+"' ");	
		return c.get(0);
	}

	@Override
	public List<User> viewAllUsers() {
		List<User> cList = (List<User>)HibernateTemplate.find("From User");	
		return cList;
	}

}
