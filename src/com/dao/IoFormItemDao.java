package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.Pomain;
import com.model.Somain;
import com.util.DBUtil;

public class IoFormItemDao {
	public ArrayList<Somain> getIoFormItem(String date) {
		PreparedStatement pstm=null;
		ResultSet rs=null;
		String sql=null;
		ArrayList<Somain> aList=new ArrayList<Somain>();
		Connection conn=DBUtil.getConn();
		sql="select soid,createtime,paytime,sototal,status,payuser from somain where paytime like '"+date+"%'";
		try {
			pstm=conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while (rs.next()) {
				Somain soMain=new Somain();
				soMain.setSoid(rs.getString("soid"));
				soMain.setCreateTime(rs.getString("createtime"));
				soMain.setPayTime(rs.getString("paytime"));
				soMain.setSoTotal(rs.getFloat("sototal"));
				soMain.setStatus(rs.getInt("status"));
				soMain.setPayUser(rs.getString("payuser"));
				aList.add(soMain);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstm, conn);
		}
		return aList;
	}
	
	public ArrayList<Pomain> getIoFormItem1(String date) {
		PreparedStatement pstm=null;
		ResultSet rs=null;
		String sql=null;
		ArrayList<Pomain> aList=new ArrayList<Pomain>();
		Connection conn=DBUtil.getConn();
		sql="select poid,createtime,paytime,pototal,status,payuser from pomain where paytime like '"+date+"%'";
		try {
			pstm=conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while (rs.next()) {
				Pomain poMain=new Pomain();
				poMain.setPoid(rs.getString("poid"));
				poMain.setCreateTime(rs.getString("createtime"));
				poMain.setPayTime(rs.getString("paytime"));
				poMain.setPoTotal(rs.getFloat("pototal"));
				poMain.setStatus(rs.getInt("status"));
				poMain.setPayUser(rs.getString("payuser"));
				aList.add(poMain);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstm, conn);
		}
		return aList;
	}
}
