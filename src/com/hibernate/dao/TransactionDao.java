/**
 * 
 */
package com.hibernate.dao;

import java.util.List;

import com.hibernate.bean.Transaction;

/**
 * @author: Yijun Chen
 * @date: Feb 24, 2017
 * @time: 11:49:22 AM
 */
public interface TransactionDao {
	public int addTransaction(Transaction trans);
	public void updateTransaction(Transaction trans);
	public List<Transaction> viewAllTransactions();
	public Transaction viewTransactionById(int id);
	public List<Transaction> viewTransactionByAccountNum(int accNum);
}
