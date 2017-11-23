package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.SomainDao;
import com.model.Somain;

public class SoMainServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		SomainDao soMainDao=new SomainDao();
		ArrayList<Somain> aList=soMainDao.getSoMains();
		String type=request.getParameter("type");
		if (type!=null) {
			if (type.equals("1")) {//当付款类型为款到发货
				request.setAttribute("inMoneyError", request.getAttribute("inMoneyError"));
				request.setAttribute("aList", aList);
				request.getRequestDispatcher("gztm/inMoney1.jsp").forward(request, response);
			}else if (type.equals("2")) {
				request.setAttribute("inMoneyError", request.getAttribute("inMoneyError"));
				request.setAttribute("aList", aList);
				request.getRequestDispatcher("gztm/inMoney2.jsp").forward(request, response);
			}else if (type.equals("0")) {//当付款类型为货到付款
				request.setAttribute("inMoneyError", request.getAttribute("inMoneyError"));
				request.setAttribute("aList", aList);
				request.getRequestDispatcher("gztm/inMoney.jsp").forward(request, response);
			}
			
		}else {
			request.setAttribute("inMoneyError", request.getAttribute("inMoneyError"));
			request.setAttribute("aList", aList);
			request.getRequestDispatcher("gztm/inMoney3.jsp").forward(request, response);
			//response.sendRedirect("gztm/inMoney3.jsp");
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
