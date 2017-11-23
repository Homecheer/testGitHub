<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>采购单详情</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/style.css" rel="stylesheet" type="text/css">
  </head>
  
  <body>
    <table width="100%" border="0" align="center" cellspacing="1">
		<tr>
			<td class="title1">产品编号</td>
			<td class="title1">产品名称</td>
			<td class="title1">产品数量单位</td>
			<td class="title1">产品数量</td>
			<td class="title1">采购单价</td>
			<td class="title1">产品明细总价</td>
			
		</tr>
		<c:forEach items="${alpoitem }" var="gd">
			<tr>
			<td align="center">${gd.productCode }</td>
			<td align="center">${gd.productName }</td>
			<td align="center">${gd.unitName }</td>
			<td align="center">${gd.num }</td>
			<td align="center">${gd.unitPrice }</td>
			<td align="center">${gd.itemPrice }</td>
			
		</tr>
		</c:forEach>
		
	</table>
  </body>
</html>
