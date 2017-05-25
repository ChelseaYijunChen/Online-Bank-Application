/**
 * 
 */
package com.hibernate.dao;

import java.util.List;

import com.hibernate.bean.Account;
import com.hibernate.util.HibernateTemplate;

/**
 * @author: Yijun Chen
 * @date: Feb 24, 2017
 * @time: 11:41:42 AM
 */
public class AccountDaoImpl implements AccountDao{

	@Override
	public int addAccount(Account account) {
		Integer i = (Integer)HibernateTemplate.save(account);
		return i;
	}

	@Override
	public void updateAccount(Account account) {
		HibernateTemplate.update(account);	
	}

	@Override
	public List<Account> viewAllAccounts() {
		List<Account> cList = (List<Account>)HibernateTemplate.find("From Account");	
		return cList;
	}

	@Override
	public Account viewAccountById(int accnum) {
		List<Account> cList = (List<Account>)HibernateTemplate.find("From Account where accnum= '"+accnum+"' ");	
		return cList.get(0);
	}

	@Override
	public Account viewAccountByEmail(String email) {
		List<Account> c = (List<Account>)HibernateTemplate.find("From Account where email= '"+email+"' ");	
		return c.get(0);
	}	
}
