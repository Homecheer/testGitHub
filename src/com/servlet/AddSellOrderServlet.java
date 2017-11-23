package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.IdWeightModel;
import com.util.DBUtil1;

public class AddSellOrderServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		Date d=new Date();
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		String time=df.format(d);
		DBUtil1 db=new DBUtil1();
		ArrayList<String> al=db.findcustomname();
		ArrayList<String> al1=db.findAccount();
		ArrayList<IdWeightModel> alproduct=db.getIdWeight();
		String ordernumber;
			Calendar now=Calendar.getInstance();
		int year=now.get(Calendar.YEAR);
		int month=now.get(Calendar.MONTH)+1;
		int date=now.get(Calendar.DAY_OF_MONTH); 
		int hours=now.get(Calendar.HOUR);
		int minutes=now.get(Calendar.MINUTE);
		int seconds=now.get(Calendar.SECOND);
			String poid=year+""+month+""+date+""+hours+""+minutes+""+seconds;
			ordernumber=poid;	
		if(request.getAttribute("error1")!=null){
			request.setAttribute("error1", "123");
		}
		if(request.getAttribute("doubleproduct")!=null){
			request.setAttribute("doubleproduct", "123");
		}
		request.setAttribute("ordernumber", ordernumber);
		request.setAttribute("time", time);
		request.setAttribute("al", al);
		request.setAttribute("al1", al1);
		request.setAttribute("alproduct", alproduct);
		request.getRequestDispatcher("gztm/addSale.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

}
