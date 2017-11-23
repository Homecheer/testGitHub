package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.Soitem;
import com.util.DBUtil;

public class SoitemDao {
	public Connection conn;
	public PreparedStatement pstmt;
	public ResultSet rs;
	public ArrayList<Soitem> getSoItems(String soid) {
		ArrayList<Soitem> aList=new ArrayList<Soitem>();
		String sql="";
		PreparedStatement pstm=null;
		ResultSet rs=null;
		Connection conn=DBUtil.getConn();
		sql="select * from soitem where soid=?";
		try {
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, soid);
			rs=pstm.executeQuery();
			while (rs.next()) {
				Soitem sItem=new Soitem();
				sItem.setSoid(rs.getString("soid"));
				sItem.setProductCode(rs.getString("productcode"));
				sItem.setUnitPrice(rs.getFloat("UnitPrice"));
				sItem.setNum(rs.getInt("num"));
				sItem.setUnitName(rs.getString("UnitName"));
				sItem.setItemPrice(rs.getFloat("ItemPrice"));
				aList.add(sItem);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstm, conn);
		}
		return aList;
	}
	
	public ArrayList<Soitem> selectSoitemData(String soid){
		ArrayList<Soitem> alsoitem =new ArrayList<Soitem>();
		conn=DBUtil.getConn();
		String sql="select * from soitem where SOID=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, soid);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Soitem soitem=new Soitem();
				soitem.setSoid(rs.getString("SOID"));
				soitem.setProductCode(rs.getString("ProductCode"));
				soitem.setUnitPrice(rs.getFloat("UnitPrice"));
				soitem.setNum(rs.getInt("Num"));
				soitem.setUnitName(rs.getString("UnitName"));
				soitem.setItemPrice(rs.getFloat("ItemPrice"));
				alsoitem.add(soitem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstmt, conn);
		}
		
		return alsoitem;
	}
}
