package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CategoryDao;
import com.model.Category;

public class UpdateCategoryServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		String name=request.getParameter("name1");
		String remark=request.getParameter("remark1");
		String nameold=request.getParameter("nameold");
		String remarkold=request.getParameter("remarkold");
		Category cdNew= new Category();
		cdNew.setName(name);
		cdNew.setRemark(remark);
		Category cdOld= new Category();
		cdOld.setName(nameold);
		cdOld.setRemark(remarkold);
		CategoryDao cd=new CategoryDao();
		cd.updateCategory(cdOld, cdNew);
		request.getRequestDispatcher("/SelectCategory").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
