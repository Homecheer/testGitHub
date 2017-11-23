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

public class FilterDao {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql;
	public boolean checkModelCode(ScmUser su,String modelcode){
		boolean flag=false;
		sql="select u.modelCode from scmuser s,usermodel u where s.account=u.account and s.account=?;";
		try {
			conn = DBUtil.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, su.getAccount());
			rs = pstmt.executeQuery();
			while(rs.next()){
				if(rs.getString("modelcode").equals(modelcode)){
					flag=true;break;}
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstmt, conn);
		}
		return flag;
	}
}
