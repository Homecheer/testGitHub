package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CheckStockDao;

public class StockServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String num1=request.getParameter("num");
		if (!num1.equals("")) {
			int ysNum=Integer.valueOf(request.getParameter("ysNum"));
			int num=Integer.valueOf(request.getParameter("num"));
			String productCode=request.getParameter("productCode");
			String type=request.getParameter("type");
			String time=request.getParameter("time");
			String people=request.getParameter("people");
			String reason=request.getParameter("reason");
			int sjNum=0;
			if (type.equals("损耗")) {
				sjNum=ysNum-num;
			}else {
				sjNum=ysNum+num;
			}
			CheckStockDao cStockDao=new CheckStockDao();
			cStockDao.stock(productCode, sjNum);
			cStockDao.addCheckStock(productCode, ysNum, sjNum, time, people, reason, type);
			request.setAttribute("pdSuccess", "盘点成功");
			request.getRequestDispatcher("CheckStock").forward(request, response);
		}else {
			request.setAttribute("pdError", "盘点失败");
			request.getRequestDispatcher("CheckStock").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
