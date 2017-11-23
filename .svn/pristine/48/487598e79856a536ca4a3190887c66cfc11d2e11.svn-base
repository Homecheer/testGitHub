package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import com.model.Product;
import com.mysql.jdbc.exceptions.jdbc4.MySQLNonTransientConnectionException;
import com.util.DBUtil;

public class ProductDao {
	public Connection conn;
	public PreparedStatement pstmt;
	public ResultSet rs;
	public ArrayList<Product> AllProduct(){
		ArrayList<Product> alProduct=new ArrayList<Product>();
		conn=DBUtil.getConn();
		String sql="select * from product";
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Product pro=new Product();
				pro.setProductCode(rs.getString("ProductCode"));
				pro.setCategoryID(rs.getInt("CategoryID"));
				pro.setName(rs.getString("Name"));
				pro.setUnitName(rs.getString("UnitName"));
				pro.setPrice(rs.getFloat("Price"));
				pro.setCreateDate(rs.getString("CreateDate"));
				pro.setRemark(rs.getString("Remark"));
				pro.setPoNum(rs.getInt("PONum"));
				pro.setSoNum(rs.getInt("SONum"));
				alProduct.add(pro);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstmt, conn);
		}
		
		return alProduct;
	}
	public ArrayList<Product> categoryIDHasBeUsed(int categoryID){ //用于产品分类，看这个ID是否在产品管理已经存在，若存在产品分类中不能删除该分类
		ArrayList<Product> alIDHasBeUsed =new ArrayList<Product>();
		conn=DBUtil.getConn();
		String sql="select * from product where categoryID=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, categoryID);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Product pro=new Product();
				pro.setCategoryID(categoryID);
				pro.setProductCode(rs.getString("ProductCode"));
				pro.setCategoryID(rs.getInt("CategoryID"));
				pro.setName(rs.getString("Name"));
				pro.setUnitName(rs.getString("UnitName"));
				pro.setPrice(rs.getFloat("Price"));
				pro.setCreateDate(rs.getString("CreateDate"));
				pro.setRemark(rs.getString("Remark"));
				pro.setPoNum(rs.getInt("PONum"));
				pro.setSoNum(rs.getInt("SONum"));
				alIDHasBeUsed.add(pro);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstmt, conn); 
		}
		return alIDHasBeUsed;
	}
	public void addProduct(Product pro){
		conn=DBUtil.getConn();
		try {
			String sql="insert into product values(?,?,?,?,?,?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, pro.getProductCode());
			pstmt.setInt(2, pro.getCategoryID());
			pstmt.setString(3, pro.getName());
			pstmt.setString(4, pro.getUnitName());
			pstmt.setFloat(5, pro.getPrice());
			pstmt.setString(6, this.nowDate());
			pstmt.setString(7, pro.getRemark());
			pstmt.setInt(8, 0);
			pstmt.setInt(9, 0);
			pstmt.executeUpdate();
			sql="insert into stock values(?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, pro.getProductCode());
			pstmt.setString(2, pro.getName());
			pstmt.setString(3, pro.getUnitName());
			pstmt.setInt(4, 0);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstmt, conn);
		}
		
		
	}
	public String productCodeHasExist(String productCode){
		String productCodeResult =null;
		conn=DBUtil.getConn();
		String sql="select ProductCode from product where ProductCode=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, productCode);
			rs=pstmt.executeQuery();
			if(rs.next()){
				productCodeResult=rs.getString("ProductCode");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstmt, conn);
		}
		return productCodeResult;
	}
	public String[] productCodeHasBeUsedInPoitem(String [] productCode){
		String[] productCodeResult = new String[productCode.length];
		conn = DBUtil.getConn();

		try {
			for (int i = 1; i < productCode.length; i++) {
				String sql = "select ProductCode from poitem where ProductCode=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, productCode[i]);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					for(int j=0;j<productCodeResult.length;j++){
						if(productCodeResult[j]==null){
							productCodeResult[j] = rs.getString("ProductCode");	
							break;
						}
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
		return productCodeResult;
	}
	public String[] productCodeHasBeUsedInSoitem(String [] productCode){
		String[] productCodeResult = new String[productCode.length];
		conn = DBUtil.getConn();

		try {
			for (int i = 1; i < productCode.length; i++) {
				String sql = "select ProductCode from soitem where ProductCode=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, productCode[i]);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					for(int j=0;j<productCodeResult.length-1;j++){
						if(productCodeResult[j]==null){
							productCodeResult[j] = rs.getString("ProductCode");	
							break;
						}
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
		return productCodeResult;
	}
	
	public void deleteProduct(String [] productCode){
		
		conn = DBUtil.getConn();

		try {
			for (int i = 1; i < productCode.length; i++) {
				String sql = "delete  from product where ProductCode=?";
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
	public void updateProduct(Product pro){
		conn=DBUtil.getConn();
		String sql="update product set CategoryID=?,Name=?,UnitName=?,Price=?,CreateDate=?,Remark=? where ProductCode=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, pro.getCategoryID());
			pstmt.setString(2, pro.getName());
			pstmt.setString(3, pro.getUnitName());
			pstmt.setFloat(4, pro.getPrice());
			pstmt.setString(5, this.nowDate());
			pstmt.setString(6, pro.getRemark());
			pstmt.setString(7, pro.getProductCode());
			pstmt.executeUpdate();
			sql="update stock set Name=?,UnitName=? where ProductCode=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, pro.getName());
			pstmt.setString(2, pro.getUnitName());
			pstmt.setString(3, pro.getProductCode());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
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
	public String getNameByProductCode(String productCode){
		String productName=null;
		conn=DBUtil.getConn();
		String sql="select Name from product where productCode=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, productCode);
			rs=pstmt.executeQuery();
			if(rs.next()){
				productName=rs.getString("Name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstmt, conn); 
		}
		return productName;
	}
	
	
	public int getPriceByProductCode(String productCode){
		int price=0;
		conn=DBUtil.getConn();
		String sql="select Price from product where productCode=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, productCode);
			rs=pstmt.executeQuery();
			if(rs.next()){
				price=rs.getInt("Price");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstmt, conn); 
		}
		return price;
	}
	
	public void updatePoNum(String productCode,int PoNum) throws SQLException{   //根据产品编号修改采购在途数
		try {
			conn=DBUtil.getConn();
			String sql="select PoNum from product where ProductCode=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, productCode);
			rs=pstmt.executeQuery();
			int oldPoNum=0;
			if(rs.next()){
				oldPoNum=rs.getInt("PoNum");
			}
			conn.setAutoCommit(false);
			sql="update product set PoNum=? where ProductCode=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, oldPoNum-PoNum);
			pstmt.setString(2, productCode);
			pstmt.executeUpdate();
			conn.commit();
		} catch (MySQLNonTransientConnectionException e) {
			DBUtil.close(rs, pstmt, conn); 
		}
	}
	public void updateSoNum(String productCode,int SoNum) throws SQLException{   //根据产品编号修改销售在途数
		try {
			conn=DBUtil.getConn();
			String sql="select SoNum from product where ProductCode=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, productCode);
			rs=pstmt.executeQuery();
			int oldSoNum=0;
			if(rs.next()){
				oldSoNum=rs.getInt("SoNum");
			}
			conn.setAutoCommit(false);
			sql="update product set SoNum=? where ProductCode=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, oldSoNum-SoNum);
			pstmt.setString(2, productCode);
			pstmt.executeUpdate();
			conn.commit();
		} catch (MySQLNonTransientConnectionException e) {
			DBUtil.close(rs, pstmt, conn); 
		}
	}
	public int[] getPoNumAndSoNumByProductCode(String productCode){
		int [] arr=new int [2];
		conn=DBUtil.getConn();
		String sql="select PONum,SONum from product where ProductCode=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, productCode);
			rs=pstmt.executeQuery();
			while(rs.next()){
				arr[0]=rs.getInt("PONum");
				arr[1]=rs.getInt("SONum");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstmt, conn); 
		}
		return arr;
	}
}
