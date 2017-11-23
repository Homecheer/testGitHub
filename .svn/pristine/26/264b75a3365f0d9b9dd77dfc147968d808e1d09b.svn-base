package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.InStockRecordDao;
import com.dao.PoitemDao;
import com.dao.PomainDao;
import com.dao.ProductDao;
import com.dao.StockDao;
import com.model.Poitem;
import com.util.DBUtil;
import com.model.ScmUser;
public class InStockServlet extends HttpServlet {

	private static final String ScmUser = null;



	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String poid =request.getParameter("poid");//采购编号
		PomainDao mainDao=new PomainDao();
		PoitemDao itemDao=new PoitemDao();
		ProductDao  proDao=new ProductDao();
		InStockRecordDao isrd=new InStockRecordDao();
		StockDao sd=new StockDao();
		try {
			//更新采购单主表      状态、入库登记时间、入库登记处理员
			mainDao.changeStatus(poid);
			mainDao.inStockTime(poid);
			ScmUser user=(ScmUser) request.getSession().getAttribute("sUser");
			String name=user.getName();
			mainDao.inStockUser(poid, name);
			ArrayList<Poitem> alpoitem=itemDao.selectPoitemData(poid);
			for(Poitem p:alpoitem){
				//更新产品表 采购在途数
				proDao.updatePoNum(p.getProductCode(), p.getNum());
				//入库记录表 插入数据     产品编号、采购单号、入库数量、入库类型、入库时间、经手人(暂时伪造,应为当前登录的仓库管理用户的name)
				isrd.inStock(poid,p, name);
				//更新库存表
				sd.updateNum_In(p.getProductCode(), p.getNum());
			}
			
		} catch (SQLException e) {
			try {
				//回滚
				mainDao.conn.rollback();
				proDao.conn.rollback();
				isrd.conn.rollback();
				sd.conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try {
				//所有dao都设置为自动
				mainDao.conn.setAutoCommit(true);
				proDao.conn.setAutoCommit(true);
				isrd.conn.setAutoCommit(true);
				sd.conn.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			//关闭所有dao的物件
			DBUtil.close(mainDao.rs, mainDao.pstmt, mainDao.conn);
			DBUtil.close(proDao.rs, proDao.pstmt, proDao.conn);
			DBUtil.close(isrd.rs, isrd.pstmt, isrd.conn);
			DBUtil.close(sd.rs, sd.pstmt, sd.conn);
		}
		
		request.getRequestDispatcher("/SelectAllPomain").forward(request, response);
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
