/**
 * 
 */
package com.rjt.servlets;

import java.util.Date;

/**
 * @author: Yijun Chen
 * @date: Feb 22, 2017
 * @time: 1:53:29 AM
 */
public class Transaction2 {
	private int transactionID;
	private int accNum;
	private Date transactionDate;
	private String type;
	private double amount;

	public int getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}

	public int getAccNum() {
		return accNum;
	}

	public void setAccNum(int accNum) {
		this.accNum = accNum;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public Transaction2() {
		
	}
	
	public Transaction2(int transactionID,int accNum, Date transactionDate, String type, double amount){
		this.transactionID = transactionID;
		this.accNum = accNum;
		this.transactionDate = transactionDate;
		this.type = type;
		this.amount = amount;	
	}
	
}
