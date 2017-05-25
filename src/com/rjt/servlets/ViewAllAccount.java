package com.rjt.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hibernate.service.AccountServiceImpl;

@WebServlet("/ViewAllAccount")
public class ViewAllAccount extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		ArrayList<String> accList = DBUtil.getAllAccount();
		ArrayList<String> userList = DBUtil.getAllUser();
		int accountNum;
		double balance;
		
		
		
		for(int i = 0; i< accList.size(); i++){			
//			out.print(list.get(i) );
			String[] res = accList.get(i).split(" ");
			 accountNum = Integer.parseInt(res[0]);
			 balance = Integer.parseInt(res[1]);
			 
//			out.println( "<a href='Delete?eid="+id+"'> Delete </a>");
//			out.println("<br>");
		}	
	}

}
