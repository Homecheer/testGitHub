package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.model.PomainPage;
import com.model.Pomain;
import com.util.DBUtil;

public class PomainPageDao {
	Connection conn;
	Statement stmt;
	ResultSet rs;
	String sql;
	public void setToTalPage(String table,PomainPage page){
		sql="select count(*) count from "+table;
		try {
			conn = DBUtil.getConn();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				page.setToTalPage(rs.getInt("count")%page.getPageSize()==0?rs.getInt("count")/page.getPageSize():rs.getInt("count")/page.getPageSize()+1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, stmt, conn);
		}
	}
	public void setData(ArrayList al,PomainPage page){
		page.setData(al);
	}
}
