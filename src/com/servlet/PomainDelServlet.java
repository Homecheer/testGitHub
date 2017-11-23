package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.PomainDao_CG;
import com.dao.VenderDao;

public class PomainDelServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		int n=new PomainDao_CG().delPomain(req.getParameter("poid"));
		//int n=new PomainDao().delPomain(req.getParameter("poid"),(ScmUser)req.getSession().getAttribute("sUser"));
		
		if(n==-1){
			req.setAttribute("Message","非新添状态，无法删除");
		}else if(n==-2){
			req.setAttribute("Message","这不是您的订单，无法删除");
		}
		else if(n==0){//0表示del失败
			req.setAttribute("Message","删除失败");
		}else if(n==1){//1表示del成功
			req.setAttribute("Message","删除成功");
		}
		req.getRequestDispatcher("/PomainServlet").forward(req,resp);
	}
}
