package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.DBUtil;

public class IoFormDao {
	public float getSoTotal(String date) {
		PreparedStatement pstm=null;
		ResultSet rs=null;
		String sql=null;
		Connection conn=DBUtil.getConn();
		float soTotal=0;
		sql="select sototal from somain where paytime like '"+date+"%'";
		try {
			pstm=conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while (rs.next()) {
				soTotal+=rs.getFloat("sototal");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstm, conn);
		}
		
		return soTotal;
	}
	
	public float getPoTotal(String date) {
		PreparedStatement pstm=null;
		ResultSet rs=null;
		String sql=null;
		Connection conn=DBUtil.getConn();
		float poTotal=0;
		sql="select pototal from pomain where paytime like '"+date+"%'";
		try {
			pstm=conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while (rs.next()) {
				poTotal+=rs.getFloat("pototal");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstm, conn);
		}
		
		return poTotal;
	}
	
	public int getSoCount(String date) {
		PreparedStatement pstm=null;
		ResultSet rs=null;
		String sql=null;
		Connection conn=DBUtil.getConn();
		int soCount=0;
		sql="select COUNT(*) c from somain where paytime like '"+date+"%'";
		try {
			pstm=conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while (rs.next()) {
				soCount=rs.getInt("c");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstm, conn);
		}
		
		return soCount;
	}
	
	public int getPoCount(String date) {
		PreparedStatement pstm=null;
		ResultSet rs=null;
		String sql=null;
		Connection conn=DBUtil.getConn();
		int poCount=0;
		sql="select COUNT(*) c from pomain where paytime like '"+date+"%'";
		try {
			pstm=conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while (rs.next()) {
				poCount=rs.getInt("c");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstm, conn);
		}
		
		return poCount;
	}
}
