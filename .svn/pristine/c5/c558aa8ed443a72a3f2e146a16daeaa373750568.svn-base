package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.ScmUser;

public class LoginFilter implements Filter{
	
	@Override
	public void destroy() {
	
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)arg0;
		HttpServletResponse resp=(HttpServletResponse)arg1;
		ScmUser sUser=(ScmUser)req.getSession().getAttribute("sUser");
		if (sUser!=null) {
			arg2.doFilter(req, resp);
		}else {
			req.setAttribute("error1", "没有登入不能操作");
			//resp.sendRedirect("/index.jsp");
			req.getRequestDispatcher("/success.jsp").forward(req, resp);
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
		
	}

}
