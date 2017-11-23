package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.Pomain;
import com.model.Somain;
import com.util.DBUtil;

public class QueryInOrOutDao {
	//查询销售单
	public ArrayList<Somain> getSoMains(String sqlAll) {
		ArrayList<Somain> aList=new ArrayList<Somain>();
		PreparedStatement pstm=null;
		ResultSet rs=null;
		String sql=null;
		Connection conn=DBUtil.getConn();
		sql=sqlAll;
		//System.out.println(sql);
		try {
			pstm=conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while (rs.next()) {
				Somain sMain=new Somain();
				sMain.setSoid(rs.getString("soid"));
				sMain.setPayTime(rs.getString("paytime"));
				sMain.setSoTotal(rs.getFloat("sototal"));
				sMain.setPrePayTime(rs.getString("prepaytime"));
				sMain.setPrePayUser(rs.getString("PrePayUser"));
				sMain.setPayUser(rs.getString("payuser"));
				sMain.setPayType(rs.getString("paytype"));
				aList.add(sMain);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstm, conn);
		}
		return aList;
	}
	//查询订购单
	public ArrayList<Pomain> getPoMains(String sqlAll) {
		ArrayList<Pomain> aList=new ArrayList<Pomain>();
		PreparedStatement pstm=null;
		ResultSet rs=null;
		String sql=null;
		Connection conn=DBUtil.getConn();
		sql=sqlAll;
		try {
			pstm=conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while (rs.next()) {
				Pomain pMain=new Pomain();
				pMain.setPoid(rs.getString("poid"));
				pMain.setPayTime(rs.getString("paytime"));
				pMain.setPoTotal(rs.getFloat("pototal"));
				pMain.setPrePayTime(rs.getString("prepaytime"));
				pMain.setPrePayUser(rs.getString("PrePayUser"));
				pMain.setPayUser(rs.getString("payuser"));
				pMain.setPayType(rs.getString("paytype"));
				aList.add(pMain);
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
