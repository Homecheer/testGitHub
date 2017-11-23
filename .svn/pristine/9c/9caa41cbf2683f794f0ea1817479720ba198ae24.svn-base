package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.FindOrderModel;
import com.util.DBUtil1;

public class EnterFindServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		DBUtil1 db=new DBUtil1();
		ArrayList<String> alname=db.findcustomname();
		ArrayList<String> altime=db.findOrdertime();
		request.setAttribute("altime", altime);
		request.setAttribute("alname", alname);
		request.getRequestDispatcher("gztm/findorder.jsp").forward(request, response);
		
		
		
		
	}

	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		DBUtil1 db=new DBUtil1();
		ArrayList<String> alname=db.findcustomname();
		ArrayList<String> altime=db.findOrdertime();
		request.setAttribute("altime", altime);
		request.setAttribute("alname", alname);
		
		String s1="1=1";
		String s2="1=1";
		String s3="1=1";
		String s4="1=1";
		if(!request.getParameter("i1").equals("")){
			s1="SOID like '%"+request.getParameter("i1")+"%'";
		}
		if(!request.getParameter("i2").equals("")){
			//s2="CreateTime='"+request.getParameter("i2")+"'";
			s2="cast('"+request.getParameter("i2")+"' as datetime)<= cast(CreateTime as datetime)";
			
		}
		if(!request.getParameter("i3").equals("")){
			s3="CustomerCode='"+request.getParameter("i3")+"'";
		}
		if(!request.getParameter("i4").equals("")){
			s4="PayType='"+request.getParameter("i4")+"'";
		}
		
		ArrayList<FindOrderModel> infor=db.findOrderbase(s1, s2, s3, s4);
		request.setAttribute("infor", infor);
		request.getRequestDispatcher("gztm/findorder.jsp").forward(request, response);
		
	}

}
