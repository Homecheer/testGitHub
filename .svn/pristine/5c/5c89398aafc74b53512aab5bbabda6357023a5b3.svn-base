package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConn(){
		Connection conn=null;
		try {
			conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/scm","root","123456");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return conn;
	}
	public static void close(ResultSet rs,Statement stmt,Connection conn){
		try {
			if(rs!=null){
				rs.close();
				rs=null;	
			}
			if(stmt!=null){
				stmt.close();
				stmt=null;	
			}
			if(conn!=null){
				conn.close();	
				conn=null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
