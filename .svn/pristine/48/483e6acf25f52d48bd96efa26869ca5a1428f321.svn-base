package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.PomainDao_CG;
import com.model.Poitem;
import com.model.Pomain;
import com.model.PomainSearch;

public class PomainShowAllServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String poid=req.getParameter("poid");
		String poidPart=req.getParameter("poidPart");
		String search=req.getParameter("search");
		Pomain p=new PomainDao_CG().getModifyPomain(poid);
		ArrayList<Poitem> pis=new PomainDao_CG().getModifyPoitem(poid);
		req.setAttribute("pomain",p);
		req.setAttribute("poitem",pis);
		if(search!=null&&search.equals("search")){
			String timeStart=req.getParameter("timeStart");
			String timeEnd=req.getParameter("timeEnd");
			String venderCode=req.getParameter("venderCode");
			String venderName=req.getParameter("venderName");
			String payType=req.getParameter("payType");
			String status=req.getParameter("status");
			req.setAttribute("search","search");
			req.setAttribute("pomainSearch",new PomainSearch(poidPart,timeStart,timeEnd,venderName,venderCode,payType,status));
		}
		else{
			String page1=req.getParameter("page1");
			String page2=req.getParameter("page2");
			String page3=req.getParameter("page3");
			
			
			req.setAttribute("page1",page1);
			req.setAttribute("page2",page2);
			req.setAttribute("page3",page3);	
		}
		String nowPage=req.getParameter("nowPage");
		req.setAttribute("nowPage",nowPage);
		req.getRequestDispatcher("/gztm/pomainShowAll.jsp").forward(req,resp);
	}
	
}
