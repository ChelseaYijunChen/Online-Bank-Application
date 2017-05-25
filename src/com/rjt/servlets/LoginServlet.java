package com.rjt.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		throw new UnsupportedOperationException("HTTP GET request is not allowed!");
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
	    
		HttpSession session=request.getSession();  
	    session.setAttribute("email",email); 
		
	    String page = "userhome.jsp";
		PrintWriter out = response.getWriter();
		
		if(DBUtil.isPwordCorrect(email,password)){
			if(DBUtil.isAdmin(email)){
				page = "adminhome.jsp";
			}else{
				page = "userhome.jsp";
			}
			
		}else{
//			out.println("User name and Password does not match");
			page = "wrongPassword.jsp";
		}	
		//RequestDispatcher rd = request.getRequestDispatcher(page);
		//rd.forward(request, response);
		
		response.sendRedirect(page);
	}

}
