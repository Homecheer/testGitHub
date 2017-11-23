package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.CheckStock;
import com.model.InstockRecord;
import com.model.OutstockRecord;
import com.util.DBUtil;

public class CheckStockDao {
	public Connection conn;
	public PreparedStatement pstmt;
	public ResultSet rs;
	public ArrayList<CheckStock> getCheckStocks() {
		PreparedStatement pstm=null;
		String sql=null;
		ResultSet rs=null;
		ResultSet rs1=null;
		ArrayList<CheckStock> aList=new ArrayList<CheckStock>();
		Connection conn=DBUtil.getConn();
		sql="select * from product";
		try {
			conn.setAutoCommit(false);
			pstm=conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while (rs.next()) {
				CheckStock cStock=new CheckStock();
				cStock.setProductCode(rs.getString("productCode"));
				cStock.setName(rs.getString("name"));
				cStock.setPONum(rs.getInt("PONum"));
				cStock.setSONum(rs.getInt("SONum"));
				sql="select num from stock where productCode=?";
				pstm=conn.prepareStatement(sql);
				pstm.setString(1, cStock.getProductCode());
				rs1=pstm.executeQuery();
				while (rs1.next()) {
					cStock.setNum(rs1.getInt("num"));
				}
				aList.add(cStock);
			}
			conn.commit();
		} catch (SQLException e) {
			//数据库回滚
			try {
				conn.rollback();				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DBUtil.close(rs1, null, null);
			DBUtil.close(rs, pstm, conn);
		}
		return aList;
	}
	public void stock(String productCode,int num) {
		PreparedStatement pstm=null;
		String sql=null;
		Connection conn=DBUtil.getConn();
		sql="update stock set num=? where productCode=?";
		try {
			pstm=conn.prepareStatement(sql);
			pstm.setInt(1, num);
			pstm.setString(2, productCode);
			pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(null, pstm, conn);
		}
	}
	public void addCheckStock(String productCode,int ysNum,int sjNum,String time,String people,String reason,String type) {
		PreparedStatement pstm=null;
		String sql=null;
		Connection conn=DBUtil.getConn();
		sql="insert into checkstock(ProductCode,OriginNum,RealNum,StockTime,CreateUser,Description,Type) values(?,?,?,?,?,?,?)";
		try {
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, productCode);
			pstm.setInt(2, ysNum);
			pstm.setInt(3, sjNum);
			pstm.setString(4, time);
			pstm.setString(5, people);
			pstm.setString(6, reason);
			pstm.setString(7, type);
			pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(null, pstm, conn);
		}
	}
	/***仓管****/
	public ArrayList<InstockRecord> allInData(String productCode){//盘点表，实际数量大于应有数量，盘点入库记录
		ArrayList<InstockRecord> al =new ArrayList<InstockRecord>();
		conn=DBUtil.getConn();
		String sql="select * from checkstock where RealNum>OriginNum and ProductCode=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, productCode);
			rs=pstmt.executeQuery();
			while(rs.next()){
				InstockRecord ir =new InstockRecord();
				ir.setStockTime(rs.getString("StockTime"));
				ir.setOrderCode("空");
				ir.setCreateUser(rs.getString("CreateUser"));
				ir.setStockNum(rs.getInt("RealNum")-rs.getInt("OriginNum"));
				ir.setStockType(1);
				al.add(ir);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstmt, conn);
		}
		
		return al;
	}
	
	public ArrayList<OutstockRecord> allOutData(String productCode){//盘点表，实际数量小于应有数量，盘点出库记录
		ArrayList<OutstockRecord> al = new ArrayList<OutstockRecord>();
		conn=DBUtil.getConn();
		String sql="select * from checkstock where RealNum<OriginNum  and ProductCode=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, productCode);
			rs=pstmt.executeQuery();
			while(rs.next()){
				OutstockRecord or =new OutstockRecord();
				or.setStockTime(rs.getString("StockTime"));
				or.setOrderCode("空");
				or.setCreateUser(rs.getString("CreateUser"));
				or.setStockNum(rs.getInt("OriginNum")-rs.getInt("RealNum"));
				or.setStockType(1);
				al.add(or);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstmt, conn);
		}
		return al;
	}
}
