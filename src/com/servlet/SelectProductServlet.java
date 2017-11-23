package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CategoryDao;
import com.dao.ProductDao;
import com.model.Category;
import com.model.Product;

public class SelectProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		ProductDao productDao=new ProductDao();
		ArrayList<Product> alProduct=productDao.AllProduct();
		CategoryDao categoryDao =new CategoryDao();
		ArrayList<Category> alCategory=categoryDao.allCategory();
		request.setAttribute("alProduct", alProduct);
		request.setAttribute("alCategory", alCategory);
		request.getRequestDispatcher("gztm/goods.jsp").forward(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		
	}

}
