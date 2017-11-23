package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dao.OutStockRecordDao;
import com.dao.ProductDao;
import com.model.OutstockRecord;

public class Month_Outstock_FormServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/plain");
		String year=request.getParameter("year");
		String month=request.getParameter("month");
		OutStockRecordDao osrd= new OutStockRecordDao();
		ProductDao pd= new ProductDao();
		int totalList=osrd.totalList(year,month);
		//request.setAttribute("totalList", totalList);//总条数
		
		int totalNum=0;//总数目
		float totalPrice=0f;//总价格
		float productTotalPrice=0f;//某行的产品总价
		ArrayList<OutstockRecord> alOutstockRecord = osrd.selectByDate(year, month);
		for(OutstockRecord or :alOutstockRecord){
			totalNum+=or.getStockNum();
			//totalPrice+=(or.getStockNum())*(pd.getPriceByProductCode(or.getProductCode()));
			//productTotalPrice=(or.getStockNum())*(pd.getPriceByProductCode(or.getProductCode()));
			productTotalPrice=(osrd.soOneProductTotalPrice(or.getOrderCode(), or.getProductCode()));//某个产品总销售价
			totalPrice+=productTotalPrice;//所有总价
			or.setProductPrice(productTotalPrice);
			String productName=pd.getNameByProductCode(or.getProductCode());
			or.setProductName(productName);
		}
		//request.setAttribute("totalNum", totalNum);//总数目
		//request.setAttribute("totalPrice", totalPrice);//总价格
		//request.setAttribute("alOutstockRecord", alOutstockRecord);
		//request.getRequestDispatcher("gztm/month_outstock_form.jsp").forward(request, response);
		String jsonTotalList=JSONObject.toJSONString(totalList);//总条数
		String jsonTotalNum=JSONObject.toJSONString(totalNum);//总数目
		String jsonTotalPrice=JSONObject.toJSONString(totalPrice);//总价格
		String jsonAl=JSONArray.toJSONString(alOutstockRecord);
		PrintWriter out = response.getWriter();
		out.print(jsonTotalList+"!");
		out.print(jsonTotalNum+"!");
		out.print(jsonTotalPrice+"!");
		out.print(jsonAl);
		
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
