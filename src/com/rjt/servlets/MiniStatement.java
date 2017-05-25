package com.rjt.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hibernate.bean.Account;
import com.hibernate.bean.Transaction;
import com.hibernate.bean.User;
import com.hibernate.service.AccountServiceImpl;
import com.hibernate.service.TransactionServiceImpl;
import com.hibernate.service.UserServiceImpl;

@WebServlet("/MiniStatement")
public class MiniStatement extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		List<Transaction2> minList = new ArrayList<Transaction2>();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(); 
		String email=(String)session.getAttribute("email");
		
		UserServiceImpl userImpl = new UserServiceImpl();
		User u1 = userImpl.viewUserByEmail(email);
		int userid = u1.getUserid();
		AccountServiceImpl accImpl = new AccountServiceImpl();
		Account a1 = accImpl.viewAccountById(userid);		
		int accNum = a1.getAccNum();
		TransactionServiceImpl trans = new TransactionServiceImpl();		
		List<Transaction>miniList = trans.viewTransactionByAccountNum(accNum);
	
		
//		List<String> miniList = DBUtil.getTransaction(accNum);
//		List<Transaction2> miniList = DBUtil.getTransaction(accNum); 		
//				DBUtil.getTransaction(accNum);
		
		request.setAttribute("miniList", miniList);		
		RequestDispatcher rd = request.getRequestDispatcher("miniStatement.jsp");
		rd.forward(request, response);
	}

}
