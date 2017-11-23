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
import com.dao.InStockRecordDao;
import com.dao.ProductDao;
import com.model.InstockRecord;

public class Month_Instock_FormServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/plain");
		String year=request.getParameter("year");
		String month=request.getParameter("month");
		
		InStockRecordDao isrd=new InStockRecordDao();
		ProductDao pd= new ProductDao();
		int totalList=isrd.totalList(year,month);
		//request.setAttribute("totalList", totalList);//总条数
		int totalNum=0;
		float totalPrice=0f;
		float productTotalPrice=0f;
		ArrayList<InstockRecord> alInstockRecord=isrd.selectByDate(year, month);
		for(InstockRecord ir:alInstockRecord){
			totalNum+=ir.getStockNum();
			//productTotalPrice=(ir.getStockNum())*(pd.getPriceByProductCode(ir.getProductCode()));
			productTotalPrice=(isrd.poOneProductTotalPrice(ir.getOrderCode(), ir.getProductCode()));
			//totalPrice+=(ir.getStockNum())*(pd.getPriceByProductCode(ir.getProductCode()));
			totalPrice+=productTotalPrice;
			ir.setProductPrice(productTotalPrice);//某项产品总价格
			String productName=pd.getNameByProductCode(ir.getProductCode());
			ir.setProductName(productName);
		}
		//request.setAttribute("totalNum", totalNum);//总数目
		//request.setAttribute("totalPrice", totalPrice);//总价格
		//request.setAttribute("alInstockRecord", alInstockRecord);
		//request.getRequestDispatcher("gztm/month_instock_form.jsp").forward(request, response);
		PrintWriter out = response.getWriter();
		String jsonTotalList=JSONObject.toJSONString(totalList);//总条数
		String jsonTotalNum=JSONObject.toJSONString(totalNum);//总数目
		String jsonTotalPrice=JSONObject.toJSONString(totalPrice);//总价格
		String jsonAl=JSONArray.toJSONString(alInstockRecord);
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
