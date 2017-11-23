package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.dao.QueryInOrOutDao;
import com.model.Pomain;
import com.model.Somain;
import com.sun.mail.handlers.text_plain;

public class QueryInOrOutServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/plain");
		QueryInOrOutDao qDao=new QueryInOrOutDao();
		String startTime=request.getParameter("startTime");
		String endTime=request.getParameter("endTime");
		String ioType=request.getParameter("ioType");
		String payType=request.getParameter("payType");
		String id=request.getParameter("id");
		String sql="";
		String sqlAll="";
		if (ioType.equals("收入")) {
			if (!endTime.equals("")) {
				sql+="and (paytime > '"+startTime+"'"+" and paytime < DATE_ADD('"+endTime+"',INTERVAL 1 DAY))";
			}
			if (!payType.equals("")) {
				sql+="and paytype="+"'"+payType+"'";
			}
			if (!id.equals("")) {
				sql+="and soid like '%"+id+"%'";
			}
			if (sql.length()!=0) {
				sqlAll="select soid,paytime,sototal,payuser,paytype,prepaytime,prepayuser from somain where 1=1 "+sql+"and (paytime is not null)";
			}else {
				sqlAll="select soid,paytime,sototal,payuser,paytype,prepaytime,prepayuser from somain where paytime is not null ";
			}
			ArrayList<Somain> aList=qDao.getSoMains(sqlAll);
			String json=JSONArray.toJSONString(aList);
			PrintWriter out = response.getWriter();
			out.print(json);
			/*request.setAttribute("soAlist", aList);
			request.getRequestDispatcher("gztm/queryMoney.jsp").forward(request, response);*/
		}else {
			if (!endTime.equals("")) {
				sql+="and (paytime > '"+startTime+"'"+" and paytime < DATE_ADD('"+endTime+"',INTERVAL 1 DAY))";
			}
			if (!payType.equals("")) {
				sql+="and paytype="+"'"+payType+"'";
			}
			if (!id.equals("")) {
				sql+="and poid like '%"+id+"%'";
			}
			if (sql.length()!=0) {
				sqlAll="select poid,paytime,pototal,payuser,paytype,prepaytime,prepayuser from pomain where 1=1 "+sql+"and (paytime is not null )";
			}else {
				sqlAll="select poid,paytime,pototal,payuser,paytype,prepaytime,prepayuser from pomain where paytime is not null";
			}
			ArrayList<Pomain> aPoMains=qDao.getPoMains(sqlAll);
			String json=JSONArray.toJSONString(aPoMains);
			PrintWriter out = response.getWriter();
			out.print(json);
			/*request.setAttribute("poAlist", aPoMains);
			request.getRequestDispatcher("gztm/queryMoney.jsp").forward(request, response);*/
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}
