package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProductDao;
import com.dao.StockDao;

public class DeleteProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String arr =request.getParameter("arr");
		String[] beCheckedProductCode = arr.split("-");
		
		ProductDao pd= new ProductDao();
		String[] productCodeInPoitem = pd.productCodeHasBeUsedInPoitem(beCheckedProductCode);
		String[] productCodeInSoitem = pd.productCodeHasBeUsedInSoitem(beCheckedProductCode);
		ArrayList<String> alproductCodeInPoitem=new ArrayList<String>();
		ArrayList<String> alproductCodeInSoitem=new ArrayList<String>();
		for(String code:productCodeInPoitem){
			if(code!=null){
				alproductCodeInPoitem.add(code);	
			}
		}
		for(String code:productCodeInSoitem){
			if(code!=null){
				alproductCodeInSoitem.add(code);					
			}
		}
		StockDao sd=new StockDao();
		ArrayList<String> alGreaterThanZeroProductCode=sd.productStockNumIsGreaterThanZero(beCheckedProductCode);
		if(beCheckedProductCode.length==1){
			//里面只有一个null，说明没有选中的对象
			request.setAttribute("noSelect", "没有选择对象");
			request.getRequestDispatcher("/SelectProduct").forward(request, response);
		}else if(alproductCodeInPoitem.size()==0&&alproductCodeInSoitem.size()==0&&alGreaterThanZeroProductCode.size()==0){
			//都没有被引用 ，                 通过，进行删除操作
			sd.deleteProduct(beCheckedProductCode);
			pd.deleteProduct(beCheckedProductCode);
			request.setAttribute("deleteSuccess", "删除成功");
			request.getRequestDispatcher("/SelectProduct").forward(request, response);
		}else if(alproductCodeInPoitem.size()!=0||alproductCodeInSoitem.size()!=0||alGreaterThanZeroProductCode.size()>0){
			//有其一或2个都不会空，说明被引用    或者库存数大于0。不通过，显示错误，传值
			request.setAttribute("alproductCodeInPoitem", alproductCodeInPoitem);
			request.setAttribute("alproductCodeInSoitem", alproductCodeInSoitem);
			
			request.setAttribute("alGreaterThanZeroProductCode", alGreaterThanZeroProductCode);
			request.getRequestDispatcher("/SelectProduct").forward(request, response);
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
