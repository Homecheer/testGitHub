package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.dao.PomainDao;
import com.dao.ScmUserDao;

import com.dao.SomainDao;
import com.model.Pomain;
import com.model.Somain;

public class DeleteScmUserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		ScmUserDao sDao=new ScmUserDao();
		SomainDao soMainDao=new SomainDao();
		PomainDao poMainDao=new PomainDao();
		String name=(String) request.getSession().getAttribute("name");
		String account=request.getParameter("account");
		String delName=sDao.getAccount(account).getName();
		if (name.equals(delName)) {
			request.setAttribute("deleteError1", "此账户正在使用不能删除");
			request.getRequestDispatcher("manage").forward(request, response);
		}else {
			if (soMainDao.getAccount(account).isEmpty()&&poMainDao.getAccount(account).isEmpty()) {
				sDao.deleteAccount(account);
				request.setAttribute("deletesuccess", "删除成功");
				request.getRequestDispatcher("manage").forward(request, response);
				
			}else {
				request.setAttribute("deleteError", "已有对应销售单或采购单不能删除");
				request.getRequestDispatcher("manage").forward(request, response);
			}
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
