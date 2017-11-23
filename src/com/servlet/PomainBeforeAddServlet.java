package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.PomainDao_CG;
import com.model.Product;
import com.model.Vender;

public class PomainBeforeAddServlet extends HttpServlet{

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
		PomainDao_CG pd=new PomainDao_CG();
		ArrayList<Vender> al=pd.getAllVenders();
		ArrayList<Product> bl=pd.getAllProducts();
		req.setAttribute("AllVenders",al);
		req.setAttribute("AllProducts",bl);
		String search=req.getParameter("search");
		if(req.getParameter("poid")==null||req.getParameter("poid")==""){
			if(search!=null&&search.equals("search"))
				req.getRequestDispatcher("/gztm/pomainSearch.jsp").forward(req,resp);
			else req.getRequestDispatcher("/gztm/pomainAdd.jsp").forward(req,resp);
		}
		else{
			req.setAttribute("nowPage",req.getParameter("nowPage"));
			req.setAttribute("poid",req.getParameter("poid"));
			req.getRequestDispatcher("/PomainGetModifyServlet").forward(req,resp);
		}
	}
	
}
