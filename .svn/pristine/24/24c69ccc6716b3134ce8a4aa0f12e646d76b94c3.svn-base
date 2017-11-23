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
    
    <title>My JSP 'SoItem.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link href="css/style.css" rel="stylesheet" type="text/css">
	<script language="javascript" src="script/common.js"></script>

  </head>
  
  <body>
     <table width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td nowrap class="title1">您的位置：工作台面－－采购单明细信息</td>
  </tr>
</table>

<table width="100%"  border="0" align="center" cellspacing="1">
  <tr>
    <td class="title1">采购单编号</td>
    <td class="title1">产品编号</td>
	<td class="title1">产品数量单位</td>
	<td class="title1">产品数量</td>
    <td class="title1">采购单价</td>
 	<td class="title1">产品明细总价</td>
  </tr>
 <c:forEach items="${aPoItems}" var="al">
  <tr>
    <td align="center">${al.poid }</td>
    <td align="center">${al.productCode }</td>
	<td align="center">${al.unitName }</td>
	<td align="center">${al.num }</td>
    <td align="center">${al.unitPrice }</td>
 	<td align="center">${al.itemPrice }</td>
  </tr>
</c:forEach>

  <tr>
  	<td class="title2"></td>
  </tr>
</table>
  </body>
</html>
