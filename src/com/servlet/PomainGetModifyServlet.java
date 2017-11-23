package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.PomainDao_CG;
import com.model.Poitem;
import com.model.Pomain;

public class PomainGetModifyServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String poid=(String)req.getAttribute("poid");
		PomainDao_CG pd=new PomainDao_CG();
		int n=pd.modifyStatus(poid);
		if(n==-1){
			req.setAttribute("Message","非新增状态，无法修改");
		}else if(n==-2){
			req.setAttribute("Message","这不是您的订单，无法修改");
		}
		else if(n==0){
			req.setAttribute("Message","数据异常,操作失败");
		}else if(n==1){
			Pomain pm=pd.getModifyPomain(poid);
			ArrayList<Poitem> pis=pd.getModifyPoitem(poid);
			req.setAttribute("getPomain",pm);
			req.setAttribute("getPoitem",pis);
			req.getRequestDispatcher("/gztm/pomainAdd.jsp").forward(req,resp);
			return;
		}
		req.getRequestDispatcher("/PomainServlet").forward(req,resp);	
	}
	
}
