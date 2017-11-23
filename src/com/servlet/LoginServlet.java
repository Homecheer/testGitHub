package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ScmUserDao;
import com.model.ScmUser;

public class LoginServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		ScmUserDao sDao=new ScmUserDao();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String name=request.getParameter("name");//这个name其实是account，因为是根据account来登录的
		request.setAttribute("name_temp",name);
		String password=request.getParameter("password");
		ScmUser sUser=sDao.getNamePass(name, password);		
		String time=df.format(new Date());
		if (sUser!=null) {
			if (sUser.getStatus().equals("n")) {
				sUser.setLoginTime(time);
				request.getSession().setAttribute("sUser", sUser);
				request.getSession().setAttribute("name",sUser.getName());
				//request.getRequestDispatcher("index.jsp").forward(request, response);
				response.sendRedirect("/SCM/index.jsp");
			}else {
				request.setAttribute("statusError", "你已被锁定不能登入");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}else {
			request.setAttribute("error", "用户名或密码错误");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
