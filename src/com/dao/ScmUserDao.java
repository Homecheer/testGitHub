package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.ScmUser;
import com.util.DBUtil;

public class ScmUserDao {
	public ArrayList<ScmUser> getAllSuser() {
		PreparedStatement pstm=null;
		ResultSet rs=null;
		ResultSet rs1=null;
		ResultSet rs2=null;
		String sql=null;
		ScmUser sUser;
		Connection conn=DBUtil.getConn();
		ArrayList<ScmUser> aList=new ArrayList<ScmUser>();
		sql="select * FROM scmuser";
		try {
			//改为手动提交
			conn.setAutoCommit(false);
			pstm=conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while (rs.next()) {
				sUser=new ScmUser();
				sUser.setAccount(rs.getString("account"));
				sUser.setCreateDate(rs.getString("createdate"));
				sUser.setName(rs.getString("name"));
				sUser.setStatus(rs.getString("status"));
				sql="select modelcode from usermodel where account=?;";
				pstm=conn.prepareStatement(sql);
				pstm.setString(1, sUser.getAccount());
				rs1=pstm.executeQuery();
				String code="";
				while (rs1.next()) {
					String mCode=rs1.getString("modelcode");
					sql="select modelname from systemmodel where modelcode=?";
					pstm=conn.prepareStatement(sql);
					pstm.setString(1, mCode);
					rs2=pstm.executeQuery();
					while (rs2.next()) {
						code+=" "+rs2.getString("modelname")+" ";
						
					}
				}
				sUser.setModelName(code);
				aList.add(sUser);
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
			DBUtil.close(rs2, null, null);
			DBUtil.close(rs1, null, null);
			DBUtil.close(rs, pstm, conn);
		}
		return aList;
	}
	
	public String getPower(String name) {
		PreparedStatement pstm=null;
		ResultSet rs=null;
		ResultSet rs1=null;
		ResultSet rs2=null;
		String sql=null;
		String code="";
		ScmUser sUser;
		Connection conn=DBUtil.getConn();
		sql="select * FROM scmuser where name=?";
		try {
			//改为手动提交
			conn.setAutoCommit(false);
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, name);
			rs=pstm.executeQuery();
			while (rs.next()) {
				sUser=new ScmUser();
				sUser.setAccount(rs.getString("account"));
				sUser.setCreateDate(rs.getString("createdate"));
				sUser.setName(rs.getString("name"));
				sUser.setStatus(rs.getString("status"));
				sql="select modelcode from usermodel where account=?;";
				pstm=conn.prepareStatement(sql);
				pstm.setString(1, sUser.getAccount());
				rs1=pstm.executeQuery();
				while (rs1.next()) {
					String mCode=rs1.getString("modelcode");
					sql="select modelname from systemmodel where modelcode=?";
					pstm=conn.prepareStatement(sql);
					pstm.setString(1, mCode);
					rs2=pstm.executeQuery();
					while (rs2.next()) {
						code+=" "+rs2.getString("modelname")+" ";
						
					}
				}
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
			DBUtil.close(rs2, null, null);
			DBUtil.close(rs1, null, null);
			DBUtil.close(rs, pstm, conn);
		}
		return code;
	}
	
	public ScmUser getNamePass(String name,String password) {
		PreparedStatement pstm=null;
		ResultSet rs=null;
		String sql=null;
		ScmUser sUser = null;
		Connection conn=DBUtil.getConn();
		sql="select * FROM scmuser where account=? and password=?";
		try {
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, name);
			pstm.setString(2, password);
			rs=pstm.executeQuery();
			while (rs.next()) {
				sUser=new ScmUser();
				sUser.setAccount(rs.getString("account"));
				sUser.setCreateDate(rs.getString("createdate"));
				sUser.setPassword(rs.getString("password"));
				sUser.setName(rs.getString("name"));
				sUser.setStatus(rs.getString("status"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstm, conn);
		}
		return sUser;
	}
	
	public ScmUser getAccount(String account) {
		PreparedStatement pstm=null;
		ResultSet rs=null;
		String sql=null;
		ScmUser sUser = null;
		Connection conn=DBUtil.getConn();
		sql="select * FROM scmuser where account=?";
		try {
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, account);
			rs=pstm.executeQuery();
			while (rs.next()) {
				sUser=new ScmUser();
				sUser.setAccount(rs.getString("account"));
				sUser.setCreateDate(rs.getString("createdate"));
				sUser.setPassword(rs.getString("password"));
				sUser.setName(rs.getString("name"));
				sUser.setStatus(rs.getString("status"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstm, conn);
		}
		return sUser;
	}
	
	public void deleteAccount(String account) {
		PreparedStatement pstm=null;
		String sql=null;
		Connection conn=DBUtil.getConn();
		sql="delete from usermodel where account=?";
		try {
			conn.setAutoCommit(false);
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, account);
			pstm.executeUpdate();
			sql="delete FROM scmuser where account=?";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, account);
			pstm.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
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
			DBUtil.close(null, pstm, conn);
		}
	}
	
	public void addUser(String name,String password,String createDate,String status,String account,String[] qx ) {
		PreparedStatement pstm=null;
		String sql=null;
		Connection conn=DBUtil.getConn();
		sql="insert into scmuser values(?,?,?,?,?)";
		try {
			
			conn.setAutoCommit(false);
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, account);
			pstm.setString(2, password);
			pstm.setString(3, name);
			pstm.setString(4, createDate);
			pstm.setString(5, status);
			pstm.executeUpdate();
			sql="insert into usermodel values(?,?)";
			pstm=conn.prepareStatement(sql);
			for (int i = 0; i < qx.length; i++) {
				if (qx[i]!=null) {
					pstm.setString(1, account);
					pstm.setString(2, qx[i]);	
					pstm.executeUpdate();
				}else {
					continue;
				}
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
			//提交方式再改为自动提交
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DBUtil.close(null, pstm, conn);
		}
	}
	
	
	public void updateScmUser(String name,String password,String status,String account,String[] qx) {
		PreparedStatement pstm=null;
		String sql=null;
		Connection conn=DBUtil.getConn();
		sql="update scmuser	set name=?,password=?,status=? where account=?";
		try {
			conn.setAutoCommit(false);
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, name);
			pstm.setString(2, password);
			pstm.setString(3, status);
			pstm.setString(4, account);
			pstm.executeUpdate();
			sql="delete from usermodel where account=?";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, account);
			pstm.executeUpdate();
			sql="insert into usermodel values(?,?)";			
			for (int i = 0; i < qx.length; i++) {
				if (qx[i]!=null) {
					pstm=conn.prepareStatement(sql);
					pstm.setString(1, account);
					pstm.setString(2, qx[i]);	
					pstm.executeUpdate();
				}else {
					continue;
				}
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
			DBUtil.close(null, pstm, conn);
		}
	}
	/******仓管******/
	public String getAuth(String account){
		String  modelCode=null;
		String  modelName="";
		Connection conn=DBUtil.getConn();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql=null;
		try {
			sql="select * from usermodel where Account=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, account);
			rs=pstmt.executeQuery();
			sql="select * from systemmodel where ModelCode=?";
			while(rs.next()){
				modelCode=rs.getString("ModelCode");
				
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, modelCode);
				rs=pstmt.executeQuery();
				if(rs.next()){
					modelName+=rs.getString("ModelName")+" ";
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelName;
	}
}
