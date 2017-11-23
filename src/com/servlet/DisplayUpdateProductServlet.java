package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CategoryDao;
import com.model.Category;

public class DisplayUpdateProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String productCode=request.getParameter("productCode");//产品编号
		String name=request.getParameter("name");//产品名称	
		String categoryID=request.getParameter("categoryID");//产品分类
		CategoryDao categoryDao =new CategoryDao();
		ArrayList<Category> alCategory=categoryDao.allCategory();
		String price=request.getParameter("price");//销售价
		String unitName=request.getParameter("unitName");//销售单位
		String remark=request.getParameter("remark");//描述
	/*	System.out.println(productCode);
		System.out.println(name);
		System.out.println(categoryID);
		System.out.println(alCategory);
		for(Category c : alCategory){
			System.out.println(c.getCategoryID());
			System.out.println(c.getName());
		}
		System.out.println(price);
		
		System.out.println(unitName);
		System.out.println(remark);*/
		request.setAttribute("productCode", productCode);
		request.setAttribute("name", name);
		request.setAttribute("categoryID", categoryID);
		request.setAttribute("alCategory", alCategory);
		request.setAttribute("price", price);
		request.setAttribute("unitName", unitName);
		request.setAttribute("remark", remark);
		request.getRequestDispatcher("gztm/updateProduct.jsp").forward(request, response);
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
