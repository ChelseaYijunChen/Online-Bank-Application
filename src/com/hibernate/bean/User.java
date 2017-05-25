/**
 * 
 */
package com.hibernate.bean;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author: Yijun Chen
 * @date: Feb 20, 2017
 * @time: 5:48:33 PM
 */
@Entity
@Table(name = "Userse",uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User implements Serializable{
	private int userid;
	private String email;
	private String userName;
	private String userType;
	private String gender;
	private String password;
	private String phoneNum;
	private Set<Account> accSet = new HashSet<Account>(0);

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "userid", unique = true, nullable = false)
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	@Column(name = "username",  nullable = false)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Column(name = "usertype",  nullable = false)
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

	@Column(name = "phonenum",  nullable = false)
	public String getPhoneNum() {
		return phoneNum;
	}
	
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Account> getAccSet() {
		return accSet;
	}


	public void setAccSet(Set<Account> accSet) {
		this.accSet = accSet;
	}

	public User() {
	}

	public User(String email, String userName, String userType, String gender, String password, String phoneNum,
			Set<Account> accSet) {
		this.email = email;
		this.userName = userName;
		this.userType = userType;
		this.gender = gender;
		this.password = password;
		this.phoneNum = phoneNum;
		this.accSet = accSet;
	}
	
}
