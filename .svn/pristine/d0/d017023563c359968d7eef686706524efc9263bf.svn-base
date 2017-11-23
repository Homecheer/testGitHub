package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.dao.SoitemDao;

import com.model.Soitem;

public class SoItemServlet extends HttpServlet {

	//销售单明细信息servlet
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//inMoney1,2,3.jsp页面中点击传过来soid
		String soId=request.getParameter("soid");
		SoitemDao soItemDao=new SoitemDao();
		//根据soid得到相对应的销售单明细信息
		ArrayList<Soitem> aSoItems=soItemDao.getSoItems(soId);
		request.setAttribute("aSoItems", aSoItems);
		request.getRequestDispatcher("gztm/SoItem.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}
