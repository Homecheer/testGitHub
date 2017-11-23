package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.DBUtil;

public class CustomerDao {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	public String  getNameByCustomerCode(String CustomerCode){
		String CustomerName=null;
		conn=DBUtil.getConn();
		String sql="select Name from customer where CustomerCode=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, CustomerCode);
			rs=pstmt.executeQuery();
			if(rs.next()){
				CustomerName=rs.getString("Name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstmt, conn);
		}
		return CustomerName;
	}
}
