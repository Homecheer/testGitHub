package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CheckStockDao;
import com.dao.InStockRecordDao;
import com.dao.OutStockRecordDao;
import com.model.InstockRecord;
import com.model.OutstockRecord;

public class StockChangeRecordServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String productCode=request.getParameter("productCode");
		InStockRecordDao isrd=new InStockRecordDao();
		ArrayList<InstockRecord> alInStockRecord=isrd.selectAllInstockRecordByProductCode(productCode);//入库记录表中的数据
		OutStockRecordDao osrd=new OutStockRecordDao();
		ArrayList<OutstockRecord> alOutStockRecord = osrd.selectAllOutstockRecordByProductCode(productCode);//出库记录表中的数据
		CheckStockDao csd=new CheckStockDao();
		ArrayList<InstockRecord> alIn=csd.allInData(productCode);//盘点表,实际数量大于应有数量
		ArrayList<OutstockRecord> alOut=csd.allOutData(productCode);//盘点表,实际数量小于应有数量
		
		//把盘点出来的 放入相对于的集合
		alInStockRecord.addAll(alIn);
		alOutStockRecord.addAll(alOut);
		//传值显示
		request.setAttribute("alInStockRecord", alInStockRecord);
		request.setAttribute("alOutStockRecord", alOutStockRecord);
		request.getRequestDispatcher("gztm/stockChangeRecord.jsp").forward(request, response);
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
