package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;


import com.model.InstockRecord;
import com.model.OutstockRecord;

import com.model.Soitem;
import com.mysql.jdbc.exceptions.jdbc4.MySQLNonTransientConnectionException;
import com.util.DBUtil;

public class OutStockRecordDao {
	public Connection conn;
	public PreparedStatement pstmt;
	public ResultSet rs;
	
	public void outStock(String soid,Soitem s,String name) throws SQLException{ //name为经手人
		try {
			conn=DBUtil.getConn();
			conn.setAutoCommit(false);
			String sql="insert into outstockrecord(ProductCode,OrderCode,StockNum,StockType,StockTime,CreateUser) values(?,?,?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, s.getProductCode());
			pstmt.setString(2, soid); 
			pstmt.setInt(3, s.getNum());
			pstmt.setInt(4, 1);//1为销售出库
			pstmt.setString(5,this.nowDate() );
			pstmt.setString(6, name);
			pstmt.executeUpdate();
			conn.commit();
		} catch (MySQLNonTransientConnectionException e) {
			DBUtil.close(rs, pstmt, conn); 
		}
	}
		public String nowDate(){
		Calendar c=Calendar.getInstance();
		String year=String.valueOf(c.get(Calendar.YEAR));
		String month=String.valueOf(c.get(Calendar.MONTH)+1);
		if(Integer.parseInt(month)<10){
			month="0"+month;
		}
		String day=String.valueOf(c.get(Calendar.DAY_OF_MONTH));
		if(Integer.parseInt(day)<10){
			day="0"+day;
		}
		String hour=String.valueOf(c.get(Calendar.HOUR_OF_DAY));
		if(Integer.parseInt(hour)<10){
			hour="0"+hour;
		}
		String min=String.valueOf(Calendar.MINUTE);
		if(Integer.parseInt(min)<10){
			min="0"+min;
		}
		String second=String.valueOf(Calendar.SECOND);
		if(Integer.parseInt(second)<10){
			second="0"+second;
		}
		String nowDate=year+"-"+month+"-"+day+" "+hour+":"+min+":"+second;
		return nowDate;
	}
	public int totalList(String year,String month){  //出库报表 总单数
		int total=0;
		conn=DBUtil.getConn();
		String sql="select OrderCode,count(*) counts from outstockrecord where StockTime like ? group by OrderCode;";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,year+"-"+month+"%" );
			rs=pstmt.executeQuery();
			while(rs.next()){
				total++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return total;
	}
	
	public ArrayList<OutstockRecord> selectByDate(String year,String month){ //出库报表
		ArrayList<OutstockRecord> alOutstockRecord =new ArrayList<OutstockRecord>();
		conn=DBUtil.getConn();
		String sql="select * from outstockrecord where StockTime like ?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,year+"-"+month+"%" );
			rs=pstmt.executeQuery();
			while(rs.next()){
				OutstockRecord or=new OutstockRecord();
				or.setStockID(rs.getInt("StockID"));
				or.setProductCode(rs.getString("ProductCode"));
				or.setOrderCode(rs.getString("OrderCode"));
				or.setStockNum(rs.getInt("StockNum"));
				or.setStockType(rs.getInt("StockType"));
				or.setStockTime(rs.getString("StockTime"));
				or.setCreateUser(rs.getString("CreateUser"));
				alOutstockRecord.add(or);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return alOutstockRecord;
	}
	
	public ArrayList<OutstockRecord> selectAllOutstockRecordByProductCode(String productCode){
		ArrayList<OutstockRecord> alOutstockRecord =new ArrayList<OutstockRecord>();
		conn=DBUtil.getConn();
		String sql="select * from outstockrecord where ProductCode=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, productCode);
			rs=pstmt.executeQuery();
			while(rs.next()){
				OutstockRecord or=new OutstockRecord();
				or.setStockTime(rs.getString("StockTime"));
				or.setOrderCode(rs.getString("OrderCode"));
				or.setCreateUser(rs.getString("CreateUser"));
				or.setStockNum(rs.getInt("StockNum"));
				or.setStockType(rs.getInt("StockType"));
				alOutstockRecord.add(or);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstmt, conn);
		}
		return alOutstockRecord;
	}
	public float soOneProductTotalPrice(String orderCode, String productCode) {
		conn=DBUtil.getConn();
		float price=0f;
		String sql="select i.ItemPrice from somain m,soitem i where m.SOID=i.SOID and m.SOID=? and i.ProductCode=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, orderCode);
			pstmt.setString(2, productCode);
			rs=pstmt.executeQuery();
			if(rs.next()){
				price=rs.getFloat("ItemPrice");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return price;
	}
}
