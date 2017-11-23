package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StockFormDao;
import com.model.Stock;

public class StockFormServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		StockFormDao sFormDao=new StockFormDao();
		String date=request.getParameter("startTime");
		int thenStock=sFormDao.getNowNum()-sFormDao.getPoNum(date)+sFormDao.getSoNum(date)+sFormDao.getCheckNum(date);
		ArrayList<Stock> aList=sFormDao.getStocks(date);
		request.setAttribute("thenStock", thenStock);
		request.setAttribute("stock", aList);
		request.getRequestDispatcher("gztm/stockForm.jsp").forward(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
