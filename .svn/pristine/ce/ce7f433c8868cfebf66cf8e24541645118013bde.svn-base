package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

import com.model.Poitem;
import com.model.Pomain;
import com.model.PomainPage;
import com.model.PomainSearch;
import com.model.PomainStatement;
import com.model.Product;
import com.model.ScmUser;
import com.model.Vender;
import com.util.DBUtil;

public class PomainDao_CG {
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql;
	public ArrayList<Pomain> getPomains(int index,int pageSize,int status,String account){//0表示全部，1表示新增，2表示已收货，3表示已付款，4表示已了结，5表示已付款
		String str="";
		if(status==1||status==2||status==3||status==4||status==5) 
			str="and p.status="+status;
		sql="select p.poid,p.createtime,p.account,s.name as accountName,v.name,p.tipfee,p.producttotal,p.pototal,p.paytype,p.prepayfee from pomain p,vender v,scmuser s where v.VenderCode=p.VenderCode "+str+" and s.account=p.account and p.account='"+account+"' order by p.poid asc limit "+index+","+pageSize;
		ArrayList<Pomain> al=new ArrayList<Pomain>();
		try {
			conn = DBUtil.getConn();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				Pomain p=new Pomain();
				p.setPoid(rs.getString("poid"));
				p.setCreateTime(rs.getString("createtime"));
				p.setAccount(rs.getString("account"));
				p.setAccountName(rs.getString("accountName"));
				p.setVenderName(rs.getString("name"));
				p.setTipFee(rs.getFloat("tipfee"));
				p.setProductTotal(rs.getFloat("producttotal"));
				p.setPoTotal(rs.getFloat("pototal"));
				p.setPayType(rs.getString("paytype"));
				p.setPrePayFee(rs.getFloat("prepayfee"));	
				al.add(p);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, stmt, conn);
		}
		return al;
	}
	
	public int delPomain(String poid/*,ScmUser su*/){
		int n=0;//-2表示非本人订单，-1表示采购进行中，0表示del失败，1表示del成功		
		try {
			conn = DBUtil.getConn();
			stmt=conn.createStatement();
//			sql="select * from pomain where poid='"+poid+"' and account='"+su.getAccount()+"'";
//			rs=stmt.executeQuery(sql);
//			if(!rs.next()){
//				n=-2;
//				return n;
//			}
			sql="select *from pomain where poid='"+poid+"' and status=1";
			rs=stmt.executeQuery(sql);
			while(!rs.next()){
				n=-1;
				return n;	
			}
			conn.setAutoCommit(false);
			sql="update pomain p,poitem po,product pr set pr.PONum=pr.PONum-po.num where p.poid='"+poid+"' and p.poid=po.poid and po.ProductCode=pr.ProductCode";
			stmt.executeUpdate(sql);
			sql="delete from poitem where poid='"+poid+"'";
			stmt.executeUpdate(sql);
			sql="delete from pomain where poid='"+poid+"'";
			stmt.executeUpdate(sql);
			conn.commit();
			n=1;	
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
			DBUtil.close(rs, stmt, conn);
		}
		return n;
	}
	
	public ArrayList<Vender> getAllVenders(){
		sql="select * from vender";
		ArrayList<Vender> al=new ArrayList<Vender>();
		try {
			conn = DBUtil.getConn();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				Vender v=new Vender();
				v.setVenderCode(rs.getString("VenderCode"));
				v.setName(rs.getString("name"));
				al.add(v);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, stmt, conn);
		}
		return al;
	}
	public ArrayList<Product> getAllProducts(){
		sql="select * from product";
		ArrayList<Product> al=new ArrayList<Product>();
		try {
			conn = DBUtil.getConn();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				Product p=new Product();
				p.setProductCode(rs.getString("ProductCode"));
				p.setName(rs.getString("name"));
				p.setUnitName(rs.getString("UnitName"));
				al.add(p);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, stmt, conn);
		}
		return al;
	}
	public int addPomain(boolean flag,String poid, String createTime,
			String venderCode, String account, String tipFee,
			String productTotal, String payType, String remark,
			String prePayFee, String[] productCodes, String[] unitNames,
			String[] nums, String[] unitPrices){
		int n=0;//0表示添加失败，1表示添加成功
		try {
			conn = DBUtil.getConn();
			conn.setAutoCommit(false);
			//采购主单添加
			if(flag){
				sql="insert into pomain(venderCode,tipFee,productTotal,POTotal,payType,prePayFee,status,remark,poid,createTime,account) values(?,?,?,?,?,?,?,?,?,?,?);";
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(10,createTime);
				pstmt.setString(11,account);
			}
			else{
				sql="update pomain set venderCode=?,tipFee=?,productTotal=?,POTotal=?,payType=?,prePayFee=?,status=?,remark=? where poid=?;";
				pstmt=conn.prepareStatement(sql);
			}
			pstmt.setString(1,venderCode);
			pstmt.setFloat(2,((int)(Float.parseFloat(tipFee)*100))/100.0f);
			pstmt.setFloat(3,((int)(Float.parseFloat(productTotal)*100))/100.0f);
			pstmt.setFloat(4,((int)(Float.parseFloat(productTotal)*100))/100.0f+((int)(Float.parseFloat(tipFee)*100))/100.0f);//
			pstmt.setString(5,payType);
			pstmt.setFloat(6,((int)(Float.parseFloat(prePayFee)*100))/100.0f);
			pstmt.setInt(7,1);//
			pstmt.setString(8,remark);
			pstmt.setString(9,poid);
			pstmt.executeUpdate();	
			//明细添加
			if(!flag){
				sql="update pomain p,poitem po,product pr set pr.PONum=pr.PONum-po.num where p.poid=? and p.poid=po.poid and po.ProductCode=pr.ProductCode";
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1,poid);
				pstmt.executeUpdate();
				sql="Delete from poitem where poid=?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1,poid);
				pstmt.executeUpdate();		
			}
			sql="insert into poitem(ProductCode,UnitPrice,Num,UnitName,ItemPrice,Poid) values(?,?,?,?,?,?);";	
			pstmt=conn.prepareStatement(sql);
			for(int i=0;i<productCodes.length;i++){
				pstmt.setString(1,productCodes[i]);
				pstmt.setFloat(2,((int)(Float.parseFloat(unitPrices[i])*100))/100.0f);
				pstmt.setInt(3,Integer.parseInt(nums[i]));
				pstmt.setString(4,unitNames[i]);
				pstmt.setFloat(5,((int)(Float.parseFloat(unitPrices[i])*100))/100.0f*Integer.parseInt(nums[i]));
				pstmt.setString(6,poid);
				pstmt.addBatch();	
			}
			pstmt.executeBatch();
			
			//在途数修改
			sql="update product set PONum=PONum+? where ProductCode=?";
			pstmt=conn.prepareStatement(sql);
			for(int i=0;i<productCodes.length;i++){
				pstmt.setInt(1,Integer.parseInt(nums[i]));
				pstmt.setString(2,productCodes[i]);
				pstmt.addBatch();	
			}
			pstmt.executeBatch();
					
			n=1;
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
			//DBUtil.close(rs, stmt, null);
			DBUtil.close(null, pstmt, conn);
		}
		return n;
	}
	public int modifyStatus(String poid/*,ScmUser su*/){
		int n=0;//-2表示非本人订单，-1表示非新添,0表示数据异常，无法修改，1表示可以修改	
		try {
			conn = DBUtil.getConn();
			stmt=conn.createStatement();
			sql="select * from pomain where poid='"+poid+"'";
			rs=stmt.executeQuery(sql);
			if(!rs.next()){
				n=-2;
				return n;
			}
			sql="select * from pomain where poid='"+poid+"' and status<>1";
			rs=stmt.executeQuery(sql);
			if(rs.next()){
				n=-1;
				return n;
			}
			n=1;
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, stmt, conn);
		}
		return n;
	}
	public Pomain getModifyPomain(String poid){
		Pomain pm=null;
		try {
			conn = DBUtil.getConn();
			stmt=conn.createStatement();
			sql="select p.poid,p.createtime,v.vendercode,v.name,p.account,s.name as accountname,p.tipfee,p.producttotal,p.paytype,p.remark,p.prepayfee,p.pototal,p.status,p.stocktime,p.stockuser,p.paytime,p.payuser,p.prepaytime,p.prepayuser,p.endtime,p.enduser from pomain p,vender v,scmuser s where p.POID='"+poid+"' and p.VenderCode=v.VenderCode and s.account=p.account";
			rs=stmt.executeQuery(sql);
			rs.next();
			pm=new Pomain();
			pm.setPoid(rs.getString("POID"));
			pm.setCreateTime(rs.getString("createTime"));
			pm.setVenderCode(rs.getString("VenderCode"));
			pm.setVenderName(rs.getString("Name"));
			pm.setAccount(rs.getString("Account"));
			pm.setAccountName(rs.getString("AccountName"));
			pm.setTipFee(rs.getFloat("TipFee"));
			pm.setProductTotal(rs.getFloat("ProductTotal"));
			pm.setPayType(rs.getString("PayType"));
			pm.setRemark(rs.getString("Remark"));
			pm.setPrePayFee(rs.getFloat("PrePayFee"));
			
			pm.setPoTotal(rs.getFloat("POTotal"));//总价格 
			pm.setStatus(rs.getInt("status")); 
			pm.setStockTime(rs.getString("StockTime"));//入库登记时间 
			pm.setStockUser(rs.getString("StockUser"));//入库登记用户 
			pm.setPayTime(rs.getString("PayTime"));//付款登记时间 
			pm.setPayUser(rs.getString("PayUser"));//付款登记用户 
			pm.setPrePayTime(rs.getString("PrePayTime"));//预付款登记时间 
			pm.setPrePayUser(rs.getString("PrePayUser"));// 
			pm.setEndTime(rs.getString("EndTime"));//了解时间 
			pm.setEndUser(rs.getString("EndUser"));//
			  
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, stmt, conn);
		}
		return pm;
	}
	public ArrayList<Poitem> getModifyPoitem(String poid){
		ArrayList<Poitem> pis=null;
		try {
			pis=new ArrayList<Poitem>();
			conn = DBUtil.getConn();
			stmt=conn.createStatement();
			sql="select * from poitem pi,product pr where pi.poid='"+poid+"' and pi.productCode=pr.productCode";
			rs=stmt.executeQuery(sql);
			while(rs.next()){
				Poitem pi=new Poitem();
				pi.setProductCode(rs.getString("ProductCode"));
				pi.setProductName(rs.getString("Name"));
				pi.setUnitName(rs.getString("UnitName"));
				pi.setNum(rs.getInt("Num"));
				pi.setUnitPrice(rs.getFloat("UnitPrice"));
				
				pi.setItemPrice(rs.getFloat("ItemPrice"));
				
				pis.add(pi);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, stmt, conn);
		}
		return pis;
	}
	
	public ArrayList<Pomain> getFinishPomains(int index,int pageSize,String str,String account){
		int status=3;
		if(str.equals("款到发货")) status=2;
		
		String str1="and p.status="+status+" and  p.paytype='"+str+"' and p.account='"+account+"'";
		
		sql="select p.poid,p.createtime,p.account,s.name as AccountName,v.name,p.tipfee,p.producttotal,p.pototal,p.paytype,p.prepayfee,p.status from pomain p,vender v,scmuser s where v.VenderCode=p.VenderCode and s.account=p.account "+str1+" order by p.poid asc limit "+index+","+pageSize;
		ArrayList<Pomain> al=new ArrayList<Pomain>();
		try {
			conn = DBUtil.getConn();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				Pomain p=new Pomain();
				p.setPoid(rs.getString("poid"));
				p.setCreateTime(rs.getString("createtime"));
				p.setAccount(rs.getString("account"));
				p.setAccountName(rs.getString("accountName"));
				p.setVenderName(rs.getString("name"));
				p.setTipFee(rs.getFloat("tipfee"));
				p.setProductTotal(rs.getFloat("producttotal"));
				p.setPoTotal(rs.getFloat("pototal"));
				p.setPayType(rs.getString("paytype"));
				p.setPrePayFee(rs.getFloat("prepayfee"));
				p.setStatus(rs.getInt("status"));
				al.add(p);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, stmt, conn);
		}
		return al;
	}
	
	public int finishPomain(String poid,String accountName){
		int n=0;//-1表示非本人订单，0表示了结失败，1表示了结成功		
		try {
			conn = DBUtil.getConn();
			stmt=conn.createStatement();
//			sql="select * from pomain where poid='"+poid+"' and account='"+su.getAccount()+"'";
//			rs=stmt.executeQuery(sql);
//			if(!rs.next()){
//				n=-1;
//				return n;
//			}
				//,EndUser='"+su+"'		
			sql="update pomain set status=4,EndTime=now(),EndUser='"+accountName+"' where poid='"+poid+"'";
			stmt.executeUpdate(sql);				
			n=1;	
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			
			DBUtil.close(null, stmt, conn);
		}
		return n;
	}
	public ArrayList<Pomain> searchPomains(PomainPage page,PomainPageDao ppd,int index,int pageSize,String poidPart,String timeStart,String timeEnd,String venderCode,String payType,String status){
		if(poidPart!="") poidPart=" and p.poid like '%"+poidPart+"%'";
		if(timeStart!="") timeStart=" and cast(p.createtime as datetime)>=cast('"+timeStart+"' as datetime)";
		if(timeEnd!="") timeEnd=" and cast(p.createtime as datetime)<=cast('"+timeEnd+"' as datetime)";
		if(venderCode!="") venderCode=" and v.venderCode='"+venderCode+"'";
		if(payType!="") payType=" and p.payType='"+payType+"'";
		if(status!="") status=" and p.status='"+status+"'";
		String str=poidPart+timeStart+timeEnd+venderCode+payType+status;
		if(page!=null) {ppd.setToTalPage("pomain p,vender v where p.vendercode=v.vendercode "+str,page);return null;}
		sql="select p.poid,p.createtime,p.account,s.name as AccountName,v.name,p.tipfee,p.producttotal,p.pototal,p.paytype,p.prepayfee,p.status from pomain p,vender v,scmuser s where s.account=p.account and v.VenderCode=p.VenderCode "+str+"order by p.poid asc limit "+index+","+pageSize;
		ArrayList<Pomain> al=new ArrayList<Pomain>();
		try {
			conn = DBUtil.getConn();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				Pomain p=new Pomain();
				p.setPoid(rs.getString("poid"));
				p.setCreateTime(rs.getString("createtime"));
				p.setAccount(rs.getString("account"));
				p.setAccountName(rs.getString("accountName"));
				p.setVenderName(rs.getString("name"));
				p.setTipFee(rs.getFloat("tipfee"));
				p.setProductTotal(rs.getFloat("producttotal"));
				p.setPoTotal(rs.getFloat("pototal"));
				p.setPayType(rs.getString("paytype"));
				p.setPrePayFee(rs.getFloat("prepayfee"));
				p.setStatus(rs.getInt("status"));
				al.add(p);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, stmt, conn);
		}
		return al;
	}
	public  ArrayList<Pomain> getPomainStatement(int index,int pageSize,String poidPart,PomainStatement ps){
		ArrayList<Pomain> al=new ArrayList<Pomain>();
		ResultSet rs1=null;
		try {
			conn = DBUtil.getConn();
			stmt = conn.createStatement();
			sql="select count(*) from pomain where poid like '%"+poidPart+"%'";
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				ps.setPurchaseNum(rs.getInt("count(*)"));
			}
			else{
				ps.setPurchaseNum(0);
			}
			sql="select count(*) from pomain where status=4 and poid like '%"+poidPart+"%'";
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				ps.setFinishNum(rs.getInt("count(*)"));
			}
			else{
				ps.setFinishNum(0);
			}
			
			
			sql="select p.poid,v.venderCode,v.name,p.createtime,p.pototal,p.status,p.paytype,p.prepayfee from pomain p,vender v where p.vendercode=v.vendercode and p.poid like '%"+poidPart+"%' order by p.poid asc limit "+index+","+pageSize;
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				Pomain p=new Pomain();
				p.setPoid(rs.getString("poid"));
				p.setCreateTime(rs.getString("createtime").substring(0,10));
				p.setVenderCode(rs.getString("vendercode"));
				p.setVenderName(rs.getString("name"));
				p.setPoTotal(rs.getFloat("pototal"));
				p.setPayType(rs.getString("paytype"));
				p.setPrePayFee(rs.getFloat("prepayfee"));
				p.setStatus(rs.getInt("status"));
				
				String colName=null;
				int status=0;
				if(rs.getInt("status")==1){status=1;colName="s.name";}
				else if(rs.getInt("status")==2){status=2;colName="p.StockUser";}
				else if(rs.getInt("status")==3){status=3;colName="p.PayUser";}
				else if(rs.getInt("status")==4){status=4;colName="p.EndUser";}
				else if(rs.getInt("status")==5){status=5;colName="p.PrePayUser";}
				sql="select "+colName+" as colName from pomain p,scmuser s where p.account=s.account and p.poid=? and p.status=?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1,rs.getString("poid"));
				pstmt.setInt(2,status);
				rs1=pstmt.executeQuery();
				rs1.next();
				p.setCreateUser(rs1.getString("colName"));
				al.add(p);
			}
			
			float purchaseMoney=0;
			sql="select sum(pototal) from pomain  where  poid like '%"+poidPart+"%'";
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				purchaseMoney=rs.getFloat("sum(pototal)");
			}
			ps.setPurchaseMoney(purchaseMoney);
			
			float paidMoney=0;
			sql="select sum(pototal) from pomain where ((paytype='货到付款' and status>2) or (paytype='款到发货' and status>1) or (paytype='预付款到发货' and status between 3 and 4)) and poid like '%"+poidPart+"%'";
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				paidMoney+=rs.getFloat("sum(pototal)");
			}
			sql="select sum(prepayfee) from pomain where paytype='预付款到发货' and (status=5 or status=2) and poid like '%"+poidPart+"%'";
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				paidMoney+=rs.getFloat("sum(prepayfee)");
			}
			ps.setPaidMoney(paidMoney);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(rs1, pstmt,null);
			DBUtil.close(rs, stmt, conn);
		}
		return al;
	}
}
