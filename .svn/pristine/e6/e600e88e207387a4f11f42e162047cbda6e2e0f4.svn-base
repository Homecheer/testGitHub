package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.OutStockRecordDao;
import com.dao.ProductDao;
import com.dao.SoitemDao;
import com.dao.SomainDao;
import com.dao.StockDao;
import com.model.ScmUser;
import com.model.Soitem;
import com.util.DBUtil;

public class OutStockServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		String soid =request.getParameter("soid");//销售单号
		SomainDao mainDao=new SomainDao();
		SoitemDao itemDao=new SoitemDao();
		ProductDao proDao=new ProductDao();
		OutStockRecordDao osrd=new OutStockRecordDao();
		StockDao sd=new StockDao();
		try {
			//更新销售单主表      状态、出库登记时间、出库登记处理员
			mainDao.changeStatus(soid);
			mainDao.outStockTime(soid);
			ScmUser user=(ScmUser) request.getSession().getAttribute("sUser");
			String name=user.getName();
			mainDao.outStockUser(soid, name);
			
			ArrayList<Soitem> alsoitem=itemDao.selectSoitemData(soid);
			for(Soitem s:alsoitem){
				//更新产品表 销售在途数
				proDao.updateSoNum(s.getProductCode(), s.getNum());
				//出库记录表 插入数据     产品编号、销售单号、出库数量、出库类型、出库时间、经手人(暂时伪造,应为当前登录的仓库管理用户的name)
				osrd.outStock(soid, s, name);	
				//更新库存表
				sd.updateNum_Out(s.getProductCode(), s.getNum());
				
			}
		} catch (SQLException e) {
			try {
				//回滚
				mainDao.conn.rollback();
				proDao.conn.rollback();
				osrd.conn.rollback();
				sd.conn.rollback();
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try {
				//设为自动
				mainDao.conn.setAutoCommit(true);
				proDao.conn.setAutoCommit(true);
				osrd.conn.setAutoCommit(true);
				sd.conn.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			//关闭连接
			DBUtil.close(mainDao.rs, mainDao.pstmt, mainDao.conn);
			DBUtil.close(proDao.rs, proDao.pstmt, proDao.conn);
			DBUtil.close(osrd.rs, osrd.pstmt, osrd.conn);
			DBUtil.close(sd.rs, sd.pstmt, sd.conn);
		}
		request.getRequestDispatcher("/SelectAllSomain").forward(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
