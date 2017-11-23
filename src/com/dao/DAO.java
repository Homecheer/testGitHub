package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {
	public static String user ="root";
	public static String password ="123456";
	public static String url="jdbc:mysql://localhost:3306/scm";
	
	static {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			//System.out.println("loadsuccess");
		}catch (ClassNotFoundException e){
			System.err.println(e.getMessage());
		}
	}
	
	public static Connection getConn(){
		Connection con =null;
		try{
			con=DriverManager.getConnection(url, user, password);
			//System.out.println("connection");
			
		}catch(SQLException e){
			System.err.println("failconnection");
		}
		return con;
	}
	
	public static void finish(ResultSet rs,Statement sta,Connection con){
		try{
			if (rs != null){
			rs.close();
			rs = null;
		}
		if (sta!=null){
			sta.close();
			sta=null;
		}
		if(con!=null){
			con.close();
			con = null;
		}
		//System.out.println("closesuccess");
		}catch (SQLException e){
			System.err.println(e.getMessage());
		}
	}
	
}
