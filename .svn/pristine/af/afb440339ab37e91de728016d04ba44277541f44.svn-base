package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import com.model.InstockRecord;
import com.model.Poitem;
import com.mysql.jdbc.exceptions.jdbc4.MySQLNonTransientConnectionException;
import com.util.DBUtil;

public class InStockRecordDao {
	public Connection conn;
	public PreparedStatement pstmt;
	public ResultSet rs;
	
	public void inStock(String poid,Poitem p,String name) throws SQLException{ //name为经手人
		try {
			conn=DBUtil.getConn();
			conn.setAutoCommit(false);
			String sql="insert into instockrecord(ProductCode,OrderCode,StockNum,StockType,StockTime,CreateUser) values(?,?,?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, p.getProductCode());
			pstmt.setString(2, poid); 
			pstmt.setInt(3, p.getNum());
			pstmt.setInt(4, 0);//0为采购入库
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
	public ArrayList<InstockRecord> selectByDate(String year,String month){//入库报表
		ArrayList<InstockRecord> alInstockRecord =new ArrayList<InstockRecord>();
		conn=DBUtil.getConn();
		String sql="select * from instockrecord where StockTime like ?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,year+"-"+month+"%" );
			rs=pstmt.executeQuery();
			while(rs.next()){
				InstockRecord ir=new InstockRecord();
				ir.setStockID(rs.getInt("StockID"));
				ir.setProductCode(rs.getString("ProductCode"));
				ir.setOrderCode(rs.getString("OrderCode"));
				ir.setStockNum(rs.getInt("StockNum"));
				ir.setStockType(rs.getInt("StockType"));
				ir.setStockTime(rs.getString("StockTime"));
				ir.setCreateUser(rs.getString("CreateUser"));
				alInstockRecord.add(ir);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstmt, conn);
		}
		
		return alInstockRecord;
	}
	public int totalList(String year,String month){  //入库报表 总单数
		int total=0;
		conn=DBUtil.getConn();
		String sql="select OrderCode,count(*) counts from instockrecord where StockTime like ? group by OrderCode ;";
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
		}finally{
			DBUtil.close(rs, pstmt, conn);
		}
		
		return total;
	}
	public ArrayList<InstockRecord> selectAllInstockRecordByProductCode(String productCode){
		ArrayList<InstockRecord> alInstockRecord =new ArrayList<InstockRecord>();
		conn=DBUtil.getConn();
		String sql="select * from instockrecord where ProductCode=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, productCode);
			rs=pstmt.executeQuery();
			while(rs.next()){
				InstockRecord ir=new InstockRecord();
				ir.setStockTime(rs.getString("StockTime"));
				ir.setOrderCode(rs.getString("OrderCode"));
				ir.setCreateUser(rs.getString("CreateUser"));
				ir.setStockNum(rs.getInt("StockNum"));
				ir.setStockType(rs.getInt("StockType"));
				alInstockRecord.add(ir);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstmt, conn);
		}
		return alInstockRecord;
	}
	public float poOneProductTotalPrice(String orderCode,String productCode){//采购详单中找到某个产品的总价
		conn=DBUtil.getConn();
		float price=0f;
		String sql="select i.ItemPrice from pomain m,poitem i where m.POID=i.POID and m.POID=? and i.ProductCode=?";
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
