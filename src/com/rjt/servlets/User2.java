/**
 * 
 */
package com.rjt.servlets;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author: Yijun Chen
 * @date: Feb 20, 2017
 * @time: 5:48:33 PM
 */
@Entity
@Table(name = "User")
public class User2 {
	private int accNum;
	private double balance;
	private String userName;
	private String userType;
	private String gender;
	private String email;
	private String password;
	private long phoneNum;

	public int getAccNum() {
		return accNum;
	}

	public void setAccNum(int accNum) {
		this.accNum = accNum;
	}

	@Column(name = "username",  nullable = false)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Column(name = "userType",  nullable = false)
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Column(name = "gender",  nullable = false)
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Id
	@Column(name = "email", unique = true, nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password",  nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(int phoneNum) {
		this.phoneNum = phoneNum;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public User2(int accNum, double balance, String email, String userType, String userName, String gender, String password, long phoneNum) {
		this.accNum = accNum;
		this.balance = balance;
		this.userType = userType;
		this.userName = userName;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.phoneNum = phoneNum;		
	}
	
	public User2(){
		
	}
	
}
