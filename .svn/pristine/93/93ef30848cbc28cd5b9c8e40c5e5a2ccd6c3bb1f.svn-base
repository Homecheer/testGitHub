package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.VenderDao;
import com.model.Vender;

public class VenderDelServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		int n=new VenderDao().delVender(req.getParameter("venderCode"));
		if(n==-1){//-1表示有相关的订单，
			req.setAttribute("Message","尚有相关联的订单，无法删除");
		}
		else if(n==0){//0表示del失败
			req.setAttribute("Message","删除失败");
		}else if(n==1){//1表示del成功
			req.setAttribute("Message","删除成功");
		}
		req.getRequestDispatcher("/VenderServlet").forward(req,resp);
	}
	
}
