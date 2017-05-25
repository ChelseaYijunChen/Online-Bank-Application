package com.rjt.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hibernate.bean.Account;
import com.hibernate.bean.User;
import com.hibernate.bean.Transaction;
import com.hibernate.service.AccountServiceImpl;
import com.hibernate.service.TransactionServiceImpl;
import com.hibernate.service.UserServiceImpl;


@WebServlet("/NewAccountServlet")
public class NewAccountServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User u1 = new User();
		u1.setEmail(request.getParameter("email"));
		u1.setUserName(request.getParameter("userName"));
		u1.setUserType("customer");
		u1.setGender(request.getParameter("gender"));
		u1.setPassword(request.getParameter("password1"));
		u1.setPhoneNum(request.getParameter("phoneNum"));
		
		Account a1 = new Account();
		a1.setBalance(Double.parseDouble(request.getParameter("balance")));
		a1.setUser(u1);
		u1.getAccSet().add(a1);
		
		Transaction t1 = new Transaction();
		t1.setAcc(a1);
		a1.getTrans().add(t1);
		t1.setTransactionDate(new Date());
		t1.setType("debit");
		t1.setAmount(Double.parseDouble(request.getParameter("balance")));
		
		UserServiceImpl user = new UserServiceImpl();
		AccountServiceImpl account = new AccountServiceImpl();		
		TransactionServiceImpl trans = new TransactionServiceImpl();
		
		PrintWriter out = response.getWriter();
		if(user.addUser(u1) >=1 && account.addAccount(a1)>=1 && trans.addTransaction(t1)>=1){	
			out.println("Successed open new account");
			//page = "adminhome.jsp";
		} else{
			out.println("Oops, somthing wrong");			
		}
			
		
		//String accNum = request.getParameter("accNum");
//		String userName = request.getParameter("userName");
//		String gender = request.getParameter("gender");
//		String email = request.getParameter("email");
//		String password = request.getParameter("password1");
//		long phoneNum = Long.parseLong(request.getParameter("phoneNum"));
//		double balance = Double.parseDouble(request.getParameter("balance"));
////		String page = "adminhome.jsp";				
////		RequestDispatcher rd = request.getRequestDispatcher(page);
////		rd.forward(request, response);
//		Date date = new Date( );
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
	
//		AccountServiceImpl acc = new AccountServiceImpl();
//		
//		if(DBUtil.newUser(email, userName, gender, password, phoneNum) && DBUtil.newAccount(balance, email)){
////			DBUtil.newTransTo(accNumTo, date, balance)
////			
//			out.println("Successed open new account");
//			//page = "adminhome.jsp";
//		} else{
//			out.println("Oops, somthing wrong");			
//		}	
		
	}

}
