package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.IoFormItemDao;

import com.model.Pomain;

import com.model.Somain;

public class IoFormItemServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String date=(String) request.getSession().getAttribute("date");;
		//System.out.println(date);
		String type=request.getParameter("type");
		IoFormItemDao itemDao=new IoFormItemDao();
		ArrayList<Somain> soList=itemDao.getIoFormItem(date);
		ArrayList<Pomain> poList=itemDao.getIoFormItem1(date);
		if (type.equals("so")) {
			request.setAttribute("soList", soList);
			request.getRequestDispatcher("gztm/soItemForm.jsp").forward(request, response);
		}else {
			request.setAttribute("poList", poList);
			request.getRequestDispatcher("gztm/poItemForm.jsp").forward(request, response);	
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
