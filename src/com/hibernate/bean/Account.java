/**
 * 
 */
package com.hibernate.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: Yijun Chen
 * @date: Feb 24, 2017
 * @time: 9:54:29 AM
 */

@Entity
@Table(name = "Account" )
public class Account implements Serializable{
	private int accNum;
	private User user;
	private double balance;
	private Set<Transaction> trans = new HashSet<Transaction>();

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "accnum", unique = true, nullable = false)
	public int getAccNum() {
		return accNum;
	}

	public void setAccNum(int accNum) {
		this.accNum = accNum;
	}

	@Column(name = "balance",  nullable = false)
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="userid", nullable = false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "acc")
	public Set<Transaction> getTrans() {
		return trans;
	}

	public void setTrans(Set<Transaction> trans) {
		this.trans = trans;
	}

	public Account(){
		
	}

	public Account( User user, double balance, Set<Transaction> trans) {
		this.balance = balance;
		this.user = user;
		this.trans = trans;
	}
	
}
