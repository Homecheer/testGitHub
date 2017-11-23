package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.PomainPageDao;
import com.dao.VenderDao;
import com.model.PomainPage;
import com.model.Vender;

public class VenderServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");		
		PomainPage page=new PomainPage();
		page.setPageSize(5);
		PomainPageDao pd=new PomainPageDao();
		pd.setToTalPage("vender",page);
		if(req.getParameter("nowPage")==null||Integer.parseInt(req.getParameter("nowPage"))==0)
			page.setNowPage(1);
		else 
			page.setNowPage(Integer.parseInt(req.getParameter("nowPage"))>page.getToTalPage()?page.getToTalPage():Integer.parseInt(req.getParameter("nowPage")));
		if(page.getToTalPage()>0)
			pd.setData(new VenderDao().getVenders((page.getNowPage()-1)*page.getPageSize(),page.getPageSize()),page);
		
		req.setAttribute("page",page);
		//req.setAttribute("venderAddMessage",(String)req.getAttribute("venderAddMessage"));
		//req.setAttribute("getAddVender",(Vender)req.getAttribute("getAddVender"));
		req.getRequestDispatcher("/gztm/vender.jsp").forward(req,resp);
	}
	
	
}
