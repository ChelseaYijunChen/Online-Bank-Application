/**
 * 
 */
package com.hibernate.service;

import java.util.List;

import com.hibernate.bean.Account;
import com.hibernate.dao.AccountDao;
import com.hibernate.dao.AccountDaoImpl;

/**
 * @author: Yijun Chen
 * @date: Feb 24, 2017
 * @time: 11:44:33 AM
 */
public class AccountServiceImpl implements AccountService{

	@Override
	public int addAccount(Account account) {
		AccountDao cDao = new AccountDaoImpl();
		int i = cDao.addAccount(account);
		return i;
	}

	@Override
	public void updateAccount(Account account) {
		AccountDao cDao = new AccountDaoImpl();
		cDao.updateAccount(account);		
	}

	@Override
	public List<Account> viewAllAccounts() {
		AccountDao cDao = new AccountDaoImpl();
		List<Account> accList = cDao.viewAllAccounts();
		return accList;
	}

	@Override
	public Account viewAccountById(int id) {
		AccountDao cDao = new AccountDaoImpl();
		Account acc = cDao.viewAccountById(id);
		return acc;
	}

	@Override
	public Account viewAccountByEmail(String email) {
		AccountDao cDao = new AccountDaoImpl();
		Account acc = cDao.viewAccountByEmail(email);
		return acc;
	}

}
