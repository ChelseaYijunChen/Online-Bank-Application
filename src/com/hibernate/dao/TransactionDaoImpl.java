/**
 * 
 */
package com.hibernate.dao;

import java.util.List;

import com.hibernate.bean.Transaction;
import com.hibernate.util.HibernateTemplate;

/**
 * @author: Yijun Chen
 * @date: Feb 24, 2017
 * @time: 11:49:35 AM
 */
public class TransactionDaoImpl implements TransactionDao{

	@Override
	public int addTransaction(Transaction trans) {
		Integer i = (Integer)HibernateTemplate.save(trans);
		return i;
	}

	@Override
	public void updateTransaction(Transaction trans) {
		HibernateTemplate.update(trans);	
	}

	@Override
	public List<Transaction> viewAllTransactions() {
		List<Transaction> cList = (List<Transaction>)HibernateTemplate.find("From Transaction");	
		return cList;
	}

	@Override
	public Transaction viewTransactionById(int id) {
		List<Transaction> cList = (List<Transaction>)HibernateTemplate.find("From Transaction where transactionId= '"+id+"' ");	
		return cList.get(0);
	}

	@Override
	public List<Transaction> viewTransactionByAccountNum(int accnum) {
		List<Transaction> c = (List<Transaction>)HibernateTemplate.find("From Transaction where accnum= '"+accnum+"' ");	
		return c;
	}
}
