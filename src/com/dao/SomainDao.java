package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import com.model.ScmUser;
import com.model.Somain;
import com.mysql.jdbc.exceptions.jdbc4.MySQLNonTransientConnectionException;
import com.util.DBUtil;

public class SomainDao {
	public Connection conn;
	public PreparedStatement pstmt;
	public ResultSet rs;
	public ArrayList<Somain> getSoMains() {
		String sql=null;
		ArrayList<Somain> aList=new ArrayList<Somain>();
		PreparedStatement pstm=null;
		ResultSet rs=null;
		ResultSet rs1=null;
		Connection conn=DBUtil.getConn();
		sql="select * from somain";
		try {
			//改为手动提交
			conn.setAutoCommit(false);
			pstm=conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while (rs.next()) {
				Somain soMain=new Somain();
				soMain.setSoid(rs.getString("SOID"));
				soMain.setCreateTime(rs.getString("createtime"));
				soMain.setCustomerCode(rs.getString("CustomerCode"));
				soMain.setAccount(rs.getString("account"));
				soMain.setTipFee(rs.getFloat("TipFee"));
				soMain.setProductTotal(rs.getFloat("ProductTotal"));
				soMain.setSoTotal(rs.getFloat("sototal"));
				soMain.setPayType(rs.getString("paytype"));
				soMain.setPrePayFee(rs.getFloat("PrePayFee"));
				soMain.setStatus(rs.getInt("Status"));
				sql="select name from customer where CustomerCode =?";
				pstm=conn.prepareStatement(sql);
				pstm.setString(1, soMain.getCustomerCode());
				rs1=pstm.executeQuery();
				while (rs1.next()) {
					soMain.setCustomerName(rs1.getString("name"));
					
				}
				sql="select name from scmuser where account=?";
				pstm=conn.prepareStatement(sql);
				pstm.setString(1, soMain.getAccount());
				rs1=pstm.executeQuery();
				while (rs1.next()) {
					soMain.setUserName(rs1.getString("name"));
					
				}
				aList.add(soMain);
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
	
	//根据用户账号查询该账号是否在销售单中
		public ArrayList<Somain> getAccount(String account) {
			String sql=null;
			ArrayList<Somain> aList=new ArrayList<Somain>();
			PreparedStatement pstm=null;
			ResultSet rs=null;
			Connection conn=DBUtil.getConn();
			sql="select * from somain where account=?";
			try {
				pstm=conn.prepareStatement(sql);
				pstm.setString(1, account);
				rs=pstm.executeQuery();
				while (rs.next()) {
					Somain soMain=new Somain();
					soMain.setSoid(rs.getString("SOID"));
					soMain.setCreateTime(rs.getString("createtime"));
					soMain.setCustomerCode(rs.getString("CustomerCode"));
					soMain.setAccount(rs.getString("account"));
					soMain.setTipFee(rs.getFloat("TipFee"));
					soMain.setProductTotal(rs.getFloat("ProductTotal"));
					soMain.setSoTotal(rs.getFloat("sototal"));
					soMain.setPayType(rs.getString("paytype"));
					soMain.setPrePayFee(rs.getFloat("PrePayFee"));
					soMain.setStatus(rs.getInt("Status"));
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
	
		//根据soid去修改somain中的状态 名字 时间--非预收情况
	public void updateSoMains(String soid,int status,String payTime,String payUser) {
		PreparedStatement pstm=null;
		String sql=null;
		Connection conn=DBUtil.getConn();
		sql="update somain set status=?,paytime=?,payuser=? where soid=?";
		try {
			pstm=conn.prepareStatement(sql);
			pstm.setInt(1, status);
			pstm.setString(2, payTime);
			pstm.setString(3, payUser);
			pstm.setString(4, soid);
			pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(null, pstm, conn);
		}
	}
	//根据soid去修改somain中的状态 名字 时间--预收情况
	public void updateSoMains2(String soid,int status,String prePayTime,String prePayUser) {
		PreparedStatement pstm=null;
		String sql=null;
		Connection conn=DBUtil.getConn();
		sql="update somain set status=?,prePayTime=?,prePayUser=? where soid=?";
		try {
			pstm=conn.prepareStatement(sql);
			pstm.setInt(1, status);
			pstm.setString(2, prePayTime);
			pstm.setString(3, prePayUser);
			pstm.setString(4, soid);
			pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(null, pstm, conn);
		}
	}
	/*********仓管*******/
	public ArrayList<Somain> AllSo(){
		ArrayList<Somain> alSomain=new ArrayList<Somain>();
		ScmUserDao sud =new ScmUserDao();
		conn=DBUtil.getConn();
		String sql="select * from somain where (PayType='款到发货' and Status=3) or (PayType like '%预付款到发货%' and Status=5) or (PayType like '%货到付款%' and Status=1)";
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Somain somain=new Somain();
				somain.setSoid(rs.getString("SOID"));
				somain.setCustomerCode(rs.getString("CustomerCode"));
				somain.setAccount(rs.getString("Account"));
				ScmUser su=sud.getAccount(rs.getString("Account"));
				somain.setUserName(su.getName());
				somain.setCreateTime(rs.getString("CreateTime"));
				somain.setTipFee(rs.getFloat("TipFee"));
				somain.setProductTotal(rs.getFloat("ProductTotal"));
				somain.setSoTotal(rs.getFloat("SOTotal"));
				somain.setPayType(rs.getString("PayType"));
				somain.setPrePayFee(rs.getFloat("PrePayFee"));
				somain.setStatus(rs.getInt("Status"));
				alSomain.add(somain);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstmt, conn);
		}
		return alSomain;
	}
	public ArrayList<Somain> OneSO_OnePayType(String payType){
		ArrayList<Somain> alSomain=new ArrayList<Somain>();
		ScmUserDao sud =new ScmUserDao();
		conn=DBUtil.getConn();
		String sql=null;
		if(payType.equals("款到发货")){
			sql="select * from somain where PayType=? and  Status=3";			
		}else if(payType.equals("预付款到发货")){
			sql="select * from somain where PayType=? and  Status=5";
		}else if(payType.equals("货到付款")){
			sql="select * from somain where PayType=? and  Status=1";
		}
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, payType);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Somain somain=new Somain();
				somain.setSoid(rs.getString("SOID"));
				somain.setCustomerCode(rs.getString("CustomerCode"));
				somain.setAccount(rs.getString("Account"));
				ScmUser su=sud.getAccount(rs.getString("Account"));
				somain.setUserName(su.getName());
				somain.setCreateTime(rs.getString("CreateTime"));
				somain.setTipFee(rs.getFloat("TipFee"));
				somain.setProductTotal(rs.getFloat("ProductTotal"));
				somain.setSoTotal(rs.getFloat("SOTotal"));
				somain.setPayType(rs.getString("PayType"));
				somain.setPrePayFee(rs.getFloat("PrePayFee"));
				somain.setStatus(rs.getInt("Status"));
				alSomain.add(somain);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstmt, conn);
		}
		return alSomain; 
	}
	public void changeStatus(String soid) throws SQLException{
		try {
			conn=DBUtil.getConn();
			conn.setAutoCommit(false);
			String sql="update somain set Status=2 where SOID=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,soid);
			pstmt.executeUpdate();
			conn.commit();
		} catch (MySQLNonTransientConnectionException e) {
			DBUtil.close(rs, pstmt, conn); 
		}
	}
	public void outStockTime(String soid) throws SQLException{
		try {
			conn=DBUtil.getConn();
			conn.setAutoCommit(false);
			String sql="update somain set StockTime=? where SOID=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, this.nowDate());
			pstmt.setString(2,soid);
			pstmt.executeUpdate();
			conn.commit();
		} catch (MySQLNonTransientConnectionException e) {
			DBUtil.close(rs, pstmt, conn); 
		}
	}
	public void outStockUser(String soid,String name) throws SQLException{
		try {
			conn=DBUtil.getConn();
			conn.setAutoCommit(false);
			String sql="update somain set StockUser=? where SOID=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2,soid);
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
