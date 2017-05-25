/**
 * 
 */
package com.hibernate.dao;

import java.util.List;

import com.hibernate.bean.Account;

/**
 * @author: Yijun Chen
 * @date: Feb 24, 2017
 * @time: 11:41:28 AM
 */
public interface AccountDao {
	public int addAccount(Account account);
	public void updateAccount(Account account);
	public List<Account> viewAllAccounts();
	public Account viewAccountById(int id);
	public Account viewAccountByEmail(String email);	
}
