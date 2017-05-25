/**
 * 
 */
package com.hibernate.bean;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author: Yijun Chen
 * @date: Feb 22, 2017
 * @time: 1:53:29 AM
 */
@Entity
@Table(name = "Transaction" )
public class Transaction {
	private int transactionId;
	private Account acc;
	private Date transactionDate;
	private String type;
	private double amount;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "transactionId", unique = true, nullable = false)
	public int getTransactionID() {
		return transactionId;
	}

	public void setTransactionID(int transactionID) {
		this.transactionId = transactionID;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "accnum", nullable = false)
	public Account getAcc() {
		return acc;
	}

	public void setAcc(Account acc) {
		this.acc = acc;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "transactionDate", nullable = false)
	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	@Column(name = "type", nullable = false)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "amount", nullable = false)
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	public Transaction() {
		
	}
	
	public Transaction( Account acc, Date transactionDate, String type, double amount){
		this.acc = acc;
		this.transactionDate = transactionDate;
		this.type = type;
		this.amount = amount;	
	}
	
}
