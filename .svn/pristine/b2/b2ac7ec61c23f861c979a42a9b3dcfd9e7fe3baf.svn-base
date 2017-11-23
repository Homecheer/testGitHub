package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.VenderDao;
import com.model.Vender;

public class VenderAddServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//System.out.println(req.getParameter("venderCode")+" "+req.getParameter("name")+" "+req.getParameter("password")+" "+req.getParameter("contactor")+" "+req.getParameter("address")+" "+req.getParameter("postcode")+" "+req.getParameter("tel")+" "+req.getParameter("fax")+" "+req.getParameter("createDate"));
		
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		Vender v=new Vender(req.getParameter("venderCode"),req.getParameter("name"),req.getParameter("password"),req.getParameter("contactor"),req.getParameter("address"),req.getParameter("postcode"),req.getParameter("tel"),req.getParameter("fax"),req.getParameter("createDate"));
		int n=new VenderDao().addVender(v);
		if(n==-1){//有重复
			//req.setAttribute("getAddVender",v);
			PrintWriter out=resp.getWriter();
			out.print("已有该供应商编号");
			out.flush();
			out.close();
			return;
		}
		else if(n==0){
			req.setAttribute("Message","添加失败");
		}else if(n==1){
			req.setAttribute("Message","添加成功");
		}else{
			return;
		}
		req.getRequestDispatcher("/VenderServlet").forward(req,resp);
	}
	
}
