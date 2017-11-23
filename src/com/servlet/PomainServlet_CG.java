package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.PomainPageDao;
import com.dao.PomainDao_CG;
import com.dao.VenderDao;
import com.model.PomainPage;
import com.model.Pomain;
import com.model.ScmUser;

public class PomainServlet_CG extends HttpServlet{

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
		ScmUser su=(ScmUser)req.getSession().getAttribute("sUser");
		PomainPage page=new PomainPage();
		page.setPageSize(5);
		PomainPageDao pd=new PomainPageDao();
		int status=1;//pomain信息返回：0表示全部，1表示新增，2表示已收货，3表示已付款，4表示已了结，5表示已付款
		pd.setToTalPage("pomain where status="+status+" and account='"+su.getAccount()+"'",page);
		if(req.getParameter("nowPage")==null||Integer.parseInt(req.getParameter("nowPage"))==0)
			page.setNowPage(1);
		else 
			page.setNowPage(Integer.parseInt(req.getParameter("nowPage"))>page.getToTalPage()?page.getToTalPage():Integer.parseInt(req.getParameter("nowPage")));
		if(page.getToTalPage()>0){
			pd.setData(new PomainDao_CG().getPomains((page.getNowPage()-1)*page.getPageSize(),page.getPageSize(),status,su.getAccount()),page);
		}
		req.setAttribute("page",page);
		
		//req.setAttribute("Message",(String)req.getAttribute("venderAddMessage"));
		//req.setAttribute("getAddVender",(Vender)req.getAttribute("getAddVender"));
		req.getRequestDispatcher("/gztm/pomain.jsp").forward(req,resp);
	}
	
	
}
