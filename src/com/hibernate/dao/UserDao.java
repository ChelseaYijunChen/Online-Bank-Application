/**
 * 
 */
package com.hibernate.dao;

import java.util.List;

import com.hibernate.bean.Account;
import com.hibernate.bean.User;

/**
 * @author: Yijun Chen
 * @date: Feb 23, 2017
 * @time: 5:02:06 PM
 */
public interface UserDao {
	public int addUser(User c);
	public void updateUser(User c);
	public User viewUserByEmail(String email);
	public List<User> viewAllUsers();
}
