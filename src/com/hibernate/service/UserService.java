/**
 * 
 */
package com.hibernate.service;

import java.util.List;

import com.hibernate.bean.User;

/**
 * @author: Yijun Chen
 * @date: Feb 23, 2017
 * @time: 4:52:06 PM
 */
public interface UserService {
	public int addUser(User c);
//	public void deleteUser(Class user, int id);
	public void updateUser(User c);
//	public User viewUserById(int id);
	public User viewUserByEmail(String email);
	public List<User> viewAllUser();
//	public List<User> viewAllUserByCity(String city);
}
