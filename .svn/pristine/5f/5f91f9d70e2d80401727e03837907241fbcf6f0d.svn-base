package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import com.model.Pomain;
import com.model.ScmUser;
import com.mysql.jdbc.exceptions.jdbc4.MySQLNonTransientConnectionException;
import com.util.DBUtil;

public class PomainDao {
	public Connection conn;
	public PreparedStatement pstmt;
	public ResultSet rs;
	public ArrayList<Pomain> getPoMains() {
		String sql=null;
		ArrayList<Pomain> aList=new ArrayList<Pomain>();
		PreparedStatement pstm=null;
		ResultSet rs=null;
		ResultSet rs1=null;
		Connection conn=null;
		sql="select * from pomain";
		try {
			conn=DBUtil.getConn();
			//改为手动提交
			conn.setAutoCommit(false);
			pstm=conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while (rs.next()) {
				Pomain poMain=new Pomain();
				poMain.setPoid(rs.getString("POID"));
				poMain.setCreateTime(rs.getString("createtime"));
				poMain.setVenderCode(rs.getString("venderCode"));
				poMain.setAccount(rs.getString("account"));
				poMain.setTipFee(rs.getFloat("TipFee"));
				poMain.setProductTotal(rs.getFloat("ProductTotal"));
				poMain.setPoTotal(rs.getFloat("pototal"));
				poMain.setPayType(rs.getString("paytype"));
				poMain.setPrePayFee(rs.getFloat("PrePayFee"));
				poMain.setStatus(rs.getInt("Status"));
				sql="select name from vender where VenderCode =?";
				pstm=conn.prepareStatement(sql);
				pstm.setString(1, poMain.getVenderCode());
				rs1=pstm.executeQuery();
				while (rs1.next()) {
					poMain.setVenderName(rs1.getString("name"));
					
				}
				sql="select name from scmuser where account=?";
				pstm=conn.prepareStatement(sql);
				pstm.setString(1, poMain.getAccount());
				rs1=pstm.executeQuery();
				while (rs1.next()) {
					poMain.setUserName(rs1.getString("name"));
					
				}
				aList.add(poMain);
			}
			//提交到数据库
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
			//提交方式再改为自动提交
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
	//根据用户账号查询该账号是否在采购单中
	public ArrayList<Pomain> getAccount(String account) {
		String sql=null;
		ArrayList<Pomain> aList=new ArrayList<Pomain>();
		PreparedStatement pstm=null;
		ResultSet rs=null;
		Connection conn=DBUtil.getConn();
		sql="select * from pomain where account=?";
		try {
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, account);
			rs=pstm.executeQuery();
			while (rs.next()) {
				Pomain poMain=new Pomain();
				poMain.setPoid(rs.getString("POID"));
				poMain.setCreateTime(rs.getString("createtime"));
				poMain.setVenderCode(rs.getString("venderCode"));
				poMain.setAccount(rs.getString("account"));
				poMain.setTipFee(rs.getFloat("TipFee"));
				poMain.setProductTotal(rs.getFloat("ProductTotal"));
				poMain.setPoTotal(rs.getFloat("pototal"));
				poMain.setPayType(rs.getString("paytype"));
				poMain.setPrePayFee(rs.getFloat("PrePayFee"));
				poMain.setStatus(rs.getInt("Status"));
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
	
	
	
	public void updatePoMains(String poid,int status,String payTime,String payUser) {
		PreparedStatement pstm=null;
		String sql=null;
		Connection conn=DBUtil.getConn();
		sql="update pomain set status=?,paytime=?,payuser=? where poid=?";
		try {
			pstm=conn.prepareStatement(sql);
			pstm.setInt(1, status);
			pstm.setString(2, payTime);
			pstm.setString(3, payUser);
			pstm.setString(4, poid);
			pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(null, pstm, conn);
		}
	}
	
	public void updatePoMains2(String poid,int status,String prePayTime,String prePayUser) {
		PreparedStatement pstm=null;
		String sql=null;
		Connection conn=DBUtil.getConn();
		sql="update pomain set status=?,prePayTime=?,prePayUser=? where poid=?";
		try {
			pstm=conn.prepareStatement(sql);
			pstm.setInt(1, status);
			pstm.setString(2, prePayTime);
			pstm.setString(3, prePayUser);
			pstm.setString(4, poid);
			pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(null, pstm, conn);
		}
	}
	/********仓管*******/
	public ArrayList<Pomain> AllPo(){
		ArrayList<Pomain> alPomain=new ArrayList<Pomain>();
		
		ScmUserDao sud =new ScmUserDao();
		conn=DBUtil.getConn();
		String sql="select * from pomain where (PayType='款到发货' and Status=3) or (PayType like '%预付款到发货%' and Status=5) or (PayType like '%货到付款%' and Status=1)" ;
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Pomain pomain=new Pomain();
				pomain.setPoid(rs.getString("POID"));
				pomain.setVenderCode(rs.getString("VenderCode"));
				pomain.setAccount(rs.getString("Account"));
				ScmUser su=sud.getAccount(rs.getString("Account"));
				pomain.setUserName(su.getName());
				pomain.setCreateTime(rs.getString("CreateTime"));
				pomain.setTipFee(rs.getFloat("TipFee"));
				pomain.setProductTotal(rs.getFloat("ProductTotal"));
				pomain.setPoTotal(rs.getFloat("POTotal"));
				pomain.setPayType(rs.getString("PayType"));
				pomain.setPrePayFee(rs.getFloat("PrePayFee"));
				pomain.setStatus(rs.getInt("Status"));
				alPomain.add(pomain);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstmt, conn);
		}
		return alPomain;
	}
	public ArrayList<Pomain> OnePO_OnePayType(String payType){
		ArrayList<Pomain> alPomain=new ArrayList<Pomain>();
		ScmUserDao sud =new ScmUserDao();
		conn=DBUtil.getConn();
		String sql=null;
		if(payType.equals("款到发货")){
			sql="select * from pomain where PayType=? and  Status=3";			
		}else if(payType.equals("预付款到发货")){
			sql="select * from pomain where PayType=? and  Status=5";
		}else if(payType.equals("货到付款")){
			sql="select * from pomain where PayType=? and  Status=1";
		}
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, payType);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Pomain pomain=new Pomain();
				pomain.setPoid(rs.getString("POID"));
				pomain.setVenderCode(rs.getString("VenderCode"));
				pomain.setAccount(rs.getString("Account"));
				ScmUser su=sud.getAccount(rs.getString("Account"));
				pomain.setUserName(su.getName());
				pomain.setCreateTime(rs.getString("CreateTime"));
				pomain.setTipFee(rs.getFloat("TipFee"));
				pomain.setProductTotal(rs.getFloat("ProductTotal"));
				pomain.setPoTotal(rs.getFloat("POTotal"));
				pomain.setPayType(rs.getString("PayType"));
				pomain.setPrePayFee(rs.getFloat("PrePayFee"));
				pomain.setStatus(rs.getInt("Status"));
				alPomain.add(pomain);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstmt, conn);
		}
		return alPomain; 
	}
	public void changeStatus(String poid) throws SQLException{
		try {
			conn=DBUtil.getConn();
			conn.setAutoCommit(false);
			String sql="update pomain set Status=2 where POID=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,poid);
			pstmt.executeUpdate();
			conn.commit();
		} catch (MySQLNonTransientConnectionException e) {
			DBUtil.close(rs, pstmt, conn); 
		}
	}
	public void inStockTime(String poid) throws SQLException{
		try {
			conn=DBUtil.getConn();
			conn.setAutoCommit(false);
			String sql="update pomain set StockTime=? where POID=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, this.nowDate());
			pstmt.setString(2,poid);
			pstmt.executeUpdate();
			conn.commit();
		} catch (MySQLNonTransientConnectionException e) {
			DBUtil.close(rs, pstmt, conn); 
		}
	}
	public void inStockUser(String poid,String name) throws SQLException{
		try {
			conn=DBUtil.getConn();
			conn.setAutoCommit(false);
			String sql="update pomain set StockUser=? where POID=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2,poid);
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
}
