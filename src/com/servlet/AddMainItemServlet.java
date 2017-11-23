package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.DBUtil1;

public class AddMainItemServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String i1 = request.getParameter("i1");
		String i2 = request.getParameter("i2");
		String i3 = request.getParameter("i3");
		String i4 = request.getParameter("i4");
		
	
		String i7 = request.getParameter("i7");
	
		
		int status=1;
		String reg5="^[0-9]+([.]{1}[0-9]+){0,1}$";
		
		
		boolean b1=true;
		boolean b2=true;
		String[] spbm=request.getParameterValues("spbm");
		String[] danjia=request.getParameterValues("spzl");
		String[] numb=request.getParameterValues("ytsl");
		String[] shuliangdanwei=request.getParameterValues("sptj");
		
		String regspbm="[0-9a-zA-Z]{1,20}";
		String regnumb="^[0-9]+([.]{1}[0-9]+){0,1}$";
		if(spbm!=null){
			for(String s:spbm){
			if(!s.matches(regspbm)){
				b1=false;
			}
		}
		for(String s:numb){
			if(!s.matches(regnumb)){
				b2=false;
			}
		}
		}else{
			b1=false;
		}
		
		
		DBUtil1 db=new DBUtil1();
		
		if(!i7.equals("Ô¤¸¶¿î·¢»õ")){
			if(request.getParameter("i5").matches(reg5)&&b1&&b2){
				float i8=0;
				try {
					float i5 = Float.parseFloat(request.getParameter("i5"));
					float i6 = 0;
					float allprice=0;
					if(db.addsellorderboth(i1, i2, i3, i4, i5, i6, allprice, i7,
							i8, status, spbm, danjia, numb, shuliangdanwei
							)){
						db.setprice(i1, i5);
						request.getRequestDispatcher("/AddSellOrderServlet").forward(request, response);
					}else{
						request.setAttribute("doubleproduct", "123");
						request.getRequestDispatcher("/AddSellOrderServlet").forward(request, response);
					}
					
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}else{
				request.setAttribute("error1", "123");
				request.getRequestDispatcher("/AddSellOrderServlet").forward(request, response);
			}
		}else{
			if(request.getParameter("i5").matches(reg5)&&b1&&b2){
				float i5 = Float.parseFloat(request.getParameter("i5"));
				float i6 = 0;
				float allprice=0;
				float i8=allprice/10;
				try {
					if(db.addsellorderboth(i1, i2, i3, i4, i5, i6, allprice, i7,
							i8, status, spbm, danjia, numb, shuliangdanwei
							)){
						db.setprice(i1, i5);
					db.setprepay(i1, i5);
					request.getRequestDispatcher("AddSellOrderServlet").forward(request, response);
					}else{
						request.setAttribute("doubleproduct", "123");
						request.getRequestDispatcher("/AddSellOrderServlet").forward(request, response);
					}
					
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}else{
				request.setAttribute("error1", "123");
				request.getRequestDispatcher("AddSellOrderServlet").forward(request, response);
			}
		}	
	}

}
