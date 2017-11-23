package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProductDao;
import com.dao.SoitemDao;
import com.model.Poitem;
import com.model.Soitem;

public class Out_DetialServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String soid = request.getParameter("soid");
		SoitemDao sd=new SoitemDao();
		ArrayList<Soitem> alsoitem=sd.selectSoitemData(soid);
		ProductDao proDao=new ProductDao();
		for(Soitem s:alsoitem){
			String name=proDao.getNameByProductCode(s.getProductCode());
			s.setProductName(name);		
		}
		request.setAttribute("alsoitem", alsoitem);
		request.getRequestDispatcher("gztm/out_detail.jsp").forward(request, response);
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