package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.PoitemDao;
import com.dao.ProductDao;
import com.model.Poitem;

public class In_DetialServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String poid = request.getParameter("poid");
		PoitemDao pd= new PoitemDao();
		ArrayList<Poitem> alpoitem =pd.selectPoitemData(poid);
		ProductDao proDao=new ProductDao();
		for(Poitem p:alpoitem){
			String name=proDao.getNameByProductCode(p.getProductCode());
			p.setProductName(name);
		
		}
		
		
		request.setAttribute("alpoitem", alpoitem);
		request.getRequestDispatcher("gztm/in_detail.jsp").forward(request, response);
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
