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

@WebServlet("/SearchAccServlet")
public class SearchAccServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int accNum = Integer.parseInt(request.getParameter("accNum"));
		double balance = DBUtil.getBalance(accNum);
		String email = DBUtil.getEmailFromAcc(accNum);
		String userName =DBUtil.getUserName(email);
//		List<String> singleList = new ArrayList<>();
//		List<User> singleList = DBUtil.getSingleUser(email);
//		
//		request.setAttribute("singleList", singleList);
//		singleList.add(accNum+","+userName+","+balance);
		

		request.setAttribute("accNum", accNum);
		request.setAttribute("userName", userName);
		request.setAttribute("balance", balance);
		
		//List<String> singleList = DBUtil.getSingleUser(email)
		
		RequestDispatcher rd = request.getRequestDispatcher("viewSingleAccount.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		List<String> userList = DBUtil.getAllUser();
		doGet(request, response);
	}

}
