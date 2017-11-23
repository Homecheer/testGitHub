package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ScmUserDao;

public class AddScmUserServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		ScmUserDao sDao=new ScmUserDao();
		String account=request.getParameter("account");
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String createdate=request.getParameter("createdate");
		String status=request.getParameter("y");
		String gl=request.getParameter("gl");
		String cg=request.getParameter("cg");
		String cz=request.getParameter("cz");
		String xs=request.getParameter("xs");
		String cw=request.getParameter("cw");
		String[] qx={gl,cg,cz,xs,cw};
		if (account.equals("")||name.equals("")||password.equals("")||qx.length==0) {
			request.setAttribute("addError1", "账号、用户名、密码和权限不能为空");
			request.getRequestDispatcher("manage").forward(request, response);
		}else if (sDao.getAccount(account)!=null) {
			request.setAttribute("adderror", "增加失败，账号已存在");
			request.getRequestDispatcher("manage").forward(request, response);
		}else {
			sDao.addUser(name, password, createdate, status, account,qx);
			request.setAttribute("addsuccess", "增加成功");
			request.getRequestDispatcher("manage").forward(request, response);
			
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
	}

}
