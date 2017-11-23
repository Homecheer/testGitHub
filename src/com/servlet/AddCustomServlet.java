package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.CustomClassModel;
import com.util.DBUtil1;

public class AddCustomServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String CustomerCode=request.getParameter("CustomerCode");
		DBUtil1 db=new DBUtil1();
		//System.out.println(db.checkCustomerCodeSale(CustomerCode));
		if(!db.checkCustomerCodeSale(CustomerCode)){
			db.deletecustom(CustomerCode);
			ArrayList<CustomClassModel> al=db.updatecustom();
			request.setAttribute("sucss", "1");
			request.setAttribute("al", al);
			request.getRequestDispatcher("xxcx/dlqy.jsp").forward(request, response);
		}else{
			request.setAttribute("dou", "1");
			ArrayList<CustomClassModel> al=db.updatecustom();
			request.setAttribute("al", al);
			request.getRequestDispatcher("xxcx/dlqy.jsp").forward(request, response);
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		DBUtil1 db=new DBUtil1();
		String text1=request.getParameter("text1");
		String text2=request.getParameter("text2");
		String text3=request.getParameter("text3");
		String text4=request.getParameter("text4");
		String text5=request.getParameter("text5");
		String text6=request.getParameter("text6");
		String text7=request.getParameter("text7");
		String text8=request.getParameter("text8");
		Date d=new Date();
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 
		String text9=df.format(d);
		String text10=request.getParameter("text10");
		String t1="[0-9a-zA-Z]{4,20}";
		String t2="[0-9a-zA-Z]{1,100}";
		String t3="[0-9a-zA-Z]{4,20}";
		String t4="[0-9a-zA-Z]{1,10}";
		String t5="[0-9a-zA-Z]{1,100}";
		String t6="[0-9a-zA-Z]{0,8}";
		String t7="[0-9a-zA-Z]{1,20}";
		String t8="[0-9a-zA-Z]{0,20}";
		
		String t10="change";
		//System.out.println(text10);
		//System.out.println(text1);
		//System.out.println(text2);
		//System.out.println(t10.equals(text10));
		if(t10.equals(text10)){
			if(text1.matches(t1)&&text2.matches(t2)&&text3.matches(t3)&&text4.matches(t4)&&text5.matches(t5)&&text6.matches(t6)&&text7.matches(t7)&&text8.matches(t8)){
				db.changecustomer(text1, text2, text3, text4, text5, text6, text7, text8, text9);
				request.setAttribute("sucss", "1");
				ArrayList<CustomClassModel> al=db.updatecustom();
				request.setAttribute("al", al);
				request.getRequestDispatcher("xxcx/dlqy.jsp").forward(request, response);
			}else{
				request.setAttribute("formaterror", "1");
				ArrayList<CustomClassModel> al=db.updatecustom();
				request.setAttribute("al", al);
				request.getRequestDispatcher("xxcx/dlqy.jsp").forward(request, response);
			}
		}else{
			if(text1.matches(t1)&&text2.matches(t2)&&text3.matches(t3)&&text4.matches(t4)&&text5.matches(t5)&&text6.matches(t6)&&text7.matches(t7)&&text8.matches(t8)){
			if(!db.checkCustomerCode(text1)){
				db.addcustomer(text1, text2, text3, text4, text5, text6, text7, text8, text9);
				request.setAttribute("sucss", "1");
				ArrayList<CustomClassModel> al=db.updatecustom();
				request.setAttribute("al", al);
				request.getRequestDispatcher("xxcx/dlqy.jsp").forward(request, response);
			}else{
				request.setAttribute("dou", "1");
				ArrayList<CustomClassModel> al=db.updatecustom();
				request.setAttribute("al", al);
				request.getRequestDispatcher("xxcx/dlqy.jsp").forward(request, response);
			}
		}else{
			request.setAttribute("formaterror", "1");
			ArrayList<CustomClassModel> al=db.updatecustom();
			request.setAttribute("al", al);
			request.getRequestDispatcher("xxcx/dlqy.jsp").forward(request, response);
		}
		}
		
	}

}
