/**
 * 
 */
package com.hibernate.service;

import java.util.List;

import com.hibernate.bean.Account;

/**
 * @author: Yijun Chen
 * @date: Feb 24, 2017
 * @time: 11:44:15 AM
 */
public interface AccountService {
	public int addAccount(Account account);
	public void updateAccount(Account account);
	public List<Account> viewAllAccounts();
	public Account viewAccountById(int id);
	public Account viewAccountByEmail(String email);
}
