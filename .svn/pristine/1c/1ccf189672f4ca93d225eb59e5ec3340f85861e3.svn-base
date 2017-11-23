package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.OrderandPaytype;
import com.model.ScmUser;
import com.model.SomainModel;
import com.util.DBUtil1;

public class FinishServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		ScmUser su=(ScmUser)request.getSession().getAttribute("sUser");
		//String account ="aa";
		DBUtil1 db=new DBUtil1();
		if(request.getParameter("finish")!=null){
			try {
				db.finishso(request.getParameter("soid"));
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		ArrayList<OrderandPaytype> al=db.selectfinishso(su.getAccount());
		if(request.getParameter("show")!=null){
			SomainModel sm=db.findsomain(request.getParameter("soid"));
			request.setAttribute("sm", sm);	
		}
		
		
		request.setAttribute("al", al);
		request.setAttribute("account", su.getAccount());
		request.getRequestDispatcher("xxcx/ljso.jsp").forward(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		
	}

}
