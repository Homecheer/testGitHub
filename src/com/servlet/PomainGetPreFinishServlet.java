package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.PomainPageDao;
import com.dao.PomainDao_CG;
import com.model.PomainPage;
import com.model.ScmUser;

public class PomainGetPreFinishServlet extends HttpServlet{
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
		PomainPage page1=setPage(req.getParameter("page1"),"货到付款",su.getAccount());
		PomainPage page2=setPage(req.getParameter("page2"),"款到发货",su.getAccount());
		PomainPage page3=setPage(req.getParameter("page3"),"预付款到发货",su.getAccount());
		
		req.setAttribute("page1",page1);
		req.setAttribute("page2",page2);
		req.setAttribute("page3",page3);
		
		req.getRequestDispatcher("/gztm/pomainFinish.jsp").forward(req,resp);
	}
	public PomainPage setPage(String nowPage,String str,String account){
		PomainPage page=new PomainPage();
		page.setPageSize(5);
		PomainPageDao pd=new PomainPageDao();
		int status=3;
		if(str.equals("款到发货")) status=2;
		pd.setToTalPage("pomain where status="+status+" and payType='"+str+"' and account='"+account+"'",page);
		if(nowPage==null||Integer.parseInt(nowPage)==0)
			page.setNowPage(1);
		else 
			page.setNowPage(Integer.parseInt(nowPage)>page.getToTalPage()?page.getToTalPage():Integer.parseInt(nowPage));
		if(page.getToTalPage()>0){
			pd.setData(new PomainDao_CG().getFinishPomains((page.getNowPage()-1)*page.getPageSize(),page.getPageSize(),str,account),page);
		}
		return page;
	}
}
