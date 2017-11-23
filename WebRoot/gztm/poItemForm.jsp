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
    
    <title>My JSP 'update.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/style.css" rel="stylesheet" type="text/css">
	<script language="javascript" src="script/common.js" ></script>
	<script type="text/javascript" src="script/productDiv.js" ></script>
  </head>
  
  <body>
    <div id="update">
<table width="100%"  border="0" align="center" cellspacing="1" class="c">
  <tr>
  	<td align="center">采购单号</td>
  	<td align="center">采购日期</td>
  	<td align="center">付款日期</td>
  	<td align="center">付款金额</td>
  	<td align="center">经手人</td>
  	<td align="center">处理状态</td>
  </tr>
  <c:forEach items="${poList}" var="pl">
  <tr>
  	<td align="center">${pl.poid}</td>
  	<td align="center">${pl.createTime}</td>
  	<td align="center">${pl.payTime}</td>
  	<td align="center">${pl.poTotal}</td>
  	<td align="center">${pl.payUser}</td>
  	<td align="center">已付款</td>
  </tr>
  </c:forEach>
</table>
</div>
<iframe width=174 height=189 name="gToday:normal:agenda.js" id="gToday:normal:agenda.js" src="common/calendar/ipopeng.htm" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; left:-500px; top:0px;"></iframe>
  </body>
</html>
