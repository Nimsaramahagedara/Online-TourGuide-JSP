package com.admin;

import java.sql.*;

import java.util.*;



public class adminDb {

	private static final String INSERT_ADMIN_SQL = "INSERT INTO admin VALUES (?,?, ?, ?,?)";
	private static final String COUNT_ALL_USERS = "select COUNT(id) from user";
	private static final String COUNT_ALL_GUIDERS = "select COUNT(id) from guider";
	private static final String COUNT_ALL_LISTS = "select COUNT(id) from T_package";
	private static final String COUNT_ALL_ORDERS = "select COUNT(id) from orders WHERE  date = curdate();";
	private static final String GET_ALL_ADMINS = "select * from admin";
	private static final String GET_RECENT_ORDERS = "SELECT o.id,t.title, o.gid, o.uid, o.price, o.date FROM  t_package t,orders o WHERE o.gid = t.gid and o.pack_id = t.id  ORDER BY date DESC";
	private static final String UPDATE_ADMIN_SQL = "update admin set email = ?,name= ?, password =?, imageName=? where id = ?;";
	private static final String GET_ALL_USERS = "select * from user;";
	private static final String GET_ALL_GUIDERS = "select * from guider;";
	private static final String DELETE_USER_SQL = "delete from user where id = ?;";
	private static final String DELETE_GUIDER_SQL = "delete from guider where id = ?;";
	private static final String DELETE_TOURS_GUIDER_SQL = "delete from t_package where gid = ?;";
	
	
	/*private static final String SELECT_USER_BY_ID = "select * from ticket where id = ?";
	
	
	
	*/
	
            public static List<admin> validate(String email, String password){
            	
            	ArrayList<admin> cus = new ArrayList<admin>();
            	
            	try {      		
            		Connection con = dbConnection.getConnection();
            		Statement st = con.createStatement();
            		
            		String sql = "SELECT * FROM admin WHERE email='"+email+"' AND password='"+password+"'";
            		ResultSet rs =  st.executeQuery(sql);
            		
            		if(rs.next()) {
            			
            			int id = rs.getInt(1);
            			String em = rs.getString(2);
            			String name = rs.getString(3);
            			String pwd = rs.getString(4);
            			String image = rs.getString(5);
            			
            			admin c = new admin(id, em, name, pwd, image);
            			cus.add(c);
            		}
            		rs.close();
            		con.close();
            	}
            	catch(Exception e) {
            		e.printStackTrace();
            	}
            	return cus;
            }
            
            /*NEW ADMIN CREATION FUNCTION*/ 
            
        	public static void addAdmin (admin a) throws SQLException {
        	
        		System.out.println(INSERT_ADMIN_SQL);
        		try (Connection connection = dbConnection.getConnection();
        				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ADMIN_SQL)) {
        			
        			preparedStatement.setInt(1, a.getId());
        			preparedStatement.setString(2, a.getEmail());
        			preparedStatement.setString(3, a.getName());
        			preparedStatement.setString(4, a.getPassword());
        			preparedStatement.setString(5, a.getImage());
        			System.out.println(preparedStatement);
        			preparedStatement.executeUpdate();
        			
        			preparedStatement.close();
        			connection.close();
  
        			return;
        		
        		} catch (SQLException e) {
        			printSQLException(e);
        			return;
        		}
        	}
        	
        	/*UPDATE ADMIN*/
        	public static void updateAdmin(admin a)throws SQLException {
        		
        		try (Connection connection = dbConnection.getConnection();
        				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ADMIN_SQL)) {
        			
        			
        			preparedStatement.setString(1, a.getEmail());
        			preparedStatement.setString(2, a.getName());
        			preparedStatement.setString(3, a.getPassword());
        			preparedStatement.setString(4, a.getImage());
        			preparedStatement.setInt(5, a.getId());
        			System.out.println(preparedStatement);
        			preparedStatement.executeUpdate();
        			
        			preparedStatement.close();
        			connection.close();
  
        			return;
        		
        		} catch (SQLException e) {
        			printSQLException(e);
        			return;
        		}
        	}
        	
        	/*RETURN USER COUNT*/
        	
        	public static int getUserCount() {
        		int count =0;
        		try {      		
            		Connection con = dbConnection.getConnection();
            		Statement st = con.createStatement();

            		ResultSet rs =  st.executeQuery(COUNT_ALL_USERS);
            		
            		if(rs.next()) {
            			
            			count = rs.getInt(1);
            		}
            	}
            	catch(Exception e) {
            		e.printStackTrace();
            	}
        		return count;
        		
        	}
        	
/*RETURN GUIDER COUNT*/
        	
        	public static int getGuiderCount() {
        		int count =0;
        		try {      		
            		Connection con = dbConnection.getConnection();
            		Statement st = con.createStatement();

            		ResultSet rs =  st.executeQuery(COUNT_ALL_GUIDERS);
            		
            		if(rs.next()) {
            			
            			count = rs.getInt(1);
            		}
            	}
            	catch(Exception e) {
            		e.printStackTrace();
            	}
        		return count;
        		
        	}
/*RETURN GUIDER COUNT*/
        	
        	public static int getListCount() {
        		int count =0;
        		try {      		
            		Connection con = dbConnection.getConnection();
            		Statement st = con.createStatement();

            		ResultSet rs =  st.executeQuery(COUNT_ALL_LISTS);
            		
            		if(rs.next()) {
            			
            			count = rs.getInt(1);
            		}
            	}
            	catch(Exception e) {
            		e.printStackTrace();
            	}
        		return count;
        		
        	}
  /*RETURN AVAILABLE ADMINS*/
        	
        	public static ArrayList <admin> getAllAdmin(){
        		ArrayList <admin> ad = new ArrayList<admin>();
        		
        		try {      		
            		Connection con = dbConnection.getConnection();
            		Statement st = con.createStatement();

            		ResultSet rs =  st.executeQuery(GET_ALL_ADMINS);
            		
            		while(rs.next()) {
            			
            			int id = rs.getInt(1);
            			String em = rs.getString(2);
            			String name = rs.getString(3);
            			String pwd = rs.getString(4);
            			String image = rs.getString(5);
            			
            			admin c = new admin(id, em, name, pwd, image);
            			ad.add(c);
            		}
            		rs.close();
            		st.close();
            		con.close();
            		
            		
            	}
            	catch(Exception e) {
            		e.printStackTrace();
            	}
        		return ad;	
        	}
        	
/*TODAY ORDERS*/
        	public static int getTodayOrders() {
        		int count =0;
        		try {      		
            		Connection con = dbConnection.getConnection();
            		Statement st = con.createStatement();

            		ResultSet rs =  st.executeQuery(COUNT_ALL_ORDERS);
            		
            		if(rs.next()) {
            			
            			count = rs.getInt(1);
            		}
            	}
            	catch(Exception e) {
            		e.printStackTrace();
            	}
        		return count;
        		
        	}
  /*RETURN RECENT TOURS  TOP 7*/
        	
        	
        	public static ArrayList <order> getRecentTours(){
        		ArrayList <order> ad = new ArrayList<order>();
        		
        		try {      		
            		Connection con = dbConnection.getConnection();
            		Statement st = con.createStatement();

            		ResultSet rs =  st.executeQuery(GET_RECENT_ORDERS);
            		
            		while(rs.next()) {
            			
            			int orderid = rs.getInt(1);
            			String title = rs.getString(2);
            			
            			int guiderid = rs.getInt(3);
            			int userid = rs.getInt(4);
            			int price = rs.getInt(5);
            			String date = rs.getString(6);
            		
            			
            			order c = new order(orderid,title, guiderid,userid,price,date);
            			ad.add(c);
            		}
            		
            	}
            	catch(Exception e) {
            		System.out.println("ERROR AT THIS 217 LINE");
            		e.printStackTrace();
            	}
        		return ad;	
        	}
        	
        	
        	/*GET ALL USERS*/
        	public static ArrayList <user> getAllUsers(){
        		ArrayList <user> ad = new ArrayList<user>();
        		
        		try {      		
            		Connection con = dbConnection.getConnection();
            		Statement st = con.createStatement();

            		ResultSet rs =  st.executeQuery(GET_ALL_USERS);
            		
            		while(rs.next()) {
            			
            			int id = rs.getInt(1);
            			String name = rs.getString(2);
            			String em = rs.getString(3);
            			String phone = rs.getString(4);
            			String pwd = rs.getString(5);
            			String addr = rs.getString(6);
            			String image = rs.getString(7);
            			
            			user c = new user(id, name,em, phone,pwd, addr,image);
            			ad.add(c);
            		}
            		rs.close();
            		st.close();
            		con.close();
            		
            		
            	}
            	catch(Exception e) {
            		e.printStackTrace();
            	}
        		return ad;	
        	}

 /*DELETE USER*/
        	public static void deleteUser(int id)throws SQLException {
        		
        		try (Connection connection = dbConnection.getConnection();
        				PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_SQL)) {
        			
        			preparedStatement.setInt(1, id);
        			System.out.println(preparedStatement);
        			preparedStatement.executeUpdate();
        			
        			preparedStatement.close();
        			connection.close();
  
        			return;
        		
        		} catch (SQLException e) {
        			printSQLException(e);
        			return;
        		}
        	}
        	
  /*DELETE GUIDER*/
        	public static void deleteGuider(int id)throws SQLException {
        		
        		try (Connection connection = dbConnection.getConnection();
        				PreparedStatement preparedStatement = connection.prepareStatement(DELETE_GUIDER_SQL)) {
        			
        			PreparedStatement prepared2 = connection.prepareStatement(DELETE_TOURS_GUIDER_SQL);
        			prepared2.setInt(1,id);
        			preparedStatement.setInt(1, id);
        			
        			System.out.println(preparedStatement);
        			prepared2.executeUpdate();
        			preparedStatement.executeUpdate();
        			
        			prepared2.close();
        			preparedStatement.close();
        			connection.close();
  
        			return;
        		
        		} catch (SQLException e) {
        			printSQLException(e);
        			return;
        		}
        	}
        	
        	
        	/*GET ALL USERS*/
        	public static ArrayList <user> getAllGuiders(){
        		ArrayList <user> ad = new ArrayList<user>();
        		
        		try {      		
            		Connection con = dbConnection.getConnection();
            		Statement st = con.createStatement();

            		ResultSet rs =  st.executeQuery(GET_ALL_GUIDERS);
            		
            		while(rs.next()) {
            			
            			int id = rs.getInt(1);
            			String name = rs.getString(2);
            			String em = rs.getString(3);
            			String phone = rs.getString(4);
            			String pwd = rs.getString(5);
            			String addr = rs.getString(6);
            			String image = rs.getString(7);
            			
            			user c = new user(id, name,em, phone,pwd, addr,image);
            			ad.add(c);
            		}
            		rs.close();
            		st.close();
            		con.close();
            		
            		
            	}
            	catch(Exception e) {
            		e.printStackTrace();
            	}
        		return ad;	
        	}
        	
        	public static void printSQLException(SQLException ex) {
        		for (Throwable e : ex) {
        			if (e instanceof SQLException) {
        				e.printStackTrace(System.err);
        				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
        				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
        				System.err.println("Message: " + e.getMessage());
        				Throwable t = ex.getCause();
        				while (t != null) {
        					System.out.println("Cause: " + t);
        					t = t.getCause();
        				}
        			}
        		}
        	}
        	
        	
            
}
