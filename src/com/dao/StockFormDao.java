package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import com.model.Stock;
import com.util.DBUtil;

public class StockFormDao {
	//这段时间内销售的数量
	public int getSoNum(String date) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		PreparedStatement pstm=null;
		ResultSet rs=null;
		int soNum=0;
		String sql=null;
		String nowDate=df.format(new Date());
		Connection conn=DBUtil.getConn();
		sql="SELECT SUM(si.num) num ,sm.stocktime from somain sm,soitem si where sm.stocktime > '"+date+"' and sm.SOID=si.SOID";
		try {
			pstm=conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while (rs.next()) {
				soNum=rs.getInt("num");
				String paytime=rs.getString("sm.stocktime");
				String[] time2=date.split("-");
				String[] time1=paytime.split("-");
				for (int i = 0; i < time1.length; i++) {
						if (Integer.parseInt(time1[0])==Integer.parseInt(time2[0])&&Integer.parseInt(time1[1])==Integer.parseInt(time2[1])) {
							return 0;
						}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstm, conn);
		}
		return soNum;
	}
	//这段时间内采购的数量
	public int getPoNum(String date) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		PreparedStatement pstm=null;
		ResultSet rs=null;
		int poNum=0;
		String sql=null;
		String nowDate=df.format(new Date());
		Connection conn=DBUtil.getConn();
		sql="SELECT SUM(pi.num) num , pm.stocktime from pomain pm,poitem pi where pm.stocktime > '"+date+"' and pm.POID=pi.POID";
		try {
			pstm=conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while (rs.next()) {
				poNum=rs.getInt("num");
				String paytime=rs.getString("pm.stocktime");
				String[] time2=date.split("-");
				String[] time1=paytime.split("-");
				for (int i = 0; i < time1.length; i++) {
						if (Integer.parseInt(time1[0])==Integer.parseInt(time2[0])&&Integer.parseInt(time1[1])==Integer.parseInt(time2[1])) {
							return 0;
						}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstm, conn);
		}
		return poNum;
	}
	
	//现在的库存数
	public int getNowNum() {
		PreparedStatement pstm=null;
		ResultSet rs=null;
		int nowNum=0;
		String sql=null;
		Connection conn=DBUtil.getConn();
		sql="SELECT SUM(num) num from stock";
		try {
			pstm=conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while (rs.next()) {
				nowNum=rs.getInt("num");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstm, conn);
		}
		return nowNum;
	}
	//获取库存表信息
	public ArrayList<Stock> getStock() {
		PreparedStatement pstm=null;
		ResultSet rs=null;
		ArrayList<Stock> alList=new ArrayList<Stock>();
		String sql=null;
		Connection conn=DBUtil.getConn();
		sql="SELECT * from stock";
		try {
			pstm=conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while (rs.next()) {
				Stock stock=new Stock();
				stock.setProductCode(rs.getString("ProductCode"));
				stock.setName(rs.getString("name"));
				stock.setNum(rs.getInt("num"));
				alList.add(stock);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstm, conn);
		}
		return alList;
	}
	
	public ArrayList<Stock> getStocks(String date) {
		PreparedStatement pstm=null;
		ResultSet rs=null;
		ResultSet rs1=null;
		ResultSet rs2=null;
		ArrayList<Stock> alList=new ArrayList<Stock>();
		String sql=null;
		Connection conn=DBUtil.getConn();
		sql="SELECT * from stock";
		try {
			conn.setAutoCommit(false);
			pstm=conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while (rs.next()) {
				Stock stock=new Stock();
				stock.setProductCode(rs.getString("ProductCode"));
				stock.setName(rs.getString("name"));
				stock.setNum(rs.getInt("num"));
				sql="select * from soitem where productcode=?";
				pstm=conn.prepareStatement(sql);
				pstm.setString(1, stock.getProductCode());
				rs1=pstm.executeQuery();
				while (rs1.next()) {
					int siNum=rs1.getInt("num");
					String soid=rs1.getString("soid");
					sql="select * from somain where soid='"+soid+"'";
					pstm=conn.prepareStatement(sql);
					rs2=pstm.executeQuery();
					while (rs2.next()) {
						String time=rs2.getString("stocktime");
						if(time!=null){
						String[] time1=time.split("-");
						String[] time2=date.split("-");
						boolean flag=false;
						for (int i = 0; i < time1.length; i++) {
							if ((Integer.parseInt(time1[0])>=Integer.parseInt(time2[0])&&Integer.parseInt(time1[1])>Integer.parseInt(time2[1]))||(Integer.parseInt(time1[0])==Integer.parseInt(time2[0])&&Integer.parseInt(time1[1])==Integer.parseInt(time2[1]))) {
								if (Integer.parseInt(time1[0])==Integer.parseInt(time2[0])&&Integer.parseInt(time1[1])==Integer.parseInt(time2[1])) {
									return getStock();
								}
								flag=true;
							}
						}
						if (flag) {
							stock.setNum(stock.getNum()+siNum);
						}
						}
					}
				}
				sql="select * from poitem where productcode=?";
				pstm=conn.prepareStatement(sql);
				pstm.setString(1, stock.getProductCode());
				rs1=pstm.executeQuery();
				int piNum=0;
				while (rs1.next()) {
					piNum=rs1.getInt("num");
					String poid=rs1.getString("poid");
					sql="select * from pomain where poid='"+poid+"'";
					pstm=conn.prepareStatement(sql);
					rs2=pstm.executeQuery();
					while (rs2.next()) {
						String time=rs2.getString("stocktime");
						if(time!=null){
						String[] time1=time.split("-");
						String[] time2=date.split("-");
						boolean flag=false;
						for (int i = 0; i < time1.length; i++) {
							if ((Integer.parseInt(time1[0])>=Integer.parseInt(time2[0])&&Integer.parseInt(time1[1])>Integer.parseInt(time2[1]))||(Integer.parseInt(time1[0])==Integer.parseInt(time2[0])&&Integer.parseInt(time1[1])==Integer.parseInt(time2[1]))) {
								flag=true;
							}
						}
						if (flag) {
							stock.setNum(stock.getNum()-piNum);
						}
						}
					}
				}
				sql="select * from checkstock where productcode=?";
				pstm=conn.prepareStatement(sql);
				pstm.setString(1, stock.getProductCode());
				rs1=pstm.executeQuery();
				while (rs1.next()) {
					int orginNum=rs1.getInt("originNum");
					int realNum=rs1.getInt("realNum");
					String stocktime=rs1.getString("stocktime");
					String[] time2=date.split("-");
					String[] time1=stocktime.split("-");
					boolean flag=false;
					for (int i = 0; i < time1.length; i++) {
						if ((Integer.parseInt(time1[0])>=Integer.parseInt(time2[0])&&Integer.parseInt(time1[1])>Integer.parseInt(time2[1]))||(Integer.parseInt(time1[0])==Integer.parseInt(time2[0])&&Integer.parseInt(time1[1])==Integer.parseInt(time2[1]))) {
								flag=true;
							}
					}
					if (flag) {
						stock.setNum(stock.getNum()+orginNum-realNum);
					}
					
				}
				alList.add(stock);
			}
			conn.commit();
		} catch (SQLException e) {
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
			DBUtil.close(rs2, pstm, conn);
			DBUtil.close(rs1, pstm, conn);
			DBUtil.close(rs, pstm, conn);
		}
		return alList;
	}
	
	public int getCheckNum(String date) {
		PreparedStatement pstm=null;
		ResultSet rs=null;
		String sql=null;
		int chaNum = 0;
		Connection conn=DBUtil.getConn();
		sql="select * from checkstock where stocktime > '"+date+"'";
		try {
			pstm=conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while (rs.next()) {
				int orginNum=rs.getInt("originNum");
				int realNum=rs.getInt("realNum");
				String stocktime=rs.getString("stocktime");
				String[] time2=date.split("-");
				String[] time1=stocktime.split("-");
				for (int i = 0; i < time1.length; i++) {
						if (Integer.parseInt(time1[0])==Integer.parseInt(time2[0])&&Integer.parseInt(time1[1])==Integer.parseInt(time2[1])) {
							return 0;
						}
				}
				chaNum+=orginNum-realNum;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstm, conn);
		}
		return chaNum;
	}
}
