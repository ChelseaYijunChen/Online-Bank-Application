/**
 * 
 */
package com.hibernate.service;

import java.util.List;

import com.hibernate.dao.UserDao;
import com.hibernate.dao.UserDaoImpl;
import com.hibernate.bean.User;


/**
 * @author: Yijun Chen
 * @date: Feb 23, 2017
 * @time: 4:52:22 PM
 */
public class UserServiceImpl implements UserService{
	
	@Override
	public int addUser(User c) {		
		UserDao cDao = new UserDaoImpl();
		int i = cDao.addUser(c);
		return i;
	}

	@Override
	public void updateUser(User c) {
		UserDao cDao = new UserDaoImpl();
		cDao.updateUser(c);		
	}


	@Override
	public User viewUserByEmail(String email) {
		UserDao cDao = new UserDaoImpl();
		User s = cDao.viewUserByEmail(email);
		return s;
	}

	@Override
	public List<User> viewAllUser() {
		UserDao cDao = new UserDaoImpl();
		List<User> cList = cDao.viewAllUsers();
		return cList;
	}

//	@Override
//	public List<User> viewAllUserByCity(String city) {
//		UserDao cDao = new UserDaoImpl();
//		List<User> cList = cDao.viewAllUserByCity(city);
//		return cList;
//	}
	
}
