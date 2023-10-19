package com.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Servlet implementation class dbConnection
 */
public class dbConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public static Connection getConnection() {
		
		String url = "jdbc:mysql://localhost:3307/tourguide?verifyServerCertificate=false&useSSL=true";
    	String user = "root";
    	String pass = "201202";
    	Connection con = null ;
    	
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    		
    		con = DriverManager.getConnection(url, user, pass);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
		return con;
	}

}
