package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.PomainDao;
import com.dao.VenderDao;
import com.model.Pomain;

public class SelectPayTypePomainServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String payType = request.getParameter("PayType");
		PomainDao pd =new PomainDao();
		ArrayList<Pomain> alPO =pd.OnePO_OnePayType(payType);
		VenderDao vd=new VenderDao();
		for(Pomain p:alPO){
			String name = vd.getNameByVenderCode(p.getVenderCode());
			p.setVenderName(name);
		}
		request.setAttribute("alPO", alPO);
		request.getRequestDispatcher("gztm/instock.jsp").forward(request, response);
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
