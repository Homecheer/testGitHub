package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.PomainDao_CG;
import com.model.PomainPage;
import com.model.ScmUser;

public class PomainFinishServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		ScmUser su=(ScmUser)req.getSession().getAttribute("sUser");
		int n=new PomainDao_CG().finishPomain(req.getParameter("poid"),su.getName());
		if(n==-1){//
			req.setAttribute("Message","这不是您的订单,无法了结");
		}else if(n==0){//0表示修改失败
			req.setAttribute("Message","了结失败");
		}else if(n==1){//1表示修改成功
			req.setAttribute("Message","了结成功");
		}
		req.setAttribute("page1",req.getParameter("page1"));
		req.setAttribute("page2",req.getParameter("page2"));
		req.setAttribute("page3",req.getParameter("page3"));
		
		req.getRequestDispatcher("/PomainGetPreFinishServlet").forward(req,resp);
	}
	
}
