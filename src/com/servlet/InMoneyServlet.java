package com.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.SomainDao;

public class InMoneyServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SomainDao sMainDao=new SomainDao();
		String payType=request.getParameter("payType");
		String endUser=(String) request.getSession().getAttribute("name");
		String ysStatus=request.getParameter("status");
		String endTime=df.format(new Date());
		String soid=request.getParameter("soid");
		int status=0;
		if (ysStatus.equals("2")&&payType.equals("货到付款")) {
			status=3;
			sMainDao.updateSoMains(soid, status, endTime, endUser);
			request.getRequestDispatcher("SoMain").forward(request, response);
		}else if (ysStatus.equals("1")&&payType.equals("款到发货")) {
			status=3;
			sMainDao.updateSoMains(soid, status, endTime, endUser);
			request.getRequestDispatcher("SoMain").forward(request, response);
		}else if (ysStatus.equals("1")&&payType.equals("预付款到发货")) {
			status=5;
			sMainDao.updateSoMains2(soid, status, endTime, endUser);
			request.getRequestDispatcher("SoMain").forward(request, response);
		}else if (ysStatus.equals("2")&&payType.equals("预付款到发货")) {
			status=3;
			sMainDao.updateSoMains(soid, status, endTime, endUser);
			request.getRequestDispatcher("SoMain").forward(request, response);
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
