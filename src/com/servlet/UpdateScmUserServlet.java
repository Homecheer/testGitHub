package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ScmUserDao;
import com.model.ScmUser;

public class UpdateScmUserServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		ScmUserDao sDao=new ScmUserDao();
		String account=request.getParameter("account");
		String modelName=request.getParameter("modelName").trim();
		String[] modelNameArr=modelName.split(" ");
		ScmUser sUser=sDao.getAccount(account);
		if (sUser!=null) {
			request.setAttribute("modelNameArr", modelNameArr);
			request.setAttribute("sUser", sUser);
			request.getRequestDispatcher("gztm/updateScmUser.jsp").forward(request, response);
		}
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
