package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodeFilter implements Filter{
	FilterConfig config;
	String encod;
	public void destroy() {
		this.config=null;
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		if(encod==null){
			encod="utf-8";		
		}
		arg0.setCharacterEncoding(encod);
		arg1.setCharacterEncoding(encod);
		
		arg2.doFilter(arg0, arg1);
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		this.config=arg0;
		encod=arg0.getInitParameter("encod");
	}

}
