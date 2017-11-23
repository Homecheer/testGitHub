package com.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.dao.DAO;
import com.model.CategoryClassModel;
import com.model.CustomClassModel;
import com.model.FindOrderModel;
import com.model.FinishOrderandtime;
import com.model.GoodsPage;
import com.model.IdWeightModel;
import com.model.OrderandPaytype;
import com.model.SoitemModel;
import com.model.SomainModel;
import com.servlet.UpdateCustomServlet;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class DBUtil1 {
	//查询是否存在该编号的类
	public boolean checkCategoryID(int CategoryID) {
		Connection con = DAO.getConn();
		Statement sta = null;
		String sql = null;
		ResultSet rs = null;
		boolean a=false;
		try {
			sta = con.createStatement();
			sql = "select CategoryID from category where CategoryID="+CategoryID;
			rs = sta.executeQuery(sql);
			if (rs.next()) {
				a=true;
			}
			
		} catch (SQLException e) {
			System.err.println("failsearch,sql=" + sql);
		} finally {
			DAO.finish(rs, sta, con);
		}
		return a;
	}
	//添加类
	public void addCategoryID(CategoryClassModel m) {
		String sql = null;
		PreparedStatement psta = null;
		Connection con = DAO.getConn();
		ResultSet rs = null;
		try {
			sql = "insert into category values(?,?,?)";
			psta = con.prepareStatement(sql);
			psta.setInt(1, m.getCategoryID());
			psta.setString(2, m.getCategoryName());
			psta.setString(3, m.getCategoryRemark());
			psta.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println(e);
			//System.out.println("sql=" + sql);
		} finally {
			DAO.finish(null, null, con);
		}

		
	}
	//查询所有用户信息
	public ArrayList<CustomClassModel> updatecustom(){
		String sql = null;
		Connection con = DAO.getConn();
		Statement sta = null;
		ResultSet rs = null;
		ArrayList<CustomClassModel> al=new ArrayList<CustomClassModel>();
		try{
			sta = con.createStatement();
			sql = "select * from customer";
			rs = sta.executeQuery(sql);
			while(rs.next()){
				CustomClassModel c=new CustomClassModel(rs.getString("CustomerCode"),rs.getString("Name"),rs.getString("Password"),rs.getString("Contactor"),rs.getString("Address"),rs.getString("Postcode"),rs.getString("Tel"),rs.getString("Fax"),rs.getString("CreateDate"));
				al.add(c);
			}
		}catch (SQLException e) {
			System.err.println(e);
			//System.out.println("sql=" + sql);
		} finally {
			DAO.finish(null, null, con);
		}
		return al;
		
	}
	//查询是否已经存在用户编号
	public boolean checkCustomerCode(String CustomerCode){
		Connection con = DAO.getConn();
		Statement sta = null;
		String sql = null;
		ResultSet rs = null;
		boolean a=false;
		try {
			sta = con.createStatement();
			sql = "select * from customer where CustomerCode='"+CustomerCode+"'";
			rs = sta.executeQuery(sql);
			if (rs.next()) {
				a=true;
			}
			
		} catch (SQLException e) {
			System.err.println("failsearch,sql=" + sql);
		} finally {
			DAO.finish(rs, sta, con);
		}
		return a;
	}
	
	
	//新增客户
	public void addcustomer(String text1,String text2,String text3,String text4,String text5,String text6,String text7,String text8,String text9) {
		String sql = null;
		PreparedStatement psta = null;
		Connection con = DAO.getConn();
		ResultSet rs = null;
		try {
			sql = "insert into customer values(?,?,?,?,?,?,?,?,?)";
			psta = con.prepareStatement(sql);
			psta.setString(1,text1 );
			psta.setString(2, text2);
			psta.setString(3, text3);
			psta.setString(4, text4);
			psta.setString(5, text5);
			psta.setString(6, text6);
			psta.setString(7, text7);
			psta.setString(8, text8);
			psta.setString(9, text9);
			psta.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println(e);
			System.out.println("sql=" + sql);
		} finally {
			DAO.finish(null, null, con);
		}
	}
	
	//修改客户信息
	public void changecustomer(String text1,String text2,String text3,String text4,String text5,String text6,String text7,String text8,String text9) {
		String sql = null;
		PreparedStatement psta = null;
		Connection con = DAO.getConn();
		ResultSet rs = null;
		try {
			sql = "update customer set Name=?,Password=?,Contactor=?,Address=?,Postcode=?,Tel=?,Fax=?,CreateDate=? where CustomerCode ='"+text1+"'";
			psta = con.prepareStatement(sql);
			psta.setString(1,text2 );
			psta.setString(2, text3);
			psta.setString(3, text4);
			psta.setString(4, text5);
			psta.setString(5, text6);
			psta.setString(6, text7);
			psta.setString(7, text8);
			psta.setString(8, text9);
			psta.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println(e);
			System.out.println("sql=" + sql);
		} finally {
			DAO.finish(null, null, con);
		}
	}
	
	//查询销售主表里是否有该客户
	public boolean checkCustomerCodeSale(String CustomerCode){
		Connection con = DAO.getConn();
		Statement sta = null;
		String sql = null;
		ResultSet rs = null;
		boolean a=false;
		try {
			sta = con.createStatement();
			sql = "select * from somain where CustomerCode='"+CustomerCode+"'";
			rs = sta.executeQuery(sql);
			if (rs.next()) {
				a=true;
			}
			
		} catch (SQLException e) {
			System.err.println("failsearch,sql=" + sql);
		} finally {
			DAO.finish(rs, sta, con);
		}
		return a;
	}
	//删除该客户信息
	public void deletecustom(String CustomerCode){
		Connection con = DAO.getConn();
		Statement sta = null;
		String sql = null;
		try {
			sta = con.createStatement();
			sql = "delete from customer where CustomerCode='"+CustomerCode+"'";
			sta=con.createStatement();
			sta.executeUpdate(sql);
			
		} catch (SQLException e) {
			System.err.println("failsearch,sql=" + sql);
		} finally {
			DAO.finish(null, sta, con);
		}
		
	}

	//查询所有客户编号
		public ArrayList<String> findcustomname(){
			String sql = null;
			Connection con = DAO.getConn();
			Statement sta = null;
			ResultSet rs = null;
			ArrayList<String> al=new ArrayList<String>();
			try{
				sta = con.createStatement();
				sql = "select CustomerCode from customer";
				rs = sta.executeQuery(sql);
				while(rs.next()){
					String a=rs.getString("CustomerCode");
					al.add(a);
				}
			}catch (SQLException e) {
				System.err.println(e);
				System.out.println("sql=" + sql);
			} finally {
				DAO.finish(null, null, con);
			}
			return al;
			
		}
		
		//获得产品编号和数量单位和名字
		public ArrayList<IdWeightModel> getIdWeight(){
			String sql = null;
			Connection con = DAO.getConn();
			Statement sta = null;
			ResultSet rs = null;
			ArrayList<IdWeightModel> al=new ArrayList<IdWeightModel>();
			try{
				sta = con.createStatement();
				sql = "select ProductCode,Name,UnitName from product";
				rs = sta.executeQuery(sql);
				while(rs.next()){
					IdWeightModel x=new IdWeightModel(rs.getString("ProductCode"),rs.getString("UnitName"),rs.getString("Name"));
					al.add(x);
				}
			}catch (SQLException e) {
				System.err.println(e);
				System.out.println("sql=" + sql);
			} finally {
				DAO.finish(null, null, con);
			}
			return al;
		}
		
		//添加主销售单
		public boolean addsellorderboth(String i1,String i2,String i3,String i4,float i5,float i6,float allprice,String i7,float i8,int status,String[] s1,String[] s2,String[] s3,String[] s4) throws SQLException {
			String sql1 = null;
			String sql2 = null;
			PreparedStatement psta = null;
			Connection con = DAO.getConn();
			ResultSet rs = null;
			int len=s1.length;
			boolean f=true;
			int num=0;
			Statement sta = null;
			sta = con.createStatement();
			try {
				con.setAutoCommit(false);
				
				sql1 = "insert into somain(SOID,CustomerCode,Account,CreateTime,TipFee,ProductTotal,SOTotal,PayType,PrePayFee,Status) values(?,?,?,?,?,?,?,?,?,?)";
				psta = con.prepareStatement(sql1);
				psta.setString(1,i1 );
				psta.setString(2, i2);
				psta.setString(3, i3);
				psta.setString(4, i4);
				psta.setFloat(5, i5);
				psta.setFloat(6, i6);
				psta.setFloat(7, allprice);
				psta.setString(8, i7);
				psta.setFloat(9, i8);
				psta.setInt(10, status);
				psta.executeUpdate();
				
				for(int i=0;i<len;i++){
					sql2="insert into soitem values(?,?,?,?,?,?)";
					if(selectproduct(i1,s1[i])){
						//sql2="aaasssddins";
						throw new SQLException();
					}
					if(selectproductnum(s1[i])<Integer.parseInt(s3[i])){
						//sql2="aaasssddins";
						throw new SQLException();
					}
					psta = con.prepareStatement(sql2);
					psta.setString(1,i1 );
					psta.setString(2, s1[i]);
					psta.setFloat(3, Float.parseFloat(s2[i]));
					psta.setInt(4, Integer.parseInt(s3[i]));
					psta.setString(5, s4[i]);
					psta.setFloat(6, Float.parseFloat(s2[i])*Integer.parseInt(s3[i]));
					psta.executeUpdate();
					
					String sql3 = "select SONum from product where ProductCode ='"+s1[i]+"'";
					rs = sta.executeQuery(sql3);		
					if(rs.next()){
						num=rs.getInt("SONum");
					}
					num+=Integer.parseInt(s3[i]);
					String sql4 = "update product set SONum ="+num+" where ProductCode = '"+s1[i]+"'";
					psta = con.prepareStatement(sql4);
					psta.executeUpdate();
				}
				con.commit();
				
			} catch (SQLException e) {
				con.rollback();
				//System.err.println(e);
				f=false;
				
			} finally {
				DAO.finish(null, null, con);
			}
			return f;
		}
		//寻找账户名字	
		public ArrayList<String> findAccount(){
			String sql = null;
			Connection con = DAO.getConn();
			Statement sta = null;
			ResultSet rs = null;
			ArrayList<String> al=new ArrayList<String>();
			try{
				sta = con.createStatement();
				sql = "select Account from scmuser";
				rs = sta.executeQuery(sql);
				while(rs.next()){
					String a=rs.getString("Account");
					al.add(a);
				}
			}catch (SQLException e) {
				System.err.println(e);
				System.out.println("sql=" + sql);
			} finally {
				DAO.finish(null, null, con);
			}
			return al;
		}
		//查找订单创建时间
		public ArrayList<String> findOrdertime(){
			String sql = null;
			Connection con = DAO.getConn();
			Statement sta = null;
			ResultSet rs = null;
			ArrayList<String> al=new ArrayList<String>();
			try{
				sta = con.createStatement();
				sql = "select CreateTime from somain";
				rs = sta.executeQuery(sql);
				while(rs.next()){
					String a=rs.getString("CreateTime");
					al.add(a);
				}
			}catch (SQLException e) {
				System.err.println(e);
				System.out.println("sql=" + sql);
			} finally {
				DAO.finish(null, null, con);
			}
			return al;
		}
		//查询订单得到的结果
		public ArrayList<FindOrderModel> findOrderbase(String s1,String s2,String s3,String s4){
			String sql = null;
			Connection con = DAO.getConn();
			Statement sta = null;
			ResultSet rs = null;
			ArrayList<FindOrderModel> al=new ArrayList<FindOrderModel>();
			try{
				sta = con.createStatement();
				sql = "select * from somain where "+s1+" and "+s2+" and "+s3+" and "+s4;
				rs = sta.executeQuery(sql);
				while(rs.next()){
					FindOrderModel m=new FindOrderModel();
					m.setSOID(rs.getString("SOID"));
					m.setCreateTime(rs.getString("CreateTime"));
					m.setCustomerCode(rs.getString("CustomerCode"));
					m.setPayType("PayType");
					m.setSOTotal(rs.getFloat("SOTotal"));
					al.add(m);
				}
			}catch (SQLException e) {
				System.err.println(e);
				System.out.println("sql=" + sql);
			} finally {
				DAO.finish(null, null, con);
			}
			return al;
		}
		
		//根据销售单号查到销售单所有信息
		public SomainModel findsomain(String s1){
			String sql = null;
			Connection con = DAO.getConn();
			Statement sta = null;
			ResultSet rs = null;
			SomainModel sm=new SomainModel();
			try{
				sta = con.createStatement();
				sql = "select * from somain where SOID='"+s1+"'";
				rs = sta.executeQuery(sql);
				while(rs.next()){
					sm.setSOID(rs.getString("SOID"));
					sm.setCustomerCode(rs.getString("CustomerCode"));
					sm.setAccount(rs.getString("Account"));
					sm.setCreateTime(rs.getString("CreateTime"));
					sm.setTipFee(rs.getFloat("TipFee"));
					sm.setProductTotal(rs.getFloat("ProductTotal"));
					sm.setSOTotal(rs.getFloat("SOTotal"));
					sm.setPayType(rs.getString("PayType"));
					sm.setPrePayFee(rs.getFloat("PrePayFee"));
					sm.setStatus(rs.getInt("Status"));
					sm.setStockTime(rs.getString("StockTime"));
					sm.setStockUser(rs.getString("StockUser"));
					sm.setPayTime(rs.getString("PayTime"));
					sm.setPayUser(rs.getString("PayUser"));
					sm.setPrePayTime(rs.getString("PrePayTime"));
					sm.setPayUser(rs.getString("PayUser"));
					sm.setEndTime(rs.getString("EndTime"));
					sm.setEndUser(rs.getString("EndUser"));
				}
			}catch (SQLException e) {
				System.err.println(e);
				System.out.println("sql=" + sql);
			} finally {
				DAO.finish(null, null, con);
			}
			return sm;
			
		}
		//查询某订单号下的所有明细单
		public ArrayList<SoitemModel> findsoitem(String s1){
			String sql = null;
			Connection con = DAO.getConn();
			Statement sta = null;
			ResultSet rs = null;
			ArrayList<SoitemModel> al=new ArrayList<SoitemModel>();
			try{
				sta = con.createStatement();
				sql = "select * from soitem where SOID='"+s1+"'";
				rs = sta.executeQuery(sql);
				while(rs.next()){
					SoitemModel sm=new SoitemModel();
					sm.setSOID(rs.getString("SOID"));
					sm.setProductCode(rs.getString("ProductCode"));
					sm.setUnitPrice(rs.getFloat("UnitPrice"));
					sm.setNum(rs.getInt("Num"));
					sm.setUnitName(rs.getString("UnitName"));
					sm.setItemPrice(rs.getFloat("ItemPrice"));
					al.add(sm);
				}
			}catch (SQLException e) {
				System.err.println(e);
				System.out.println("sql=" + sql);
			} finally {
				DAO.finish(null, null, con);
			}
			return al;
		}
		
		//删除对应的明细表
		public void deletesoitem(String s1,String s2) throws SQLException{
			Connection con = DAO.getConn();
			Statement sta = null;
			String sql = null;
			ResultSet rs = null;
			int num=0;
			int num1=0;
			try {
				con.setAutoCommit(false);
				sta = con.createStatement();
				String sql1="select Num from soitem where SOID='"+s1+"' and ProductCode='"+s2+"'";
				rs=sta.executeQuery(sql1);
				if(rs.next()){
					num=rs.getInt("Num");
				}
				
				String sql2 = "select SONum from product where ProductCode ='"+s2+"'";
				rs = sta.executeQuery(sql2);		
				if(rs.next()){
					num1=rs.getInt("SONum")-num;
				}
				
				String sql3 = "update product set SONum ="+num+" where ProductCode = '"+s2+"'";
				sta.executeUpdate(sql3);
				
				sql = "delete from soitem where SOID='"+s1+"' and ProductCode='"+s2+"'";
				sta=con.createStatement();
				sta.executeUpdate(sql);
				
				
				
				con.commit();
			} catch (SQLException e) {
				System.err.println("failsearch,sql=" + sql);
				con.rollback();
			} finally {
				DAO.finish(null, sta, con);
			}
		}
		
		//增加某编号下的明细单
		public boolean onlyaddsoitem(String s1,String s2,String s3,String s4,String s5) {
			String sql = null;
			PreparedStatement psta = null;
			Connection con = DAO.getConn();
			ResultSet rs = null;
			boolean f= true;
			Float s6=Float.parseFloat(s3)*Float.parseFloat(s4);
			try {
				sql = "insert into soitem values(?,?,?,?,?,?)";
				if(selectproduct(s1, s2)){
					sql="dsadsadsa";
				}
				psta = con.prepareStatement(sql);
				psta.setString(1,s1 );
				psta.setString(2, s2);
				psta.setFloat(3, Float.parseFloat(s3));
				psta.setFloat(4, Float.parseFloat(s4));
				psta.setString(5, s5);
				psta.setFloat(6, s6);
				psta.executeUpdate();
				
			} catch (SQLException e) {
				System.err.println(e);
				System.out.println("sql=" + sql);
				f=false;
			} finally {
				DAO.finish(null, null, con);
			}
			return f;
		}
		
	//查询某一订单号下所有明细单的总价格
		public float selectallprice(String s1){
			String sql = null;
			Connection con = DAO.getConn();
			Statement sta = null;
			ResultSet rs = null;
			float f=0;
			try{
				sta = con.createStatement();
				sql = "select ItemPrice from soitem where SOID='"+s1+"'";
				rs = sta.executeQuery(sql);
				while(rs.next()){
					f+=rs.getFloat("ItemPrice");
				}
			}catch (SQLException e) {
				System.err.println(e);
				System.out.println("sql=" + sql);
			} finally {
				DAO.finish(null, null, con);
			}
			return f;
		}
		//设置订单总价和产品总价
		public void setprice(String s,float f1){
			String sql = null;
			Connection con = DAO.getConn();
			Statement sta = null;
			PreparedStatement psta = null;
			
			float f2=selectallprice(s);
			try{
				sta = con.createStatement();
				sql = "update somain set ProductTotal = ?,SOTotal = ? where SOID = '"+s+"'";
				psta = con.prepareStatement(sql);
				psta.setFloat(1,f2 );
				psta.setFloat(2, f1+f2);
				psta.executeUpdate();
			}catch (SQLException e) {
				System.err.println(e);
				System.out.println("sql=" + sql);
			} finally {
				DAO.finish(null, null, con);
			}
		}
		//查询该订单的附加费用
		public float selecttipfee(String s1){
			String sql = null;
			Connection con = DAO.getConn();
			Statement sta = null;
			ResultSet rs = null;
			float f=0;
			try{
				sta = con.createStatement();
				sql = "select TipFee from somain where SOID='"+s1+"'";
				rs = sta.executeQuery(sql);		
				if(rs.next()){
					f=rs.getFloat("TipFee");
				}	
			}catch (SQLException e) {
				System.err.println(e);
				System.out.println("sql=" + sql);
			} finally {
				DAO.finish(null, null, con);
			}
			return f;
		}
		
		//更新主销售单的明细
				public void updatesomain(SomainModel sm) {
					String sql = null;		
					PreparedStatement psta = null;
					Connection con = DAO.getConn();
					ResultSet rs = null;
					try {
						
						sql = "update somain set CustomerCode =?,Account=?,TipFee=?,PayType=?,StockTime=?,StockUser=?,PayTime=?,PayUser=?,PrePayTime=?,PrePayUser=?,EndTime=?,EndUser=? where SOID=?";
						psta = con.prepareStatement(sql);
						psta.setString(1,sm.getCustomerCode());
						psta.setString(2, sm.getAccount());
						psta.setFloat(3, sm.getTipFee());
						psta.setString(4, sm.getPayType());
						psta.setString(5, sm.getStockTime());
						psta.setString(6, sm.getStockUser());
						psta.setString(7, sm.getPayTime());
						psta.setString(8, sm.getPayUser());
						psta.setString(9, sm.getPrePayTime());
						psta.setString(10, sm.getPrePayUser());
						psta.setString(11, sm.getEndTime());
						psta.setString(12, sm.getEndUser());
						psta.setString(13, sm.getSOID());
						psta.executeUpdate();					
						//System.out.println("signupsuccess");
					} catch (SQLException e) {
						
						System.err.println(e);
						
					} finally {
						DAO.finish(null, null, con);
					}
					
				}
		//设置预付款金额
				public void setprepay(String s,float f1){
					String sql = null;
					Connection con = DAO.getConn();
					Statement sta = null;
					PreparedStatement psta = null;
					float f2=(selectallprice(s)+f1)/10;
					try{
						sta = con.createStatement();
						sql = "update somain set PrePayFee = ? where SOID = '"+s+"'";
						psta = con.prepareStatement(sql);
						psta.setFloat(1,f2 );
						psta.executeUpdate();
					}catch (SQLException e) {
						System.err.println(e);
						System.out.println("sql=" + sql);
					} finally {
						DAO.finish(null, null, con);
					}
				}
		//预付款金额清零
				public void setprepay(String s){
					String sql = null;
					Connection con = DAO.getConn();
					Statement sta = null;
					PreparedStatement psta = null;
					try{
						sta = con.createStatement();
						sql = "update somain set PrePayFee = 0 where SOID = '"+s+"'";
						psta = con.prepareStatement(sql);
						psta.executeUpdate();
					}catch (SQLException e) {
						System.err.println(e);
						System.out.println("sql=" + sql);
					} finally {
						DAO.finish(null, null, con);
					}
				}	
			//查询某一订单下是否有相同的产品	
				public boolean selectproduct(String s1,String s2){
					String sql = null;
					Connection con = DAO.getConn();
					Statement sta = null;
					ResultSet rs = null;
					boolean f=false;
					try{
						sta = con.createStatement();
						sql = "select ProductCode from soitem where SOID='"+s1+"'";
						rs = sta.executeQuery(sql);		
						if(rs.next()){
							if(s2.equals(rs.getString("ProductCode"))){
								f=true;
							}
						}	
					}catch (SQLException e) {
						System.err.println(e);
						System.out.println("sql=" + sql);
					} finally {
						DAO.finish(null, null, con);
					}
					return f;
				}
		//删除主明细单和相应的细节明细单
				public void delmain(String s1) throws SQLException {
					String sql1 = null;
					String sql2 = null;
					PreparedStatement psta = null;
					Connection con = DAO.getConn();
					ArrayList<String> al=new ArrayList<String>();
					Statement sta = null;
					ResultSet rs = null;
					boolean f=true;
					try {
						con.setAutoCommit(false);
						
						String sql="select ProductCode from product ";
						sta = con.createStatement();
						rs=sta.executeQuery(sql);
						while(rs.next()){
							al.add(rs.getString("ProductCode"));
						}
						
						for(String ss:al){
							int num=0;
							int num1=0;
							String sqlsql1="select SONum from product where ProductCode='"+ss+"'";
							sta = con.createStatement();
							rs=sta.executeQuery(sqlsql1);
							if(rs.next()){
								num=rs.getInt("SONum");
							}
							
							String sqlsql2="select Num from soitem where SOID = '"+s1+"' and ProductCode='"+ss+"'";
							sta = con.createStatement();
							rs=sta.executeQuery(sqlsql2);
							if(rs.next()){
								num1=rs.getInt("Num");
							}
							
							num=num-num1;
							String sqlsql3="update product set SONum ="+num+" where ProductCode='"+ss+"'";
							sta = con.createStatement();
							sta.executeUpdate(sqlsql3);
						}
						
						sql1 = "delete from soitem where SOID = '"+s1+"'";
						psta = con.prepareStatement(sql1);
						psta.executeUpdate();
						
						sql2="delete from somain where SOID = '"+s1+"'";
						psta = con.prepareStatement(sql2);
						psta.executeUpdate();
						
						con.commit();
						
					} catch (SQLException e) {
						con.rollback();
						System.err.println(e);
						e.printStackTrace();
						
					} finally {
						DAO.finish(null, null, con);
					}					
				}
				
				
				//查询明细单是否能够被删除
		public boolean selectstatus(String s1) throws SQLException{
			Connection con = DAO.getConn();
			Statement sta = null;
			String sql = null;
			ResultSet rs = null;
			int num=0;
			boolean f=false;
			String sql1=null;
			try {
				con.setAutoCommit(false);
				sta = con.createStatement();
				sql1="select Status from somain where SOID='"+s1+"'";
				rs=sta.executeQuery(sql1);
				if(rs.next()){
					num=rs.getInt("Status");
					
				}
				System.out.println(num);
				if(num==1){
					f=true;
				}
				
				con.commit();
			} catch (SQLException e) {
				System.err.println("failsearch,sql=" + sql1);
				con.rollback();
			} finally {
				DAO.finish(null, sta, con);
			}
			return f;
		}
				
				//查询出能够被了结的销售单号
				public ArrayList<OrderandPaytype> selectfinishso(String s1){
					Connection con = DAO.getConn();
					Statement sta = null;
					ResultSet rs = null;
					ArrayList<OrderandPaytype> al=new ArrayList<OrderandPaytype>();
					try{
						sta = con.createStatement();
						String	sql1 = "select SOID,PayType from somain where PayType = '货到付款' and Status = 3 and Account ='"+s1+"'";
						String sql2 = "select SOID,PayType from somain where PayType = '款到发货' and Status = 2 and Account ='"+s1+"'";
						String sql3 = "select SOID,PayType from somain where PayType = '预付款到发货' and Status = 3 and Account ='"+s1+"'";
						rs = sta.executeQuery(sql1);		
						while(rs.next()){
							al.add(new OrderandPaytype(rs.getString("SOID"),rs.getString("PayType")));
						}	
						rs = sta.executeQuery(sql2);		
						while(rs.next()){
							al.add(new OrderandPaytype(rs.getString("SOID"),rs.getString("PayType")));
						}	
						rs = sta.executeQuery(sql3);		
						while(rs.next()){
							al.add(new OrderandPaytype(rs.getString("SOID"),rs.getString("PayType")));
						}	
					}catch (SQLException e) {
						System.err.println(e);
						
					} finally {
						DAO.finish(null, null, con);
					}
					return al;
				}
		//了结销售单
				public void finishso(String s) throws SQLException{
					String sql = null;
					Connection con = DAO.getConn();
					Statement sta = null;
					PreparedStatement psta = null;
					ResultSet rs = null;
					ArrayList<String> al=new ArrayList<String>();
					try{
						con.setAutoCommit(false);
						
						String sql1="select ProductCode from product ";
						sta = con.createStatement();
						rs=sta.executeQuery(sql1);
						while(rs.next()){
							al.add(rs.getString("ProductCode"));
						}
						
						for(String ss:al){
							int num=0;
							int num1=0;
							String sqlsql1="select SONum from product where ProductCode='"+ss+"'";
							sta = con.createStatement();
							rs=sta.executeQuery(sqlsql1);
							if(rs.next()){
								num=rs.getInt("SONum");
							}
							
							String sqlsql2="select Num from soitem where SOID = '"+s+"' and ProductCode='"+ss+"'";
							sta = con.createStatement();
							rs=sta.executeQuery(sqlsql2);
							if(rs.next()){
								//System.out.println(rs.getInt("Num"));
								num1=rs.getInt("Num");
							}
							
							num=num-num1;
							String sqlsql3="update product set SONum ="+num+" where ProductCode='"+ss+"'";
							sta = con.createStatement();
							sta.executeUpdate(sqlsql3);
						}
						
						sta = con.createStatement();
						sql = "update somain set Status = 4 where SOID = '"+s+"'";
						psta = con.prepareStatement(sql);
						psta.executeUpdate();
						
						con.commit();
					}catch (SQLException e) {
						System.err.println(e);
						System.out.println("sql=" + sql);
						con.rollback();
					} finally {
						DAO.finish(null, null, con);
					}
				}	

				//查询销售待发数
				public int findsonum(String s){
					String sql = null;
					Connection con = DAO.getConn();
					Statement sta = null;
					ResultSet rs = null;
					int num=0;
					try{
						sta = con.createStatement();
						sql = "select SONum from product where ProductCode ='"+s+"'";
						rs = sta.executeQuery(sql);		
						if(rs.next()){
							num=rs.getInt("SONum");
						}
						
					}catch (SQLException e) {
						System.err.println(e);
						System.out.println("sql=" + sql);
					} finally {
						DAO.finish(null, null, con);
					}
					return num;
				}
				//修改销售待发数
				public void changenum(String s,int num){
					String sql = null;
					Connection con = DAO.getConn();
					Statement sta = null;
					PreparedStatement psta = null;
					try{
						sta = con.createStatement();
						sql = "update product set SONum ="+num+" where ProductCode = '"+s+"'";
						psta = con.prepareStatement(sql);
						psta.executeUpdate();
					}catch (SQLException e) {
						System.err.println(e);
						System.out.println("sql=" + sql);
					} finally {
						DAO.finish(null, null, con);
					}
				}	

		//查询已经了结的销售单编号和时间
				public ArrayList<FinishOrderandtime> searchform(){
					String sql = null;
					Connection con = DAO.getConn();
					Statement sta = null;
					ResultSet rs = null;
					ArrayList<FinishOrderandtime> al=new ArrayList<FinishOrderandtime>();
					try{
						sta = con.createStatement();
						sql = "select CreateTime from somain where Status = 4";
						rs = sta.executeQuery(sql);		
						while(rs.next()){
							FinishOrderandtime x=new FinishOrderandtime(rs.getString("CreateTime"));
							al.add(x);
						}
						
					}catch (SQLException e) {
						System.err.println(e);
						System.out.println("sql=" + sql);
					} finally {
						DAO.finish(null, null, con);
					}
					return al;	
				}

				//根据日期查询详情
				public ArrayList<SomainModel> findsomaintime(String s1){
					String sql = null;
					Connection con = DAO.getConn();
					Statement sta = null;
					ResultSet rs = null;
					ArrayList<SomainModel> al=new ArrayList<SomainModel>();
					try{
						sta = con.createStatement();
						//sql = "select * from somain where CreateTime ='"+s1+"'";
						sql="select * from somain where cast(CreateTime as datetime) <= cast('"+s1+"' as datetime)";
						rs = sta.executeQuery(sql);
						while(rs.next()){
							SomainModel sm=new SomainModel();
							sm.setSOID(rs.getString("SOID"));
							sm.setCustomerCode(rs.getString("CustomerCode"));
							sm.setAccount(rs.getString("Account"));
							sm.setCreateTime(rs.getString("CreateTime"));
							sm.setTipFee(rs.getFloat("TipFee"));
							sm.setProductTotal(rs.getFloat("ProductTotal"));
							sm.setSOTotal(rs.getFloat("SOTotal"));
							sm.setPayType(rs.getString("PayType"));
							sm.setPrePayFee(rs.getFloat("PrePayFee"));
							sm.setStatus(rs.getInt("Status"));
							sm.setStockTime(rs.getString("StockTime"));
							sm.setStockUser(rs.getString("StockUser"));
							sm.setPayTime(rs.getString("PayTime"));
							sm.setPayUser(rs.getString("PayUser"));
							sm.setPrePayTime(rs.getString("PrePayTime"));
							sm.setPayUser(rs.getString("PayUser"));
							sm.setEndTime(rs.getString("EndTime"));
							sm.setEndUser(rs.getString("EndUser"));
							al.add(sm);
						}
					}catch (SQLException e) {
						System.err.println(e);
						e.printStackTrace();
					} finally {
						DAO.finish(null, null, con);
					}
					return al;
				}
				//查询用户的权限是否能够登录
				public String findstatus(String s){
					String sql = null;
					Connection con = DAO.getConn();
					Statement sta = null;
					ResultSet rs = null;
					String str=null;
					try{
						sta = con.createStatement();
						sql = "select Status from scmuser where Account ='"+s+"'";
						rs = sta.executeQuery(sql);
						if(rs.next()){
							str=rs.getString("Status");
						}
					}catch (SQLException e) {
						System.err.println(e);
						e.printStackTrace();
					} finally {
						DAO.finish(null, null, con);
					}
					return str;	
				}
				//分页
				public void getTotalPage(GoodsPage page,String s1){
					String sql="select count(*) from somain where cast(CreateTime as datetime) <= cast('"+s1+"' as datetime) and Status =4";
					Connection con = DAO.getConn();
					Statement sta = null;
					ResultSet rs = null;
					try {
						sta = con.createStatement();
						rs = sta.executeQuery(sql);
						if(rs.next()){
							int counts = rs.getInt("count(*)");
							int totalPage=0;
							totalPage=counts%page.getPageSize()==0?counts/page.getPageSize():counts/page.getPageSize()+1;
							
							page.setTotalPage(totalPage);
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}finally{
						DAO.finish(null, null, con);
					}
				}
				//
				public void getData(GoodsPage page,String s1){
					ArrayList<SomainModel> list=new ArrayList<SomainModel>();
					String sql="select * from somain where cast(CreateTime as datetime) <= cast('"+s1+"' as datetime) and Status =4 LIMIT ?,?";
					Connection con = DAO.getConn();
					Statement sta = null;
					ResultSet rs = null;
					PreparedStatement ps = null;
					try {
						ps = con.prepareStatement(sql);
						
						ps.setInt(1, (page.getNowPage()-1)*page.getPageSize());
						ps.setInt(2, page.getPageSize());
						rs=ps.executeQuery();
						while(rs.next()){	
							
							SomainModel sm=new SomainModel();
							sm.setSOID(rs.getString("SOID"));
							sm.setCustomerCode(rs.getString("CustomerCode"));
							sm.setAccount(rs.getString("Account"));
							sm.setCreateTime(rs.getString("CreateTime"));
							sm.setTipFee(rs.getFloat("TipFee"));
							sm.setProductTotal(rs.getFloat("ProductTotal"));
							sm.setSOTotal(rs.getFloat("SOTotal"));
							sm.setPayType(rs.getString("PayType"));
							sm.setPrePayFee(rs.getFloat("PrePayFee"));
							sm.setStatus(rs.getInt("Status"));
							sm.setStockTime(rs.getString("StockTime"));
							sm.setStockUser(rs.getString("StockUser"));
							sm.setPayTime(rs.getString("PayTime"));
							sm.setPayUser(rs.getString("PayUser"));
							sm.setPrePayTime(rs.getString("PrePayTime"));
							sm.setPayUser(rs.getString("PayUser"));
							sm.setEndTime(rs.getString("EndTime"));
							sm.setEndUser(rs.getString("EndUser"));
							list.add(sm);
						}
						page.setData(list);
					} catch (SQLException e) {
						e.printStackTrace();
					}finally{
						DAO.finish(null, null, con);
					}
				}
		//查询商品库存数
		public int selectproductnum(String s){
			Connection con = DAO.getConn();
			Statement sta = null;
			ResultSet rs = null;
			PreparedStatement ps = null;
			int num=0;
			try {
				String sql="select Num from stock where ProductCode ='"+s+"'";
				ps = con.prepareStatement(sql);
				rs=ps.executeQuery();
				if(rs.next()){
					num=rs.getInt("Num");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				DAO.finish(null, null, con);
			}
			return num;
		}

				
				
}
				

