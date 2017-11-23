package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CustomerDao;
import com.dao.SomainDao;
import com.model.Pomain;
import com.model.Somain;

public class SelectPayTypeSomainServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String payType = request.getParameter("PayType");
		
		SomainDao sd =new SomainDao();
		ArrayList<Somain> alSO =sd.OneSO_OnePayType(payType);
		CustomerDao cd=new CustomerDao();
		for(Somain s:alSO){
			String name =cd.getNameByCustomerCode(s.getCustomerCode());
			s.setCustomerName(name);
		}
		request.setAttribute("alSO", alSO);
		request.getRequestDispatcher("gztm/outstock.jsp").forward(request, response);
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
