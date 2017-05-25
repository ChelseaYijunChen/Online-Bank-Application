/**
 * 
 */
package com.rjt.servlets;

import java.sql.Connection;
//import java.sql.Date;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author: Yijun Chen
 * @date: Feb 16, 2017
 * @time: 2:15:46 PM
 */
public class DBUtil {
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
//	private static final String URL = "jdbc:oracle:thin:@192.168.1.41:1521/orcl";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521/orcl";
	private static final String UNAME = "yijun";
	private static final String PASSWORD = "yijun";
	static{
		try{
			Class.forName(DRIVER);
		}
		catch(ClassNotFoundException cnf){
			System.out.println("Error while Loading the Driver");
			cnf.printStackTrace();
		}
	}
	
	public static boolean newUser(String email, String userName, String gender, String password, long phoneNum){
		Connection con= null;
		PreparedStatement preStmt= null;	
		boolean isSucess = false;
		
		String query="INSERT INTO USER_TABLE VALUES (?, ?, ?, ?, ?, ?)";
		
		try{
			con= DriverManager.getConnection(URL,UNAME,PASSWORD);
			preStmt = con.prepareStatement(query);
			
			preStmt.setString(1,email);			
			preStmt.setString(2,"coustomer");
			preStmt.setString(3,userName);
			preStmt.setString(4,gender);
			preStmt.setString(5,password);
			preStmt.setLong(6,phoneNum);
			
			if(preStmt.executeUpdate()==1){
				isSucess = true;
			}
			System.out.println("Done");
		}
		catch(SQLException sql){
			sql.printStackTrace();
		}
		finally {
			try{
				if(preStmt!=null)
					preStmt.close();
				
				if(con!=null)
					con.close();
			}
			catch(SQLException sqle){
				sqle.printStackTrace();
			}
		}	
		return isSucess;
	}
	
	public static boolean newAccount(double balance, String email){
		Connection con= null;
		PreparedStatement preStmt= null;	
		boolean isSucess = false;
		
		String query = "INSERT INTO ACCOUNT_TABLE(balance, email ) VALUES ( ?, ?)";
		
		try{
			con= DriverManager.getConnection(URL,UNAME,PASSWORD);
			preStmt = con.prepareStatement(query);
						
			preStmt.setDouble(1, balance);
			preStmt.setString(2,email);
			
			if(preStmt.executeUpdate() == 1){
				System.out.println("Done");
				isSucess =  true;
			} 
			
		}
		catch(SQLException sql){
			sql.printStackTrace();
		}
		finally {
			try{
				if(preStmt!=null)
					preStmt.close();
				
				if(con!=null)
					con.close();
			}
			catch(SQLException sqle){
				sqle.printStackTrace();
			}
		}
		return isSucess;
	}
	
	public static boolean newTransFrom(int accNumFrom, Date date, double amount){
		Connection con= null;
		PreparedStatement preStmt= null;	
		boolean isSucess = false;
		
		String query="INSERT INTO TRANSACTION_TABLE(account_num, transactionDate, type, amount) VALUES (?, ?, ?, ?)";
		
		try{
			con= DriverManager.getConnection(URL,UNAME,PASSWORD);
			preStmt = con.prepareStatement(query);
			
			preStmt.setInt(1,accNumFrom);			
			preStmt.setDate(2,new java.sql.Date(date.getTime()));
			preStmt.setString(3,"credit");
			preStmt.setDouble(4,amount);
			
			if(preStmt.executeUpdate()==1){
				isSucess = true;
			}
			System.out.println("Done");
		}
		catch(SQLException sql){
			sql.printStackTrace();
		}
		finally {
			try{
				if(preStmt!=null)
					preStmt.close();
				
				if(con!=null)
					con.close();
			}
			catch(SQLException sqle){
				sqle.printStackTrace();
			}
		}	
		return isSucess;
	}
	
	public static boolean newTransTo(int accNumTo, Date date, double amount){
		Connection con= null;
		PreparedStatement preStmt= null;	
		boolean isSucess = false;
		
		String query="INSERT INTO TRANSACTION_TABLE(account_num, transactionDate, type, amount) VALUES (?, ?, ?, ?)";
		
		try{
			con= DriverManager.getConnection(URL,UNAME,PASSWORD);
			preStmt = con.prepareStatement(query);
			
			preStmt.setInt(1,accNumTo);			
			preStmt.setDate(2,new java.sql.Date(date.getTime()));
			preStmt.setString(3,"debit");
			preStmt.setDouble(4,amount);
			
			if((preStmt.executeUpdate()==1)){
				
				isSucess = true;
			}
			System.out.println("Done");
		}
		catch(SQLException sql){
			sql.printStackTrace();
		}
		finally {
			try{
				if(preStmt!=null)
					preStmt.close();
				
				if(con!=null)
					con.close();
			}
			catch(SQLException sqle){
				sqle.printStackTrace();
			}
		}	
		return isSucess;
	}
	
	public static ArrayList<String> getAllAccount(){
		ArrayList<String> each = new ArrayList<String>();
		
		Connection con= null;
		Statement stmt= null;
		ResultSet rs= null;
		
		String query="select * from ACCOUNT_TABLE";
		
		try{
			con= DriverManager.getConnection(URL,UNAME,PASSWORD);
			stmt= con.createStatement();
			rs=stmt.executeQuery(query);
			
			while(rs.next()){
				//res.add(rs.getString(1));
					each.add(rs.getString(1) +" "+ rs.getString(2) +" "+ rs.getString(3) );
					//all.addAll(each);
				//System.out.println(each);
			}		
			System.out.println(each);
			System.out.println("Done");
		}
		catch(SQLException sql){
			sql.printStackTrace();
		}
		finally {
			try{
				if(rs!=null)
					rs.close();
				
				if(stmt!=null)
					stmt.close();
				
				if(con!=null)
					con.close();
			}
			catch(SQLException sqle){
				sqle.printStackTrace();
			}
		}
		return each;
	}
	
	public static ArrayList<String> getAllAccountNum(){
		ArrayList<String> each = new ArrayList<String>();
		
		Connection con= null;
		Statement stmt= null;
		ResultSet rs= null;
		
		String query="select account_num from ACCOUNT_TABLE";
		
		try{
			con= DriverManager.getConnection(URL,UNAME,PASSWORD);
			stmt= con.createStatement();
			rs=stmt.executeQuery(query);
			
			while(rs.next()){
				//res.add(rs.getString(1));
					each.add(rs.getString(1));
					//all.addAll(each);
				//System.out.println(each);
			}		
			System.out.println(each);
			System.out.println("Done");
		}
		catch(SQLException sql){
			sql.printStackTrace();
		}
		finally {
			try{
				if(rs!=null)
					rs.close();
				
				if(stmt!=null)
					stmt.close();
				
				if(con!=null)
					con.close();
			}
			catch(SQLException sqle){
				sqle.printStackTrace();
			}
		}
		return each;
	}

	
	public static ArrayList<String> getAllUser(){
		ArrayList<String> each = new ArrayList<String>();
		
		Connection con= null;
		Statement stmt= null;
		ResultSet rs= null;
		
		String query="select * from USER_TABLE";
		
		try{
			con= DriverManager.getConnection(URL,UNAME,PASSWORD);
			stmt= con.createStatement();
			rs=stmt.executeQuery(query);
			
			while(rs.next()){
				//res.add(rs.getString(1));
					each.add(rs.getString(1) +" "+ rs.getString(2) +" "+ rs.getString(3) 
					+" "+ rs.getString(4)  +" "+ rs.getString(5)+" "+ rs.getString(6) );
					//all.addAll(each);
				//System.out.println(each);
			}		
			System.out.println(each);
			System.out.println("Done");
		}
		catch(SQLException sql){
			sql.printStackTrace();
		}
		finally {
			try{
				if(rs!=null)
					rs.close();
				
				if(stmt!=null)
					stmt.close();
				
				if(con!=null)
					con.close();
			}
			catch(SQLException sqle){
				sqle.printStackTrace();
			}
		}
		return each;
	}
	
	public static ArrayList<User2> getSingleUser(String email){
		ArrayList<User2> each = new ArrayList<User2>();
		
		Connection con= null;
		Statement stmt= null;
		ResultSet rs= null;
		
		String query="select * from USER_TABLE where email = '"+ email +"' "  ;
		
		try{
			con= DriverManager.getConnection(URL,UNAME,PASSWORD);
			stmt= con.createStatement();
			rs=stmt.executeQuery(query);
			
			while(rs.next()){
				//res.add(rs.getString(1));
//					each.add(rs.getString(1) +" "+ rs.getString(2) +" "+ rs.getString(3) +" "
//								+ rs.getString(4) +" "+ rs.getString(5)+" "+ rs.getString(6) );
				User2 user=new User2();
				user.setEmail(rs.getString(1));
				user.setUserType(rs.getString(2));
//				user.setUserName(rs.getString(3));
				user.setGender(rs.getString(4));
//				user.setEmail(rs.getString(5));
				user.setPhoneNum(Integer.parseInt(rs.getString(6)));
				//System.out.println(each);
				each.add(user);
			}		
//			System.out.println(each);
			System.out.println("Done");
		}
		catch(SQLException sql){
			sql.printStackTrace();
		}
		finally {
			try{
				if(rs!=null)
					rs.close();
				
				if(stmt!=null)
					stmt.close();
				
				if(con!=null)
					con.close();
			}
			catch(SQLException sqle){
				sqle.printStackTrace();
			}
		}
		return each;
	}
	
	public static double getBalance(int accNum){
		double balance = 0;
		
		Connection con= null;
		Statement stmt= null;
		ResultSet rs= null;
		
		String query="select balance from ACCOUNT_TABLE where ACCOUNT_NUM = '"+ accNum +"' "  ;
		
		try{
			con= DriverManager.getConnection(URL,UNAME,PASSWORD);
			stmt= con.createStatement();
			rs=stmt.executeQuery(query);
			while(rs.next()){
				balance = Double.parseDouble(rs.getString(1));
			}
			
			System.out.println("Done");
		}
		catch(SQLException sql){
			sql.printStackTrace();
		}
		finally {
			try{
				if(rs!=null)
					rs.close();
				
				if(stmt!=null)
					stmt.close();
				
				if(con!=null)
					con.close();
			}
			catch(SQLException sqle){
				sqle.printStackTrace();
			}
		}
		return balance;
	}
	
	public static ArrayList<Transaction2> getTransaction(int accNum){
		ArrayList<Transaction2> each = new ArrayList<Transaction2>();
		
		Connection con= null;
		Statement stmt= null;
		ResultSet rs= null;
		
		String query="select * from TRANSACTION_TABLE where account_Num = '"+ accNum +"' "  ;
		
		try{
			con= DriverManager.getConnection(URL,UNAME,PASSWORD);
			stmt= con.createStatement();
			rs=stmt.executeQuery(query);
			
			while(rs.next()){				
				Transaction2 trans=new Transaction2();
				trans.setTransactionID(rs.getInt(1));
				trans.setAccNum(rs.getInt(3));
				trans.setTransactionDate(rs.getDate(4));
				trans.setType(rs.getString(5));
				trans.setAmount(rs.getDouble(6));
				//res.add(rs.getString(1));
				each.add(trans );
				//System.out.println(each);
			}		
			System.out.println("Done");
		}
		catch(SQLException sql){
			sql.printStackTrace();
		}
		finally {
			try{
				if(rs!=null)
					rs.close();
				
				if(stmt!=null)
					stmt.close();
				
				if(con!=null)
					con.close();
			}
			catch(SQLException sqle){
				sqle.printStackTrace();
			}
		}
		return each;
	}
	
	
	public static ArrayList<Transaction2> getMini(int accNum){
		ArrayList<Transaction2> each = new ArrayList<Transaction2>();
		
		Connection con= null;
		Statement stmt= null;
		ResultSet rs= null;
		
		String query="select * from TRANSACTION_TABLE where account_Num = '"+ accNum +"' "  ;
		String query2 = "SELECT acc_no, balance, name FROM account a, users u "
				+ "WHERE a.email=u.email ORDER BY acc_no OFFSET v_offset ROWS FETCH FIRST 3 ROWS ONLY";
		
		try{
			con= DriverManager.getConnection(URL,UNAME,PASSWORD);
			stmt= con.createStatement();
			rs=stmt.executeQuery(query);
			
			while(rs.next()){				
				Transaction2 trans=new Transaction2();
				trans.setTransactionID(rs.getInt(1));
				trans.setAccNum(rs.getInt(3));
				trans.setTransactionDate(rs.getDate(4));
				trans.setType(rs.getString(5));
				trans.setAmount(rs.getDouble(6));
				//res.add(rs.getString(1));
				each.add(trans );
				//System.out.println(each);
			}		
			System.out.println("Done");
		}
		catch(SQLException sql){
			sql.printStackTrace();
		}
		finally {
			try{
				if(rs!=null)
					rs.close();
				
				if(stmt!=null)
					stmt.close();
				
				if(con!=null)
					con.close();
			}
			catch(SQLException sqle){
				sqle.printStackTrace();
			}
		}
		return each;
	}
	
//	public static ArrayList<String> getTransaction(int accNum){
//		ArrayList<String> each = new ArrayList<String>();
//		
//		Connection con= null;
//		Statement stmt= null;
//		ResultSet rs= null;
//		
//		String query="select account_num, transactionDate, type from TRANSACTION_TABLE where account_Num = '"+ accNum +"' "  ;
//		
//		try{
//			con= DriverManager.getConnection(URL,UNAME,PASSWORD);
//			stmt= con.createStatement();
//			rs=stmt.executeQuery(query);
//			
//			while(rs.next()){
//				//res.add(rs.getString(1));
//					each.add(rs.getString(1) +" "+ rs.getString(2) +" "+ rs.getString(3)  );
//				//System.out.println(each);
//			}		
//			System.out.println("Done");
//		}
//		catch(SQLException sql){
//			sql.printStackTrace();
//		}
//		finally {
//			try{
//				if(rs!=null)
//					rs.close();
//				
//				if(stmt!=null)
//					stmt.close();
//				
//				if(con!=null)
//					con.close();
//			}
//			catch(SQLException sqle){
//				sqle.printStackTrace();
//			}
//		}
//		return each;
//	}
	
	public static boolean decreBalance(int accNum, double amount){
		
		Connection con= null;
		Statement stmt= null;
		ResultSet rs= null;
		
		String query="update ACCOUNT_TABLE set balance = balance-'"+ amount +"' where account_num = '"+ accNum +"' "  ;
		
		try{
			con= DriverManager.getConnection(URL,UNAME,PASSWORD);
			stmt= con.createStatement();
			rs=stmt.executeQuery(query);			
			System.out.println("Done");
		}
		catch(SQLException sql){
			sql.printStackTrace();
		}
		finally {
			try{
				if(rs!=null)
					rs.close();
				
				if(stmt!=null)
					stmt.close();
				
				if(con!=null)
					con.close();
			}
			catch(SQLException sqle){
				sqle.printStackTrace();
			}
		}
		return true;
	}
	
	public static boolean increBalance(int accNum, double amount){
		
		Connection con= null;
		Statement stmt= null;
		ResultSet rs= null;
		
		String query="update ACCOUNT_TABLE set balance = balance+'"+ amount +"' where account_num = '"+ accNum +"' "  ;
		
		try{
			con= DriverManager.getConnection(URL,UNAME,PASSWORD);
			stmt= con.createStatement();
			rs=stmt.executeQuery(query);			
			System.out.println("Done");
		}
		catch(SQLException sql){
			sql.printStackTrace();
		}
		finally {
			try{
				if(rs!=null)
					rs.close();
				
				if(stmt!=null)
					stmt.close();
				
				if(con!=null)
					con.close();
			}
			catch(SQLException sqle){
				sqle.printStackTrace();
			}
		}
		return true;
	}
	
	public static String getEmailFromAcc(int accNum){
		String email =new String();
		
		Connection con= null;
		Statement stmt= null;
		ResultSet rs= null;
		
		String query="select email from ACCOUNT_TABLE where ACCOUNT_NUM = '"+ accNum +"' "  ;
		
		try{
			con= DriverManager.getConnection(URL,UNAME,PASSWORD);
			stmt= con.createStatement();
			rs=stmt.executeQuery(query);

			while(rs.next()){
				email = rs.getString(1);
			}
		
			System.out.println("Done");
		}
		catch(SQLException sql){
			sql.printStackTrace();
		}
		finally {
			try{
				if(rs!=null)
					rs.close();
				
				if(stmt!=null)
					stmt.close();
				
				if(con!=null)
					con.close();
			}
			catch(SQLException sqle){
				sqle.printStackTrace();
			}
		}
		return email;
	}
	
	public static String getEmailFromUser(String userName){
		String email =new String();
		
		Connection con= null;
		Statement stmt= null;
		ResultSet rs= null;
		
		String query="select email from USER_TABLE where USER_NAME = '"+ userName +"' "  ;
		
		try{
			con= DriverManager.getConnection(URL,UNAME,PASSWORD);
			stmt= con.createStatement();
			rs=stmt.executeQuery(query);

			while(rs.next()){
				email = rs.getString(1);
			}
		
			System.out.println("Done");
		}
		catch(SQLException sql){
			sql.printStackTrace();
		}
		finally {
			try{
				if(rs!=null)
					rs.close();
				
				if(stmt!=null)
					stmt.close();
				
				if(con!=null)
					con.close();
			}
			catch(SQLException sqle){
				sqle.printStackTrace();
			}
		}
		return email;
	}

	
	public static String getUserName(String email){
		String userName =new String();
		
		Connection con= null;
		Statement stmt= null;
		ResultSet rs= null;
		
		String query="select user_name from USER_TABLE where EMAIL = '"+ email +"' "  ;
		
		try{
			con= DriverManager.getConnection(URL,UNAME,PASSWORD);
			stmt= con.createStatement();
			rs=stmt.executeQuery(query);
			while(rs.next()){
				userName = rs.getString(1);
			}
							
			System.out.println("Done");
		}
		catch(SQLException sql){
			sql.printStackTrace();
		}
		finally {
			try{
				if(rs!=null)
					rs.close();
				
				if(stmt!=null)
					stmt.close();
				
				if(con!=null)
					con.close();
			}
			catch(SQLException sqle){
				sqle.printStackTrace();
			}
		}
		return userName;
	}
	
	public static int getAccountNum(String email){
		int accNum = 0 ;
		
		Connection con= null;
		Statement stmt= null;
		ResultSet rs= null;
		
		String query="select account_num from ACCOUNT_TABLE where email = '"+ email +"' "  ;
		
		try{
			con= DriverManager.getConnection(URL,UNAME,PASSWORD);
			stmt= con.createStatement();
			rs=stmt.executeQuery(query);
			while(rs.next()){
				accNum = Integer.parseInt(rs.getString(1));
			}
							
			System.out.println("Done");
		}
		catch(SQLException sql){
			sql.printStackTrace();
		}
		finally {
			try{
				if(rs!=null)
					rs.close();
				
				if(stmt!=null)
					stmt.close();
				
				if(con!=null)
					con.close();
			}
			catch(SQLException sqle){
				sqle.printStackTrace();
			}
		}
		return accNum;
	}
	
	public static void delete(int eid){
		Connection con= null;
		Statement stmt= null;
		
		String query = "delete from EMPLOYEE where EID = '"+ eid +"' " ;
		
		try{
			con= DriverManager.getConnection(URL,UNAME,PASSWORD);
			stmt= con.createStatement();
			stmt.execute(query);
			System.out.println("Done");
		}
		catch(SQLException sql){
			sql.printStackTrace();
		}
		finally {
			try{
				if(stmt!=null)
					stmt.close();
				
				if(con!=null)
					con.close();
			}
			catch(SQLException sqle){
				sqle.printStackTrace();
			}
			
		}
	}

	public static boolean isPwordCorrect(String email, String password){

		Connection con= null;
		Statement stmt= null;
		ResultSet rs= null;
		
		String query="select password from USER_TABLE where email = '"+ email +"' "  ;
		
		try{
			con= DriverManager.getConnection(URL,UNAME,PASSWORD);
			stmt= con.createStatement();
			rs=stmt.executeQuery(query);
			
			while(rs.next()){
				if(password.equals(rs.getString(1))){
					return true;
				}else{
					return false;
				}
			}		
			System.out.println("Done");
		}
		catch(SQLException sql){
			sql.printStackTrace();
		}
		finally {
			try{
				if(rs!=null)
					rs.close();
				
				if(stmt!=null)
					stmt.close();
				
				if(con!=null)
					con.close();
			}
			catch(SQLException sqle){
				sqle.printStackTrace();
			}
		}
		return false;
	}
	
	public static boolean isAdmin(String email){
		Connection con= null;
		Statement stmt= null;
		ResultSet rs= null;
		
		String query="select user_type from USER_TABLE where email = '"+ email +"' "  ;
		
		try{
			con= DriverManager.getConnection(URL,UNAME,PASSWORD);
			stmt= con.createStatement();
			rs=stmt.executeQuery(query);
			
			while(rs.next()){
				if(rs.getString(1).equals("admin")){
					return true;
				}else{
					return false;
				}
			}		
			System.out.println("Done");
		}
		catch(SQLException sql){
			sql.printStackTrace();
		}
		finally {
			try{
				if(rs!=null)
					rs.close();
				
				if(stmt!=null)
					stmt.close();
				
				if(con!=null)
					con.close();
			}
			catch(SQLException sqle){
				sqle.printStackTrace();
			}
		}
		return false;
	}
	
//	public static boolean isAdmin(String uname){
//		ArrayList<String> user = getUser(uname);
//		
//		if(user.get(2).equals("admin")){
//			return true;
//		} else {
//			return false;
//		}
//	}
	
	
	public static void main(String[] args){
		//newUser("yijun chen", "Female", "yijun@gmail.com", "123abc", 1234567894);
//		newAccount(1000, "yijun@gmail.com");
		
	}
}
