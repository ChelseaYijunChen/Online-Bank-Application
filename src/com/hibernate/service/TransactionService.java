/**
 * 
 */
package com.hibernate.service;

import java.util.List;

import com.hibernate.bean.Transaction;

/**
 * @author: Yijun Chen
 * @date: Feb 24, 2017
 * @time: 12:05:26 PM
 */
public interface TransactionService {
	public int addTransaction(Transaction trans);
	public void updateTransaction(Transaction trans);
	public List<Transaction> viewAllTransactions();
	public Transaction viewTransactionById(int id);
	public List<Transaction> viewTransactionByAccountNum(int accId);
}
