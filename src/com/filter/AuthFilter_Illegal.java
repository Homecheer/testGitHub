package com.filter;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.FilterDao;
import com.model.ScmUser;

public class AuthFilter_Illegal implements Filter{
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)arg0;
		HttpServletResponse resp=(HttpServletResponse)arg1;
		ArrayList<String> al=new ArrayList<String>();
		al.add("/gztm/pomainStatement.jsp");
		al.add("/gztm/queryMoney.jsp");
		al.add("/gztm/ioForm.jsp");
		al.add("/gztm/month_instock_form.jsp");
		al.add("/gztm/month_outstock_form.jsp");
		al.add("/gztm/stockForm.jsp");
		al.add("/gztm/addProduct.jsp");
		al.add("/gztm/addGoodsClass.jsp");
		boolean flag=false;
		for(String a:al){
			if(req.getServletPath().equals((String)a)){
				flag=true;break;
			}
		}		
		if(flag) arg2.doFilter(arg0,arg1);
		else{
			req.setAttribute("powerError","非法访问！");
			req.getRequestDispatcher("/success.jsp").forward(req, resp);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
}
