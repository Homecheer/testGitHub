package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.VenderDao;
import com.model.Vender;

public class VenderGetModifyServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		Vender v=new VenderDao().getModifyVender(req.getParameter("venderCode"));
		req.setAttribute("getAddVender",v);
		req.setAttribute("getModifyVender","getModifyVender");
		req.getRequestDispatcher("/VenderServlet").forward(req,resp);
	}
	
}
