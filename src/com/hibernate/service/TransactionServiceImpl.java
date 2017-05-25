/**
 * 
 */
package com.hibernate.service;

import java.util.List;

import com.hibernate.bean.Transaction;
import com.hibernate.dao.TransactionDao;
import com.hibernate.dao.TransactionDaoImpl;

/**
 * @author: Yijun Chen
 * @date: Feb 24, 2017
 * @time: 12:05:43 PM
 */
public class TransactionServiceImpl implements TransactionService {

	@Override
	public int addTransaction(Transaction trans) {
		TransactionDao cDao = new TransactionDaoImpl();
		int i = cDao.addTransaction(trans);
		return i;
	}

	@Override
	public void updateTransaction(Transaction trans) {
		TransactionDao cDao = new TransactionDaoImpl();
		cDao.updateTransaction(trans);		
	}

	@Override
	public List<Transaction> viewAllTransactions() {
		TransactionDao cDao = new TransactionDaoImpl();
		List<Transaction> transList = cDao.viewAllTransactions();
		return transList;
	}

	@Override
	public Transaction viewTransactionById(int id) {
		TransactionDao cDao = new TransactionDaoImpl();
		Transaction trans = cDao.viewTransactionById(id);
		return trans;
	}

	@Override
	public List<Transaction> viewTransactionByAccountNum(int accNum) {
		TransactionDao cDao = new TransactionDaoImpl();
		List<Transaction> trans = cDao.viewTransactionByAccountNum(accNum);
		return trans;
	}


}
