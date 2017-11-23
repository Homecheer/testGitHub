package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.Page;
import com.model.ScmUser;
import com.util.DBUtil;



public class PageServletDao {
	public void getNum(Page page) {
		PreparedStatement pstm=null;
		ResultSet rs=null;
		String sql=null;
		Connection conn=DBUtil.getConn();
		sql="SELECT COUNT(*) counts FROM scmuser";
		try {
			pstm=conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while (rs.next()) {
				int count=rs.getInt("counts");
				int total=0;
				total=count%page.getPageNum()==0?count/page.getPageNum():count/page.getPageNum()+1;
				page.setTotalpage(total);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstm, conn);
		}
	}
	public void getContext(int strat,int num,Page page) {
		PreparedStatement pstm=null;
		ResultSet rs=null;
		ResultSet rs1=null;
		ResultSet rs2=null;
		String sql=null;
		Connection conn=DBUtil.getConn();
		ArrayList<ScmUser> aList=new ArrayList<ScmUser>();
		sql="select * from scmuser LIMIT ?,?";
		try {
			//改为手动提交
			conn.setAutoCommit(false);
			pstm=conn.prepareStatement(sql);
			pstm.setInt(1, strat);
			pstm.setInt(2, num);
			rs=pstm.executeQuery();
			while (rs.next()) {
				ScmUser sUser=new ScmUser();
				sUser.setAccount(rs.getString("account"));
				sUser.setCreateDate(rs.getString("createdate"));
				sUser.setName(rs.getString("name"));
				sUser.setStatus(rs.getString("status"));
				sql="select modelcode from usermodel where account=?;";
				pstm=conn.prepareStatement(sql);
				pstm.setString(1, sUser.getAccount());
				rs1 = pstm.executeQuery();
				String code="";
				while (rs1.next()) {
					String mCode=rs1.getString("modelcode");
					sql="select modelname from systemmodel where modelcode=?";
					pstm=conn.prepareStatement(sql);
					pstm.setString(1, mCode);
					rs2 = pstm.executeQuery();
					while (rs2.next()) {
						code+=" "+rs2.getString("modelname")+" ";
						
					}
				}
				sUser.setModelName(code);
				aList.add(sUser);
			}
			page.setaUsers(aList);
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
			DBUtil.close(rs2, null, null);
			DBUtil.close(rs1, null, null);
			DBUtil.close(rs, pstm, conn);
		}
	}
}
