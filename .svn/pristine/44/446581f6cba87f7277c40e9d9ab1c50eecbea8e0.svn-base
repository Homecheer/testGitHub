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
import com.model.Product;

public class DeleteCategoryServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		String categoryID = request.getParameter("categoryID");
		ProductDao pd=new ProductDao();
		ArrayList<Product> alIDHasBeUsed=pd.categoryIDHasBeUsed(Integer.parseInt(categoryID));
		if(alIDHasBeUsed.size()==0){
			CategoryDao cd= new CategoryDao();
			cd.deleteCategory(Integer.parseInt(categoryID));			
			request.getRequestDispatcher("/SelectCategory").forward(request, response);
		}else{
			request.setAttribute("categoryIDHasBeUsed", "该类别已经被引用，无法删除");
			request.getRequestDispatcher("/SelectCategory").forward(request, response);
		}
		
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
