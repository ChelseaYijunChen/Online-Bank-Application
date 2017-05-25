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

import com.hibernate.bean.Account;
import com.hibernate.service.AccountServiceImpl;
import com.hibernate.service.UserServiceImpl;


@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		List<String> userList = DBUtil.getAllUser();
//		List<String> accList = DBUtil.getAllAccount();
//		List<User2> allList = new ArrayList<>();
//		for(int i = 0; i< accList.size(); i++){
//			String[] user = userList.get(i).split(" ");
//			String[] account = accList.get(i).split(" ");
//			User2 u1 = new User2(Integer.parseInt(account[0]),Double.parseDouble(account[1]),user[0],user[1],user[2],user[3],user[4],Long.parseLong(user[5]));
//			allList.add(u1);
////			System.out.println(u1);
//		}
		
		
		AccountServiceImpl a1 = new AccountServiceImpl();
		List<Account> accList = a1.viewAllAccounts();
		request.setAttribute("allList", accList);	
		UserServiceImpl u1 = new UserServiceImpl();
		RequestDispatcher rd = request.getRequestDispatcher("viewAllAccount.jsp");
		rd.forward(request, response);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);
	}

}
