package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CheckStockDao;
import com.model.CheckStock;

public class CheckStockServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		CheckStockDao cStockDao=new CheckStockDao();
		ArrayList<CheckStock> aList=cStockDao.getCheckStocks();
		request.setAttribute("checkStockArr", aList);
		request.setAttribute("pdSuccess", request.getAttribute("pdSuccess"));
		request.getRequestDispatcher("gztm/count.jsp").forward(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
	}

}
