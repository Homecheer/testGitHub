package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.org.mozilla.javascript.internal.json.JsonParser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dao.ProductDao;
import com.dao.StockDao;
import com.model.Stock;

public class SelectStockByConditions extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/plain");
		String productCode =request.getParameter("productCode");
		String productName =request.getParameter("productName");
		String num_Min=request.getParameter("num_Min");
		String num_Max=request.getParameter("num_Max");
		String where =null;
		
		//拼接sql语句
		if((!productCode.equals(""))||(!productName.equals(""))||(!num_Min.equals(""))||(!num_Max.equals(""))){
			where=" where ";
			if(!productCode.equals("")){
				productCode=" ProductCode like  '%"+productCode +"%' ";
			}
			if(!productName.equals("")){
				if(!productCode.equals("")){
					productName=" and Name like '%"+productName+"%' ";
				}else {
					productName=" Name like '%"+productName+"%' ";					
				}
			}
			if(!num_Min.equals("")){
				if(!productCode.equals("")||!productName.equals("")){
					num_Min=" and Num>="+num_Min;
				}else{
					num_Min=" Num>="+num_Min;
				}
			}
			if(!num_Max.equals("")){
				if(!productCode.equals("")||!productName.equals("")||!num_Min.equals("")){
					num_Max=" and Num<="+num_Max;
				}else{
					num_Max=" Num<="+num_Max;
				}
			}
			
		}
		String sql=null;
		if(productCode.equals("")&&productName.equals("")&&num_Min.equals("")&&num_Max.equals("")){
			sql="select * from stock ";
		}else{
			sql="select * from stock "+ where +productCode+productName+num_Min+num_Max;			
		}
		
		StockDao sd= new StockDao();
		ArrayList<Stock> al =sd.selectByConditions(sql);
		ProductDao pd=new ProductDao();
		for(Stock s:al){
			int [] arr=pd.getPoNumAndSoNumByProductCode(s.getProductCode());
			s.setPoNum(arr[0]);
			s.setSoNum(arr[1]);
		}
		
		String alStr =JSONArray.toJSONString(al);
		PrintWriter out = response.getWriter();
		out.print(alStr);
		//request.setAttribute("al", al);
		//request.getRequestDispatcher("gztm/stockQuery.jsp").forward(request, response);
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
