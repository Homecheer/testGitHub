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

public class AddProductServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		String productCode=request.getParameter("productCode");
		String name= request.getParameter("name1");
		String categoryName= request.getParameter("categoryName");
		CategoryDao cd= new CategoryDao();
		ArrayList<Category> alCategory=cd.allCategory();
		request.setAttribute("alCategory", alCategory);
		int categoryID=cd.selectCategoryID(categoryName);
		String price= request.getParameter("price");
		String unitName= request.getParameter("unitName");
		String remark= request.getParameter("remark");
		//System.out.println(productCode+name+categoryID+price+unitName+remark);
		Product pro =new Product();
		pro.setProductCode(productCode);
		pro.setCategoryID(categoryID);
		pro.setName(name);
		pro.setPrice(Float.parseFloat(price));
		pro.setUnitName(unitName);
		pro.setRemark(remark);
		ProductDao pd=new ProductDao();
		String productCodeResult=pd.productCodeHasExist(productCode);
		if(productCodeResult==null){
			pd.addProduct(pro);			
			request.getRequestDispatcher("/SelectProduct").forward(request, response);
		}else{
			
			request.setAttribute("productCodeHasExist", "产品编码已经存在,无法添加");
			request.getRequestDispatcher("gztm/addProduct.jsp").forward(request, response);
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
