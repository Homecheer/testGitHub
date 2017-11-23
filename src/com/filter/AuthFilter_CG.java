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
import com.dao.ScmUserDao;
import com.model.ScmUser;

//采购权限过滤
public class AuthFilter_CG implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)arg0;
		HttpServletResponse resp=(HttpServletResponse)arg1;
		ScmUser su=(ScmUser)req.getSession().getAttribute("sUser");
		boolean flag=new FilterDao().checkModelCode(su,"5");
		if(flag) arg2.doFilter(arg0,arg1);
		else{
			req.setAttribute("powerError","您没有采购相关权限");
			req.getRequestDispatcher("/success.jsp").forward(req, resp);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
}
