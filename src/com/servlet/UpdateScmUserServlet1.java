package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ScmUserDao;

public class UpdateScmUserServlet1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		ScmUserDao sDao=new ScmUserDao();
		String account=request.getParameter("account");
		//System.out.println(account);
		String name=request.getParameter("name");
		String password=request.getParameter("password");
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
		}else {
			sDao.updateScmUser(name, password, status, account, qx);
			request.setAttribute("updateSuccess", "修改成功");
			request.getRequestDispatcher("manage").forward(request, response);
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}
