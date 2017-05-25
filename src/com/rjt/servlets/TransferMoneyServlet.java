package com.rjt.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/TransferMoneyServlet")
public class TransferMoneyServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int accNumTo = Integer.parseInt(request.getParameter("accNumTo"));
		double amount = Double.parseDouble(request.getParameter("amount"));
		
//		HttpSession session=request.getSession(); 
//		String userName=(String)session.getAttribute("userName");
//		System.out.println(userName);
		
		HttpSession session=request.getSession(); 
		String email=(String)session.getAttribute("email");
//		String email = DBUtil.getEmailFromUser(userName);	
		int accNumFrom = DBUtil.getAccountNum(email);	
		
//		System.out.println(accNumFrom);
		Date date = new Date( );
//	    SimpleDateFormat dateForm = new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");			
//		if(DBUtil.getAccountNum(userName))
		
		double balance = DBUtil.getBalance(accNumFrom);
//		System.out.println(balance);
//		System.out.println(amount);
		PrintWriter out = response.getWriter();
		
		List<String> accList = DBUtil.getAllAccountNum();
		boolean isValidAccNumTo = false;
		for(int i = 0; i< accList.size(); i++){
			if(accNumTo == Integer.parseInt(accList.get(i))){
				isValidAccNumTo = true;
			}
		}
		
		if(amount>= balance){
			out.println("your balance is not enough for this transfer");
		} else if(!isValidAccNumTo){
			out.println("The account number you provide is not valid, please check ");
		} else{			
			if(DBUtil.decreBalance(accNumFrom, amount) && DBUtil.increBalance(accNumTo, amount)){
				if(DBUtil.newTransFrom(accNumFrom, date, amount) && DBUtil.newTransTo(accNumTo, date, amount)){
					out.println("Transaction sucessed");
				}	
			}	
		}
	}
}
