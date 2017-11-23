package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.dao.PoitemDao;


import com.model.Poitem;


public class PoItemServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//inMoney1,2,3.jsp页面中点击传过来soid
		String poId=request.getParameter("poid");
		PoitemDao poItemDao=new PoitemDao();
		//根据soid得到相对应的销售单明细信息
		ArrayList<Poitem> aPoItems=poItemDao.getPoItems(poId);
		request.setAttribute("aPoItems", aPoItems);
		request.getRequestDispatcher("gztm/PoItem.jsp").forward(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
