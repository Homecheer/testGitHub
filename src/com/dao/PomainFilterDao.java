package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.model.Pomain;
import com.model.ScmUser;
import com.util.DBUtil;

public class PomainFilterDao {
	Connection conn;
	Statement stmt;
	ResultSet rs;
	String sql;
	public boolean getFilter(ScmUser su){
		boolean flag=false;
		sql="select sy.modelName from usermodel u,systemmodel sy,scmuser sc where sc.account=u.account and u.modelCode=sy.modelCode and u.account='"+su.getAccount()+"'";
		
		try {
			conn = DBUtil.getConn();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				if(rs.getString("modelName").equals("采购")||rs.getString("modelName").equals("管理员")){
					flag=true;
					break;
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, stmt, conn);
		}
		return flag;
	}
}
