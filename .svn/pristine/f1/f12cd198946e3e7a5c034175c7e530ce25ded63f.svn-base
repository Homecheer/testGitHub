package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.VenderDao;
import com.model.Vender;

public class VenderModifyServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		int n=new VenderDao().modifyVender(new Vender(req.getParameter("venderCode"),req.getParameter("name"),req.getParameter("password"),req.getParameter("contactor"),req.getParameter("address"),req.getParameter("postcode"),req.getParameter("tel"),req.getParameter("fax"),req.getParameter("createDate")));
		if(n==0){//0表示修改失败
			req.setAttribute("Message","修改失败");
		}else if(n==1){//1表示修改成功
			req.setAttribute("Message","修改成功");
		}
		String nowPage=req.getParameter("nowPage");
		req.getRequestDispatcher("/VenderServlet?nowPage="+nowPage).forward(req,resp);
	}

}
