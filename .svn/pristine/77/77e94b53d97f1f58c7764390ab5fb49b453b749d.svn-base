package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.Stock;
import com.mysql.jdbc.exceptions.jdbc4.MySQLNonTransientConnectionException;
import com.util.DBUtil;

public class StockDao {
	public Connection conn;
	public PreparedStatement pstmt;
	public ResultSet rs;
	public ArrayList<String> productStockNumIsGreaterThanZero(String [] productCode){
		ArrayList<String> alGreaterThanZeroProductCode =new ArrayList<String>();
		conn = DBUtil.getConn();

		try {
			for (int i = 1; i < productCode.length; i++) {
				String sql = "select * from stock where ProductCode=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, productCode[i]);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					if(rs.getInt("Num")>0){
						String Code=rs.getString("ProductCode");
						alGreaterThanZeroProductCode.add(Code);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
		return alGreaterThanZeroProductCode;
	}
	public void deleteProduct(String [] productCode){
		
		conn = DBUtil.getConn();

		try {
			for (int i = 1; i < productCode.length; i++) {
				String sql = "delete  from stock where ProductCode=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, productCode[i]); 
				pstmt.executeUpdate();				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
		
	}
	
	public void updateNum_In(String productCode,int Num) throws SQLException{   //根据产品编号修改库存数  
		try {
			conn=DBUtil.getConn();
			String sql="select Num from stock where ProductCode=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, productCode);
			rs=pstmt.executeQuery();
			int oldNum=0;
			if(rs.next()){
				oldNum=rs.getInt("Num");
			}
			conn.setAutoCommit(false);
			sql="update stock set Num=? where ProductCode=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, oldNum+Num);
			pstmt.setString(2, productCode) ;
			pstmt.executeUpdate();
			conn.commit();
		} catch (MySQLNonTransientConnectionException e) {
			e.printStackTrace();
			DBUtil.close(rs, pstmt, conn); 
		}
	}
	public void updateNum_Out(String productCode,int Num) throws SQLException{   //根据产品编号修改库存数  
		try {
			conn=DBUtil.getConn();
			String sql="select Num from stock where ProductCode=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, productCode);
			rs=pstmt.executeQuery();
			int oldNum=0;
			if(rs.next()){
				oldNum=rs.getInt("Num");
			}
			conn.setAutoCommit(false);
			sql="update stock set Num=? where ProductCode=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, oldNum-Num);
			pstmt.setString(2, productCode) ;
			pstmt.executeUpdate();
			conn.commit();
		} catch (MySQLNonTransientConnectionException e) {
			DBUtil.close(rs, pstmt, conn); 
		}
	}
	public ArrayList<Stock> selectAll(){
		ArrayList<Stock> alStock=new ArrayList<Stock>();
		conn=DBUtil.getConn();
		String sql="select * from stock";
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Stock s=new Stock();
				s.setProductCode(rs.getString("ProductCode"));
				s.setName(rs.getString("name"));
				s.setUnitName(rs.getString("UnitName"));
				s.setNum(rs.getInt("Num"));
				alStock.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstmt, conn);
		}
		return alStock;
	}

	public ArrayList<Stock> selectByConditions(String sql){
		ArrayList<Stock> alStock=new ArrayList<Stock>();
		conn=DBUtil.getConn();
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Stock s=new Stock();
				s.setProductCode(rs.getString("ProductCode"));
				s.setName(rs.getString("name"));
				s.setUnitName(rs.getString("UnitName"));
				s.setNum(rs.getInt("Num"));
				alStock.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstmt, conn);
		}
		return alStock;
	}
}
