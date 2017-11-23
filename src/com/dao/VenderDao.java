package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.model.Vender;
import com.util.DBUtil;

public class VenderDao {
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql;
	public ArrayList<Vender> getVenders(int index,int pageSize){
		sql="select * from vender limit "+index+","+pageSize;
		ArrayList<Vender> al=new ArrayList<Vender>();
		try {
			conn = DBUtil.getConn();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				Vender v=new Vender(rs.getString("venderCode"),rs.getString("name"),rs.getString("password"),rs.getString("contactor"),rs.getString("address"),rs.getString("postcode"),rs.getString("tel"),rs.getString("fax"),rs.getString("createDate"));
				al.add(v);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, stmt, conn);
		}
		return al;
	}
	
	public int addVender(Vender v){
		int n=0;//0表示添加失败，-1表示有重复，1表示添加成功
		try {
			conn = DBUtil.getConn();
			sql="select * from vender where VenderCode=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,v.getVenderCode());
			rs=pstmt.executeQuery();
			if(rs.next()){
				n=-1;
				return n;
			}
			if(v.getName()==null) return -2;
			sql="insert into vender values(?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,v.getVenderCode());
			pstmt.setString(2,v.getName());
			pstmt.setString(3,v.getPassword());
			pstmt.setString(4,v.getContactor());
			pstmt.setString(5,v.getAddress());
			pstmt.setString(6,v.getPostcode());
			pstmt.setString(7,v.getTel());
			pstmt.setString(8,v.getFax());
			pstmt.setString(9,v.getCreateDate());
			pstmt.executeUpdate();	
			n=1;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstmt, conn);
		}
		return n;
	}
	
	public int delVender(String venderCode){
		int n=0;//0表示del失败，-1表示有相关的订单，1表示del成功
		sql="select * From pomain where  VenderCode='"+venderCode+"'";
		
		try {
			conn = DBUtil.getConn();
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			if(!rs.next()){
				sql="delete from vender where VenderCode='"+venderCode+"'";
				stmt.executeUpdate(sql);
				n=1;
			}
			else{
				n=-1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, stmt, conn);
		}
		return n;
	}
	
	public Vender getModifyVender(String venderCode){
		Vender v=null;
		try {
			conn = DBUtil.getConn();
			stmt=conn.createStatement();
			sql="select * from vender where VenderCode='"+venderCode+"'";
			rs=stmt.executeQuery(sql);
			rs.next();
			v=new Vender(rs.getString("venderCode"),rs.getString("name"),rs.getString("password"),rs.getString("contactor"),rs.getString("address"),rs.getString("postcode"),rs.getString("tel"),rs.getString("fax"),rs.getString("createDate"));
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, stmt, conn);
		}
		return v;
	}
	public int modifyVender(Vender v){
		int n=0;//0表示修改失败，1表示修改成功
		try {
			conn = DBUtil.getConn();
			sql="update vender set name=?,password=?,contactor=?,address=?,postcode=?,tel=?,fax=? where VenderCode=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,v.getName());
			pstmt.setString(2,v.getPassword());
			pstmt.setString(3,v.getContactor());
			pstmt.setString(4,v.getAddress());
			pstmt.setString(5,v.getPostcode());
			pstmt.setString(6,v.getTel());
			pstmt.setString(7,v.getFax());
			pstmt.setString(8,v.getVenderCode());
			pstmt.executeUpdate();	
			n=1;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(null, pstmt, conn);
		}
		return n;
	}
	/*********仓管***********/
	public String  getNameByVenderCode(String venderCode){
		String venderName=null;
		
			conn=DBUtil.getConn();
		
		String sql="select Name from vender where VenderCode=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, venderCode);
			rs=pstmt.executeQuery();
			if(rs.next()){
				venderName=rs.getString("Name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstmt, conn);
		}
		return venderName;
	}
	/*********仓管***********/
}
