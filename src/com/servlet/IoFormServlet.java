package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.IoFormDao;

public class IoFormServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String date=request.getParameter("startTime");
		IoFormDao ioDao=new IoFormDao();
		float soTotal=ioDao.getSoTotal(date);
		float poTotal=ioDao.getPoTotal(date);
		int soCount=ioDao.getSoCount(date);
		int poCount=ioDao.getPoCount(date);
		request.getSession().setAttribute("date", date);
		request.setAttribute("soTotal", soTotal);
		request.setAttribute("poTotal", poTotal);
		request.setAttribute("soCount", soCount);
		request.setAttribute("poCount", poCount);
		request.getRequestDispatcher("gztm/ioForm.jsp").forward(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}
