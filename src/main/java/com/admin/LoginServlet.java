package com.admin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;



public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("WE ARE INSIDE THE LOGIN SERVLET");
		String username = request.getParameter("userid");
		String password = request.getParameter("passid");
		
		try {
			List<admin> cusDetails = adminDb.validate(username, password);
			if(cusDetails.isEmpty()) {
				request.setAttribute("error", "Username or Password Invalid !");
				RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
				dis.forward(request, response);
				return;
			}else {
			HttpSession session = request.getSession();
			session.setAttribute("cusData", cusDetails);

			RequestDispatcher dis = request.getRequestDispatcher("AdminHandler?action=dashboard");
			dis.forward(request, response);
			return;
			}
		}catch(Exception e) {
			System.out.println("Servlet Exception Found On LoginServlet.");
			
			e.printStackTrace();
			return;
		}	
	}
	

}
