package com.admin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class AdminHandler
 */
public class AdminHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	String action = request.getParameter("action");
	
	try {
		switch (action) {
		case "dashboard":
			dashboard(request,response);
			break;
		case "addpage":
			addpage(request,response);
			break;
			
		case "customers":
			customers(request,response);
			break;
		case "deleteGuide":
			deleteGuider(request, response);
			break;
		case "delete":
			deleteuser(request, response);
			break;
		case "guiders":
			guiders(request,response);
			break;
	
		default:
			dashboard(request,response);
			break;
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String action = request.getParameter("action");
		System.out.println(action);
		
		try {
			switch (action) {
			case "add":
				addAdmin(request,response);
				break;
				
			case "dashboard":
				dashboard(request,response);
				break;
			/*case "delete":
				deleteticket(request, response);
				break;*/
			case "update":
				update(request, response);
				break;
			/*default:
				dashboard(request,response);
				break;*/
				
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}finally {
			action = "dashboard";
		}
		
		
		
		
	}
	
	

	private void addAdmin(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException,ServletException {
		int id = Integer.valueOf(request.getParameter("id"));
		String pwd = request.getParameter("pass");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		
		String img = request.getParameter("img");
		admin ad = new admin(id,email,name,pwd,img);
		
		adminDb.addAdmin(ad);
		
		RequestDispatcher dis = request.getRequestDispatcher("AdminHandler?action=dashboard");
		dis.forward(request,response);
		
		return;
	}
	private void dashboard(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException,ServletException {
		int userCount = adminDb.getUserCount();
		int guiderCount = adminDb.getGuiderCount();
		int listCount = adminDb.getListCount();
		int	todayOrders = adminDb.getTodayOrders();
		ArrayList <order> recT = adminDb.getRecentTours();
		if(recT.isEmpty()) {
			order or = new order(0,"NO_ORDERS_YET",0,0,0,"0000-00-00"); 
			recT.add(or);
			System.out.println("RECENT ORDER IS EMPTY");
		}
		
		request.setAttribute("userCount", userCount);
		request.setAttribute("guiderCount", guiderCount);
		request.setAttribute("listCount", listCount);
		request.setAttribute("orderCount", todayOrders);
		request.setAttribute("RecentTours", recT);
		
		RequestDispatcher dis = request.getRequestDispatcher("admin.jsp");
		dis.forward(request, response);
		
	}
	/*Account Page*/
	private void update(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException,ServletException {
		try {
			
			int id = Integer.valueOf(request.getParameter("id"));
			String pwd = request.getParameter("password");
			String email = request.getParameter("email");
			String name = request.getParameter("name");
			
			String img = request.getParameter("img");
			admin ad = new admin(id,email,name,pwd,img);
		
			adminDb.updateAdmin(ad);
			List<admin> cus = new ArrayList<admin>();
			cus.add(ad);
			HttpSession session = request.getSession();
			session.setAttribute("cusData", cus);
			RequestDispatcher dis = request.getRequestDispatcher("AdminHandler?action=dashboard");
			dis.forward(request,response);
			return;
		}catch(Exception e){
			e.printStackTrace();
			
		}
	}

	
	/*PRE RUN THUIS BEFORE GO TO addAdmin Page*/
	private void addpage(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException,ServletException {
		try {
		ArrayList <admin> ad = adminDb.getAllAdmin();
		request.setAttribute("admins", ad);
		RequestDispatcher dis = request.getRequestDispatcher("addAdmin.jsp");
		dis.forward(request,response);
		return;
		}catch(Exception e){
			e.printStackTrace();
			
		}
	}
	
	private void customers(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException,ServletException {
		
		try {
			ArrayList <user> us = adminDb.getAllUsers();
			request.setAttribute("users", us);
			RequestDispatcher dis = request.getRequestDispatcher("users.jsp");
			dis.forward(request,response);
			return;
			}catch(Exception e){
				e.printStackTrace();
				
			}
	}
	private void guiders(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException,ServletException {
		
		try {
			ArrayList <user> us = adminDb.getAllGuiders();
			request.setAttribute("users", us);
			RequestDispatcher dis = request.getRequestDispatcher("guiders.jsp");
			dis.forward(request,response);
			return;
			}catch(Exception e){
				e.printStackTrace();
				
			}
	}
	
	private void deleteuser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException,ServletException {
		int id = Integer.valueOf(request.getParameter("id"));
		
		adminDb.deleteUser(id);
		
		RequestDispatcher dis = request.getRequestDispatcher("AdminHandler?action=customers");
		dis.forward(request,response);
		
		return;
	}
	private void deleteGuider(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException,ServletException {
		int id = Integer.valueOf(request.getParameter("id"));
		
		adminDb.deleteGuider(id);
		
		RequestDispatcher dis = request.getRequestDispatcher("AdminHandler?action=customers");
		dis.forward(request,response);
		
		return;
	}
}
