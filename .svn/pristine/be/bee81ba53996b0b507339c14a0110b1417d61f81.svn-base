package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.IdWeightModel;
import com.model.SoitemModel;
import com.model.SomainModel;
import com.util.DBUtil1;

public class ShowDetail extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String gowhere =null;
		DBUtil1 db=new DBUtil1();
		if(request.getParameter("del1")!=null){
			try {
				if(db.selectstatus(request.getParameter("del1"))){
					db.deletesoitem(request.getParameter("del1"), request.getParameter("del2"));
					db.setprice(request.getParameter("num"),db.selecttipfee(request.getParameter("num")));	
				}else{
					request.setAttribute("statuserror", "123");
				}
				
			} catch (SQLException e) {
				//System.out.println(123);
				e.printStackTrace();
			}
		}
		if(request.getParameter("add")!=null){
			String regnumb="^[0-9]+([.]{1}[0-9]+){0,1}$";
			if(request.getParameter("spnum").matches(regnumb)&&request.getParameter("danjia").matches(regnumb)){
				if(!db.onlyaddsoitem(request.getParameter("num"), request.getParameter("spbm"), request.getParameter("spnum"), request.getParameter("danjia"), request.getParameter("shuliangdanwei"))){
					request.setAttribute("doubleproduct", "123");
				}else{
					db.setprice(request.getParameter("num"), db.selecttipfee(request.getParameter("num")));
				}
				
			}else{
				request.setAttribute("err", "123");
			}
		}
		if(request.getParameter("savechange")!=null){
			String regnumb="^[0-9]+([.]{1}[0-9]+){0,1}$";
			if(request.getParameter("t5").matches(regnumb)){
				if(request.getParameter("t8").equals("预付款到发货")){
				SomainModel sm=new SomainModel(request.getParameter("num"), request.getParameter("t2"), request.getParameter("t3"), "a", Float.parseFloat(request.getParameter("t5")), 0, 0, request.getParameter("t8"), 0, 1, " ", request.getParameter("t12"), request.getParameter("t13"), request.getParameter("t14"), request.getParameter("t15"), request.getParameter("t16"), request.getParameter("t17"), request.getParameter("t18"), request.getParameter("t19"));
				db.updatesomain(sm);
				db.setprice(request.getParameter("num"), db.selecttipfee(request.getParameter("num")));
				db.setprepay(request.getParameter("num"), Float.parseFloat(request.getParameter("t5")));
				}else{
					SomainModel sm=new SomainModel(request.getParameter("num"), request.getParameter("t2"), request.getParameter("t3"), "a", Float.parseFloat(request.getParameter("t5")), 0, 0, request.getParameter("t8"), 0, 1, " ", request.getParameter("t12"), request.getParameter("t13"), request.getParameter("t14"), request.getParameter("t15"), request.getParameter("t16"), request.getParameter("t17"), request.getParameter("t18"), request.getParameter("t19"));
					db.updatesomain(sm);
					db.setprice(request.getParameter("num"), db.selecttipfee(request.getParameter("num")));
					db.setprepay(request.getParameter("num"));
				}
				
			}else{
				request.setAttribute("err", "123");
			}
			
			
		}
		if(request.getParameter("delmain")!=null){
			try {
				if(db.selectstatus(request.getParameter("num"))){
					db.delmain(request.getParameter("num"));
					request.setAttribute("successdel", 123);
					gowhere="back";
				}else{
					request.setAttribute("statuserror", "123");				
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				request.setAttribute("faildel", 123);
			}
			
			
		}
		ArrayList<IdWeightModel> alproduct=db.getIdWeight();
		SomainModel sm=db.findsomain(request.getParameter("num"));
		request.setAttribute("sm", sm);
		ArrayList<String> alcusname=db.findcustomname();
		ArrayList<SoitemModel> al=db.findsoitem(request.getParameter("num"));	
		ArrayList<String> alaccount=db.findAccount();
		request.setAttribute("al", al);
		request.setAttribute("alproduct", alproduct);
		request.setAttribute("alcusname", alcusname);
		request.setAttribute("alaccount", alaccount);
		if(gowhere!=null){
			request.getRequestDispatcher("gztm/findorder.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("gztm/showdetail.jsp").forward(request, response);
		}
		
		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
	}

}
