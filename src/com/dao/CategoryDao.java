package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;




import com.model.Category;
import com.model.CategoryPage;

import com.util.DBUtil;

public class CategoryDao {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	public ArrayList<Category> allCategory(){
		ArrayList<Category> alCategory =new ArrayList<Category>();
		conn=DBUtil.getConn();
		try {
			String sql="select * from category";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Category category=new Category();
				category.setCategoryID(rs.getInt("CategoryID"));
				category.setName(rs.getString("Name"));
				category.setRemark(rs.getString("Remark"));
				alCategory.add(category);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstmt, conn);
		}
		
		return alCategory;
	}
	public int selectCategoryID(String categoryName){
		int categoryID=0;
		conn=DBUtil.getConn();
		String sql="select CategoryID from category where name=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,categoryName );
			rs=pstmt.executeQuery();
			if(rs.next()){
				categoryID=rs.getInt("CategoryID");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstmt, conn);
		}
		return categoryID;
	}
	public void addCategory(Category cg){
		conn=DBUtil.getConn();
		String sql="insert into category(Name,Remark) values(?,?)";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,cg.getName());
			pstmt.setString(2, cg.getRemark());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstmt, conn);
		}
		
	}
	
	
	
	public void deleteCategory(int categoryID){
		conn=DBUtil.getConn();
		String sql="delete from category where CategoryID=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, categoryID);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstmt, conn);
		}
	}
	public void updateCategory(Category cdOld,Category cdNew){
		conn=DBUtil.getConn();
		String sql="update category set Name=?,Remark=? where Name=?  and  Remark=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, cdNew.getName());
			pstmt.setString(2, cdNew.getRemark());
			pstmt.setString(3, cdOld.getName());
			pstmt.setString(4, cdOld.getRemark());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstmt, conn);
		}
	}
	
	//分页
	public void getTotalPage(CategoryPage cp){
		conn=DBUtil.getConn();
		String sql="select count(*) counts from category";
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()){
				int total=rs.getInt("counts");
				cp.setTotalPage(total%cp.getPageSize()==0?total/cp.getPageSize():total/cp.getPageSize()+1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstmt, conn);
		}
	}
	public void getData(CategoryPage cp){
		ArrayList<Category> list =new ArrayList<Category>();
		conn=DBUtil.getConn();
		String sql="select *  from category LIMIT ?,?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, (cp.getNowPage()-1)*cp.getPageSize());
			pstmt.setInt(2, cp.getPageSize());
			rs=pstmt.executeQuery();
			while(rs.next()){
				Category category =new Category();
				category.setCategoryID(rs.getInt("CategoryID"));
				category.setName(rs.getString("Name"));
				category.setRemark(rs.getString("Remark"));
				list.add(category);
			}
			cp.setDataAl(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstmt, conn);
		}
	}
}
