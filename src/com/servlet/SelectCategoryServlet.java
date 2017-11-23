package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CategoryDao;
import com.model.Category;
import com.model.CategoryPage;

public class SelectCategoryServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		String nowPage=request.getParameter("nowPage");
		if(nowPage==null){
			nowPage="1";
		}
		
		CategoryPage cp=new CategoryPage();
		CategoryDao cd=new CategoryDao();
		cp.setPageSize(2);
		cp.setNowPage(Integer.parseInt(nowPage));
		cd.getData(cp);
		cd.getTotalPage(cp);
		
		ArrayList<Category> alCategory=cd.allCategory();
		request.getSession().setAttribute("alCategory", alCategory);
		request.getSession().setAttribute("cp", cp);
		request.getRequestDispatcher("gztm/goodsClass.jsp").forward(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		
	}

}
