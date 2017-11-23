package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.PageServletDao;
import com.dao.ScmUserDao;
import com.model.Page;
import com.model.ScmUser;

public class UserManageServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		Page page=new Page();
		PageServletDao ud=new PageServletDao();
		String num=request.getParameter("num");
		if (num==null) {
			num="1";
		}
		//获取每页的条数
		page.setPageNum(4);
		//获取页面总数
		ud.getNum(page);
			//获取当前页面
			page.setNowPage(Integer.valueOf(num));
			//获取页面显示的内容
			ud.getContext((Integer.valueOf(num)-1)*page.getPageNum(), page.getPageNum(), page);
			/*ScmUserDao sDao=new ScmUserDao();
		ArrayList<ScmUser> aList=sDao.getAllSuser();*/
			request.setAttribute("adderror", request.getAttribute("adderror"));
			request.setAttribute("addError1", request.getAttribute("addError1"));
			request.setAttribute("addsuccess", request.getAttribute("addsuccess"));
			request.setAttribute("deletesuccess", request.getAttribute("deletesuccess"));
			request.setAttribute("updateSuccess", request.getAttribute("updateSuccess"));
			request.setAttribute("deleteError", request.getAttribute("deleteError"));
			request.setAttribute("deleteError1", request.getAttribute("deleteError1"));
			request.setAttribute("page", page);
			//request.setAttribute("scmUAlist", aList);
			//response.sendRedirect("gztm/th.jsp");
			request.getRequestDispatcher("gztm/th.jsp").forward(request, response);
			
			
		}
	

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
