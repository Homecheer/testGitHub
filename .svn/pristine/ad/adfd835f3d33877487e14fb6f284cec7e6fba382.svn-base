package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.PomainDao_CG;
import com.dao.PomainPageDao;
import com.model.Pomain;
import com.model.PomainPage;
import com.model.PomainSearch;

public class PomainSearchServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String poidPart=req.getParameter("poidPart");
		String timeStart=req.getParameter("timeStart");
		String timeEnd=req.getParameter("timeEnd");
		String venderCode=req.getParameter("venderCode");
		String venderName=req.getParameter("venderName");
		String payType=req.getParameter("payType");
		String status=req.getParameter("status");
		PomainDao_CG pd=new PomainDao_CG();
		
		PomainPage page=new PomainPage();
		page.setPageSize(20);
		PomainPageDao ppd=new PomainPageDao();
		
		pd.searchPomains(page,ppd,0,0,poidPart,timeStart, timeEnd, venderCode, payType,status);
		
		
		
		if(req.getParameter("nowPage")==null||Integer.parseInt(req.getParameter("nowPage"))==0)
			page.setNowPage(1);
		else 
			page.setNowPage(Integer.parseInt(req.getParameter("nowPage"))>page.getToTalPage()?page.getToTalPage():Integer.parseInt(req.getParameter("nowPage")));
		if(page.getToTalPage()>0){
			ppd.setData(new PomainDao_CG().searchPomains(null,null,(page.getNowPage()-1)*page.getPageSize(),page.getPageSize(),poidPart,timeStart, timeEnd, venderCode, payType,status),page);
		}
		req.setAttribute("page",page);
		
		//req.setAttribute("pomains",ps);
		req.setAttribute("pomainSearch",new PomainSearch(poidPart,timeStart,timeEnd,venderName,venderCode,payType,status));
		req.getRequestDispatcher("/PomainBeforeAddServlet?search=search").forward(req,resp);
		//resp.sendRedirect("/Scm/PomainBeforeAddServlet");
		
	}
}
