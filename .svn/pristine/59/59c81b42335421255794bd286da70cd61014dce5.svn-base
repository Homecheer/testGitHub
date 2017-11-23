package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.PomainDao;
import com.model.Pomain;

public class PoMainServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PomainDao poMainDao=new PomainDao();
		ArrayList<Pomain> aList=poMainDao.getPoMains();
		String type=request.getParameter("type");
		if (type!=null) {
			if (type.equals("1")) {//当付款类型为款到发货
				request.setAttribute("aList", aList);
				request.getRequestDispatcher("gztm/outMoney1.jsp").forward(request, response);
			}else if (type.equals("2")) {
				request.setAttribute("aList", aList);
				request.getRequestDispatcher("gztm/outMoney2.jsp").forward(request, response);
			}else if (type.equals("0")) {//当付款类型为货到付款
				request.setAttribute("aList", aList);
				request.getRequestDispatcher("gztm/outMoney.jsp").forward(request, response);
			}
			
		}else {
			request.setAttribute("aList", aList);
			request.getRequestDispatcher("gztm/outMoney3.jsp").forward(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
