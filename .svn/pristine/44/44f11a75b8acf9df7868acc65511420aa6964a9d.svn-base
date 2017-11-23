package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.FinishOrderandtime;
import com.model.GoodsPage;
import com.model.IdWeightModel;
import com.model.SoitemModel;
import com.model.SomainModel;
import com.util.DBUtil1;

public class SellFormServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		DBUtil1 db=new DBUtil1();
		if(request.getParameter("now")!=null){
			
			ArrayList<String> alcusname=db.findcustomname();
			ArrayList<String> alaccount=db.findAccount();
			request.setAttribute("alcusname", alcusname);
			request.setAttribute("alaccount", alaccount);
			//System.out.println(request.getParameter("memory"));
			String now=request.getParameter("now");
			
			if(now==null){
				now="1";
			}
			GoodsPage page=new GoodsPage();
			DBUtil1 gd=new DBUtil1();
			//int nowPage=1;
			//��ǰҳ
			page.setNowPage(Integer.valueOf(now));
			//ÿҳ��ʾ����
			page.setPageSize(1);
			//��ҳ��
			gd.getTotalPage(page,request.getParameter("memory"));
			//��ʾ�����
			gd.getData(page,request.getParameter("memory"));
			request.setAttribute("page", page);
			
			request.setAttribute("memory", request.getParameter("memory"));
			//ArrayList<SomainModel> smm=db.findsomaintime(request.getParameter("memory"));
			//request.setAttribute("smm", smm);
			
		}
		if(request.getParameter("i1")!=null){
			
			//ArrayList<SomainModel> smm=db.findsomaintime(request.getParameter("i1"));
			//request.setAttribute("smm", smm);
			ArrayList<String> alcusname=db.findcustomname();
			ArrayList<String> alaccount=db.findAccount();
			request.setAttribute("alcusname", alcusname);
			request.setAttribute("alaccount", alaccount);
			String now=request.getParameter("now");
			request.setAttribute("memory", request.getParameter("i1"));
	
		if(now==null){
			now="1";
		}
		GoodsPage page=new GoodsPage();
		DBUtil1 gd=new DBUtil1();
		//int nowPage=1;
		//��ǰҳ
		page.setNowPage(Integer.valueOf(now));
		//ÿҳ��ʾ����
		page.setPageSize(1);
		//��ҳ��
		gd.getTotalPage(page,request.getParameter("i1"));
		//��ʾ�����
		gd.getData(page,request.getParameter("i1"));
		request.setAttribute("page", page);
		
		}
		
		
		//ArrayList<FinishOrderandtime> al=db.searchform();
		//request.setAttribute("al", al);
		request.getRequestDispatcher("gztm/showform.jsp").forward(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
	
	}

}
