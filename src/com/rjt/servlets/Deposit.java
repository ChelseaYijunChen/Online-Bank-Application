package com.rjt.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Deposit")
public class Deposit extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int accNum = Integer.parseInt(request.getParameter("accNum"));
		double amount = Double.parseDouble(request.getParameter("amount"));
//		double balance = DBUtil.getBalance(accNum);
		PrintWriter out = response.getWriter();
		
		
		List<String> accList = DBUtil.getAllAccountNum();
		boolean isValidAccNum = false;
		for(int i = 0; i< accList.size(); i++){
			if(accNum == Integer.parseInt(accList.get(i))){
				isValidAccNum = true;
			}
		}
		
		if(!isValidAccNum){
			out.println("The account number you provide is not valid, please check");
		}else{
			if(DBUtil.increBalance(accNum, amount)){
				out.println("sucess deposit");
			}	
		}		
	}
}
