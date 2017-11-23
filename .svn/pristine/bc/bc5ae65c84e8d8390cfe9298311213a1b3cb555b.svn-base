package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CategoryDao;
import com.dao.ProductDao;
import com.model.Product;

public class UpdateProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		String productCode = request.getParameter("productCode1");
		String name=request.getParameter("name1");
		String unitName = request.getParameter("unitName");
		String categoryName = request.getParameter("categoryName");
		CategoryDao cd =new CategoryDao();
		int categoryID= cd.selectCategoryID(categoryName);
		String price = request.getParameter("price");
		String remark = request.getParameter("remark");
		Product pro=new Product();
		pro.setProductCode(productCode);
		pro.setName(name);
		pro.setUnitName(unitName);
		pro.setCategoryID(categoryID);
		pro.setPrice(Float.parseFloat(price));
		pro.setRemark(remark);
		ProductDao pd=new ProductDao();
		pd.updateProduct(pro);
		request.getRequestDispatcher("/SelectProduct").forward(request, response);
		
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
