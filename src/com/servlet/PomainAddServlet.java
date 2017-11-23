package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.PomainDao_CG;

public class PomainAddServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		
		String poid=req.getParameter("poid");
		String createTime=req.getParameter("createTime");
		String venderCode=req.getParameter("venderCode");
		String account=req.getParameter("account");
		String tipFee=req.getParameter("tipFee");
		String productTotal=req.getParameter("productTotal");
		String payType=req.getParameter("payType");
		String prePayFee=req.getParameter("prePayFee");
		String remark=req.getParameter("textfield");
		String[] productCodes=req.getParameterValues("productCode");
		String[] unitNames=req.getParameterValues("unitName");
		String[] nums=req.getParameterValues("num");
		String[] unitPrices=req.getParameterValues("unitPrice");
//		System.out.println("vendercode."+venderCode+".");
//		System.out.println("account."+account+".");
//		System.out.println("remark."+remark+".");
		int n=new PomainDao_CG().addPomain(true,poid,createTime,venderCode,account,tipFee,productTotal,payType,remark,prePayFee,productCodes,unitNames,nums,unitPrices);
		if(n==1){
			req.setAttribute("Message","添加成功");
		}
		else if(n==0){
			req.setAttribute("Message","添加失败");
		}
		req.getRequestDispatcher("/PomainServlet").forward(req,resp);
	}
	
}











