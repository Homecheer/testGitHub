package com.servlet;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.CategoryClassModel;
import com.util.DBUtil1;
public class AddClassServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		DBUtil1 db=new DBUtil1();
		String id="[0-9]{1,11}";
		String name="[\u4e00-\u9fa5]{1,20}";
		String ID=request.getParameter("CategoryID");
		String Name=request.getParameter("CategoryName");
		System.out.println(ID.matches(id));
		System.out.println(Name.matches(name));
		if(ID.matches(id)&&Name.matches(name)){
			int CategoryID=Integer.parseInt(request.getParameter("CategoryID"));
			String CategoryName=request.getParameter("CategoryName");
			String CategoryRemark=request.getParameter("CategoryRemark");
			if(!db.checkCategoryID(CategoryID)){
				CategoryClassModel m=new CategoryClassModel();
				m.setCategoryID(CategoryID);
				m.setCategoryName(CategoryName);
				m.setCategoryRemark(CategoryRemark);
				db.addCategoryID(m);
				request.getRequestDispatcher("gztm/addGoodsClass.jsp").forward(request, response);
			}else{
				request.setAttribute("dou", "1");
				request.getRequestDispatcher("gztm/addGoodsClass.jsp").forward(request, response);
			}
		}else{
			request.setAttribute("formaterror", "1");
			request.getRequestDispatcher("gztm/addGoodsClass.jsp").forward(request, response);
		}
		
	}

}
