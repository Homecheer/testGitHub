package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.Poitem;
import com.util.DBUtil;

public class PoitemDao {
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	public ArrayList<Poitem> getPoItems(String poid) {
		ArrayList<Poitem> aList=new ArrayList<Poitem>();
		String sql="";
		pstmt=null;
		rs=null;
		conn=DBUtil.getConn();
		sql="select * from poitem where poid=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, poid);
			rs=pstmt.executeQuery();
			while (rs.next()) {
				Poitem pItem=new Poitem();
				pItem.setPoid(rs.getString("poid"));
				pItem.setProductCode(rs.getString("productcode"));
				pItem.setUnitPrice(rs.getFloat("UnitPrice"));
				pItem.setNum(rs.getInt("num"));
				pItem.setUnitName(rs.getString("UnitName"));
				pItem.setItemPrice(rs.getFloat("ItemPrice"));
				aList.add(pItem);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstmt, conn);
		}
		return aList;
	}
	public ArrayList<Poitem> selectPoitemData(String poid){
		ArrayList<Poitem> alpoitem =new ArrayList<Poitem>();
		conn=DBUtil.getConn();
		String sql="select * from poitem where POID=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, poid);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Poitem poitem=new Poitem();
				poitem.setPoid(rs.getString("POID"));
				poitem.setProductCode(rs.getString("ProductCode"));
				poitem.setUnitPrice(rs.getFloat("UnitPrice"));
				poitem.setNum(rs.getInt("Num"));
				poitem.setUnitName(rs.getString("UnitName"));
				poitem.setItemPrice(rs.getFloat("ItemPrice"));
				alpoitem.add(poitem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstmt, conn);
		}
		
		return alpoitem;
	}
}
