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
import com.model.PomainStatement;

public class PomainStatementServlet extends HttpServlet {
	
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
		String year=req.getParameter("year");
		String mon=req.getParameter("mon");
		String month=mon;
		if(mon.length()==1) month="0"+mon;
		//PomainDao pd=new PomainDao();
		PomainStatement ps=new PomainStatement();
		//ArrayList<Pomain> al=pd.getPomainStatement(year+month, ps);
		req.setAttribute("year",year);
		req.setAttribute("mon",mon);
		
		PomainPage page=new PomainPage();
		page.setPageSize(20);
		PomainPageDao ppd=new PomainPageDao();
		ppd.setToTalPage("pomain where poid like '%"+year+month+"%'",page);
		if(req.getParameter("nowPage")==null||Integer.parseInt(req.getParameter("nowPage"))==0)
			page.setNowPage(1);
		else 
			page.setNowPage(Integer.parseInt(req.getParameter("nowPage"))>page.getToTalPage()?page.getToTalPage():Integer.parseInt(req.getParameter("nowPage")));
		if(page.getToTalPage()>0){
			ppd.setData(new PomainDao_CG().getPomainStatement((page.getNowPage()-1)*page.getPageSize(),page.getPageSize(),year+month, ps),page);
		}
		req.setAttribute("page",page);
		
		req.setAttribute("pomainSt",ps);
		//req.setAttribute("pomainSts",al);
		req.getRequestDispatcher("/gztm/pomainStatement.jsp").forward(req,resp);
	}

}
